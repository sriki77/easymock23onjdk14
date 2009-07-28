/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class UsageTest extends TestCase {

    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock =  (IMethods) control.getMock();
    }

    public void testExactCallCountByLastCall() {
        mock.oneArg(false);
        control.setReturnValue("Test");
        control.setReturnValue("Test2");

        control.replay();

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));

        boolean failed = false;
        try {
            mock.oneArg(false);
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed)
            fail("expected AssertionError");
    }

    public void testOpenCallCountByLastCall() {
        mock.oneArg(false);
        control.setReturnValue("Test");
        control.setReturnValue("Test2", MockControl.ONE_OR_MORE);

        control.replay();

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));
    }

    public void testExactCallCountByLastThrowable() {
        mock.oneArg(false);
        control.setReturnValue("Test");
        control.setReturnValue("Test2");
        control.setThrowable(new IndexOutOfBoundsException(), 1);

        control.replay();

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));

        try {
            mock.oneArg(false);
        } catch (IndexOutOfBoundsException expected) {
        }

        boolean failed = true;
        try {
            try {
                mock.oneArg(false);
            } catch (IndexOutOfBoundsException expected) {
            }
            failed = false;
        } catch (AssertionError expected) {
        }
        if (!failed)
            fail("expected AssertionError");
    }

    public void testOpenCallCountByLastThrowable() {
        mock.oneArg(false);
        control.setReturnValue("Test");
        control.setReturnValue("Test2");
        control.setThrowable(new IndexOutOfBoundsException(),
                MockControl.ONE_OR_MORE);

        control.replay();

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));

        try {
            mock.oneArg(false);
        } catch (IndexOutOfBoundsException expected) {
        }
        try {
            mock.oneArg(false);
        } catch (IndexOutOfBoundsException expected) {
        }
    }

    public void testMoreThanOneArgument() {
        mock.threeArgumentMethod(1, "2", "3");
        control.setReturnValue("Test", 2);

        control.replay();

        assertEquals("Test", mock.threeArgumentMethod(1, "2", "3"));

        boolean failed = true;
        try {
            control.verify();
            failed = false;
        } catch (AssertionError expected) {
            assertEquals(
                    "\n  Expectation failure on verify:"
                            + "\n    threeArgumentMethod(1, \"2\", \"3\"): expected: 2, actual: 1",
                    expected.getMessage());
        }
        if (!failed) {
            fail("exception expected");
        }
    }

    public void testUnexpectedCallWithArray() {
        control.reset();
        control.setDefaultMatcher(MockControl.ARRAY_MATCHER);
        control.replay();
        boolean failed = false;
        String[] strings = new String[] { "Test" };
        try {
            mock.arrayMethod(strings);
        } catch (AssertionError expected) {
            failed = true;
            assertEquals("\n  Unexpected method call arrayMethod("
                    + strings.toString() + "):", expected.getMessage());
        }
        if (!failed) {
            fail("exception expected");
        }

    }

    public void testWrongArguments() {
        mock.simpleMethodWithArgument("3");
        control.replay();

        try {
            mock.simpleMethodWithArgument("5");
            fail();
        } catch (AssertionError expected) {
            assertEquals(
                    "\n  Unexpected method call simpleMethodWithArgument(\"5\"):"
                            + "\n    simpleMethodWithArgument(\"3\"): expected: 1, actual: 0",
                    expected.getMessage());
        }

    }

    public void testSummarizeSameObjectArguments() {
        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("3");
        control.replay();

        try {
            mock.simpleMethodWithArgument("5");
            fail();
        } catch (AssertionError expected) {
            assertEquals(
                    "\n  Unexpected method call simpleMethodWithArgument(\"5\"):"
                            + "\n    simpleMethodWithArgument(\"3\"): expected: 2, actual: 0",
                    expected.getMessage());
        }

    }

    public void testArgumentsOrdered() {
        mock.simpleMethodWithArgument("4");
        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("2");
        mock.simpleMethodWithArgument("0");
        mock.simpleMethodWithArgument("1");
        control.replay();

        try {
            mock.simpleMethodWithArgument("5");
            fail();
        } catch (AssertionError expected) {
            assertEquals(
                    "\n  Unexpected method call simpleMethodWithArgument(\"5\"):"
                            + "\n    simpleMethodWithArgument(\"4\"): expected: 1, actual: 0"
                            + "\n    simpleMethodWithArgument(\"3\"): expected: 1, actual: 0"
                            + "\n    simpleMethodWithArgument(\"2\"): expected: 1, actual: 0"
                            + "\n    simpleMethodWithArgument(\"0\"): expected: 1, actual: 0"
                            + "\n    simpleMethodWithArgument(\"1\"): expected: 1, actual: 0",
                    expected.getMessage());
        }

    }

}
