/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class UsageTest extends EasyMockTestCase {

    IMethods mock;

    public void setUp() {
        mock = (IMethods) createMock(IMethods.class);
    }

    public void testExactCallCountByLastCall() {
        expect(mock.oneArg(false)).andReturn("Test").andReturn("Test2");
        replay(mock);

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
        expect(mock.oneArg(false)).andReturn("Test").andReturn("Test2")
                .atLeastOnce();

        replay(mock);

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));
    }

    public void testExactCallCountByLastThrowable() {
        expect(mock.oneArg(false)).andReturn("Test").andReturn("Test2")
                .andThrow(new IndexOutOfBoundsException());

        replay(mock);

        assertEquals("Test", mock.oneArg(false));
        assertEquals("Test2", mock.oneArg(false));

        try {
            mock.oneArg(false);
            fail();
        } catch (IndexOutOfBoundsException expected) {
        }

        boolean failed = true;
        try {
            mock.oneArg(false);
            failed = false;
        } catch (AssertionError expected) {
        }
        if (!failed)
            fail("expected AssertionError");
    }

    public void testOpenCallCountByLastThrowable() {
        expect(mock.oneArg(false)).andReturn("Test").andReturn("Test2")
                .andThrow(new IndexOutOfBoundsException()).atLeastOnce();

        replay(mock);

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
        expect(mock.threeArgumentMethod(1, "2", "3")).andReturn("Test")
                .times(2);

        replay(mock);

        assertEquals("Test", mock.threeArgumentMethod(1, "2", "3"));

        boolean failed = true;
        try {
            verify(mock);
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

    public void testWrongArguments() {
        mock.simpleMethodWithArgument("3");
        replay(mock);

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
        replay(mock);

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
        replay(mock);

        try {
            mock.simpleMethodWithArgument("5");
            fail("exception expected");
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

    public void testMixingOrderedAndUnordered() {
        mock.simpleMethodWithArgument("2");
        mock.simpleMethodWithArgument("1");
        checkOrder(mock, true);
        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("4");
        checkOrder(mock, false);
        mock.simpleMethodWithArgument("6");
        mock.simpleMethodWithArgument("7");
        mock.simpleMethodWithArgument("5");

        replay(mock);

        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");

        boolean failed = false;
        try {
            mock.simpleMethodWithArgument("4");
        } catch (AssertionError e) {
            failed = true;
        }
        if (!failed) {
            fail();
        }

        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("4");
        mock.simpleMethodWithArgument("5");
        mock.simpleMethodWithArgument("6");
        mock.simpleMethodWithArgument("7");

        verify(mock);

    }

}
