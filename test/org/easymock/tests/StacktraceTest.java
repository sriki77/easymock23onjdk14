/*

 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class StacktraceTest extends TestCase {

    private MockControl control;

    private IMethods mock;

    public void setUp() {
        control = MockControl.createStrictControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    private static class ToStringThrowsException {
        public String toString() {
            throw new NullPointerException();
        }
    }

    public void testAssertRecordStateNoFillInStacktraceWhenExceptionNotFromEasyMock() {
        mock.oneArg(new ToStringThrowsException());
        try {
            mock.oneArg(new ToStringThrowsException());
        } catch (NullPointerException expected) {
            assertTrue("stack trace must not be cut",
                    Util.getStackTrace(expected).indexOf(
                            ToStringThrowsException.class.getName()) > 0);
        }
    }

    public void testAssertReplayNoFillInStacktraceWhenExceptionNotFromEasyMock() {
        mock.oneArg(new ToStringThrowsException());
        try {
            control.replay();
        } catch (NullPointerException expected) {
            assertTrue("stack trace must not be cut",
                    Util.getStackTrace(expected).indexOf(
                            ToStringThrowsException.class.getName()) > 0);
        }
    }

    public void testAssertReplayStateNoFillInStacktraceWhenExceptionNotFromEasyMock() {
        control.replay();
        try {
            mock.oneArg(new ToStringThrowsException());
        } catch (NullPointerException expected) {
            assertTrue("stack trace must not be cut",
                    Util.getStackTrace(expected).indexOf(
                            ToStringThrowsException.class.getName()) > 0);
        }
    }

    public void testAssertVerifyNoFillInStacktraceWhenExceptionNotFromEasyMock() {
        mock.oneArg(new ToStringThrowsException());
        control.setReturnValue("");
        control.replay();
        try {
            control.verify();
            fail();
        } catch (NullPointerException expected) {
            assertTrue("stack trace must not be cut",
                    Util.getStackTrace(expected).indexOf(
                            ToStringThrowsException.class.getName()) > 0);
        }
    }
}
