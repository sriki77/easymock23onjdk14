/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.AbstractMatcher;
import org.easymock.ArgumentsMatcher;
import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class ArgumentsMatcherTest extends TestCase {

    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createStrictControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testExpectedArgumentsDelegatedToMatcher() {
        mock.twoArgumentMethod(0, 5);
        control.setMatcher(new AbstractMatcher() {
            public boolean matches(Object[] expected, Object[] actual) {
                assertEquals(0, ((Integer) expected[0]).intValue());
                assertEquals(5, ((Integer) expected[1]).intValue());
                assertEquals(1, ((Integer) actual[0]).intValue());
                assertEquals(6, ((Integer) actual[1]).intValue());
                return true;
            }
        });
        mock.simpleMethod();
        control.replay();
        mock.twoArgumentMethod(1, 6);
        mock.simpleMethod();
        control.verify();
    }

    public void testExpectedArgumentsDelegatedToMatcher2() {
        mock.threeArgumentMethod(7, "", "A test");
        control.setMatcher(new AbstractMatcher() {
            public boolean matches(Object[] expected, Object[] actual) {
                int expectedInt = ((Integer) expected[0]).intValue();
                int actualInt = ((Integer) actual[0]).intValue();
                return expectedInt < actualInt;
            }
        });
        control.setReturnValue("1");
        mock.threeArgumentMethod(6, "", "A test");
        control.setReturnValue("2");
        mock.threeArgumentMethod(12, "", "A test");
        control.setReturnValue("3");

        control.replay();
        mock.threeArgumentMethod(9, "test", "test");
        mock.threeArgumentMethod(8, "test", "test");
        mock.threeArgumentMethod(13, "test", "test");
        control.verify();
    }

    public void testErrorString() {
        mock.twoArgumentMethod(0, 5);
        control.setMatcher(new ArgumentsMatcher() {
            public boolean matches(Object[] expected, Object[] actual) {
                return false;
            }

            public String toString(Object[] arguments) {
                return "<<" + arguments[0] + ">>";
            }
        });
        control.replay();
        boolean failed = false;
        try {
            mock.twoArgumentMethod(1, 5);
        } catch (AssertionError expected) {
            failed = true;
            assertEquals("\n  Unexpected method call twoArgumentMethod(1, 5):"
                    + "\n    twoArgumentMethod(<<0>>): expected: 1, actual: 0",
                    expected.getMessage());
        }
        if (!failed) {
            fail("exception expected");
        }
    }

    public void testSettingTheSameMatcherIsOk() {
        try {
            mock.twoArgumentMethod(1, 2);
            control.setMatcher(MockControl.ARRAY_MATCHER);
            control.setMatcher(MockControl.ARRAY_MATCHER);
            mock.twoArgumentMethod(1, 2);
            control.setMatcher(MockControl.ARRAY_MATCHER);

        } catch (IllegalStateException unexpected) {
            fail("no exception should be thrown if the same matcher is set twice");
        }
    }

    public void testAbstractMatcher() {
        AbstractMatcher trueMatcher = new AbstractMatcher() {
            protected boolean parameterMatches(Object expected, Object actual) {
                return true;
            }
        };
        Object[] arrayWithNull = new Object[] { null };
        Object[] arrayWithObject = new Object[] { new Object() };
        assertFalse(trueMatcher.matches(arrayWithNull, arrayWithObject));
        assertFalse(trueMatcher.matches(arrayWithObject, arrayWithNull));
    }

    public void testAbstractMatcherToStringHandlesNullArray() {
        AbstractMatcher matcher = new AbstractMatcher() {
        };
        assertEquals("", matcher.toString(null));
    }

}