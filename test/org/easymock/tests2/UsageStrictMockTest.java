/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.internal.ReplayState;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;
import org.easymock.tests.Util;

public class UsageStrictMockTest extends EasyMockTestCase {
    private IMethods mock;

    public void setUp() {
        mock = (IMethods) createStrictMock(IMethods.class);
        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");
        replay(mock);
    }

    public void testOrderedCallsSucces() {
        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");
        verify(mock);
    }

    public void testUnorderedCallsFailure() {
        boolean failed = false;
        try {
            mock.simpleMethodWithArgument("2");
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed) {
            fail("unordered calls accepted");
        }
    }

    public void testTooManyCallsFailure() {
        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");

        boolean failed = false;
        try {
            mock.simpleMethodWithArgument("2");
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed) {
            fail("too many calls accepted");
        }
    }

    public void testTooFewCallsFailure() {
        mock.simpleMethodWithArgument("1");
        boolean failed = false;
        try {
            verify(mock);
        } catch (AssertionError expected) {
            failed = true;
            assertTrue("stack trace must be filled in", Util.getStackTrace(
                    expected).indexOf(ReplayState.class.getName()) == -1);
        }
        if (!failed) {
            fail("too few calls accepted");
        }
    }

    public void testDifferentMethods() {

        reset(mock);

        mock.booleanReturningMethod(0);
        expectLastCall().andReturn(true);
        mock.simpleMethod();
        mock.booleanReturningMethod(1);
        expectLastCall().andReturn(false).times(2, 3);
        mock.simpleMethod();
        expectLastCall().atLeastOnce();

        replay(mock);
        assertEquals(true, mock.booleanReturningMethod(0));
        mock.simpleMethod();

        boolean failed = false;
        try {
            verify(mock);
        } catch (AssertionError expected) {
            failed = true;
            assertEquals(
                    "\n  Expectation failure on verify:"
                            + "\n    simpleMethod(): expected: 1, actual: 1"
                            + "\n    booleanReturningMethod(1): expected: between 2 and 3, actual: 0"
                            + "\n    simpleMethod(): expected: at least 1, actual: 0",
                    expected.getMessage());
        }
        if (!failed) {
            fail("too few calls accepted");
        }

        assertEquals(false, mock.booleanReturningMethod(1));

        failed = false;
        try {
            mock.simpleMethod();
        } catch (AssertionError expected) {
            failed = true;
            assertEquals(
                    "\n  Unexpected method call simpleMethod():"
                            + "\n    booleanReturningMethod(1): expected: between 2 and 3, actual: 1",
                    expected.getMessage());
        }
        if (!failed) {
            fail("wrong call accepted");
        }
    }

    public void testRange() {

        reset(mock);

        mock.booleanReturningMethod(0);
        expectLastCall().andReturn(true);
        mock.simpleMethod();
        mock.booleanReturningMethod(1);
        expectLastCall().andReturn(false).times(2, 3);
        mock.simpleMethod();
        expectLastCall().atLeastOnce();
        expect(mock.booleanReturningMethod(1)).andReturn(false);

        replay(mock);

        mock.booleanReturningMethod(0);
        mock.simpleMethod();

        mock.booleanReturningMethod(1);
        mock.booleanReturningMethod(1);
        mock.booleanReturningMethod(1);

        boolean failed = false;

        try {
            mock.booleanReturningMethod(1);
        } catch (AssertionError expected) {
            failed = true;
            assertEquals(
                    "\n  Unexpected method call booleanReturningMethod(1):"
                            + "\n    booleanReturningMethod(1): expected: between 2 and 3, actual: 3 (+1)"
                            + "\n    simpleMethod(): expected: at least 1, actual: 0",
                    expected.getMessage());
        }
        if (!failed) {
            fail("too many calls accepted");
        }
    }

    public void testStubBehavior() {
        reset(mock);

        mock.booleanReturningMethod(1);
        expectLastCall().andReturn(true).andReturn(false).andReturn(true);
        mock.booleanReturningMethod(anyInt());
        expectLastCall().andStubReturn(true);

        replay(mock);

        assertEquals(true, mock.booleanReturningMethod(2));
        assertEquals(true, mock.booleanReturningMethod(3));
        assertEquals(true, mock.booleanReturningMethod(1));
        assertEquals(false, mock.booleanReturningMethod(1));
        assertEquals(true, mock.booleanReturningMethod(3));

        boolean failed = false;
        try {
            verify(mock);
        } catch (AssertionError expected) {
            failed = true;
            assertEquals(
                    "\n  Expectation failure on verify:"
                            + "\n    booleanReturningMethod(1): expected: 3, actual: 2",
                    expected.getMessage());
        }
        if (!failed) {
            fail("too few calls accepted");
        }
    }
}
