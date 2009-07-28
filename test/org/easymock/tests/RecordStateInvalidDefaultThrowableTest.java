/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import java.io.IOException;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class RecordStateInvalidDefaultThrowableTest extends TestCase {
    MockControl control;

    IMethods mock;

    private class CheckedException extends Exception {
    }

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testThrowNull() {
        mock.throwsNothing(false);
        try {
            control.setDefaultThrowable(null);
            fail("NullPointerException expected");
        } catch (NullPointerException expected) {
            assertEquals("null cannot be thrown", expected.getMessage());
        }

    }

    public void testThrowCheckedExceptionWhereNoCheckedExceptionIsThrown() {
        mock.throwsNothing(false);
        try {
            control.setDefaultThrowable(new CheckedException());
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException expected) {
            assertEquals("last method called on mock cannot throw "
                    + this.getClass().getName() + "$CheckedException", expected
                    .getMessage());
        }
    }

    public void testThrowWrongCheckedException() throws IOException {
        mock.throwsIOException(0);
        try {
            control.setDefaultThrowable(new CheckedException());
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException expected) {
            assertEquals("last method called on mock cannot throw "
                    + this.getClass().getName() + "$CheckedException", expected
                    .getMessage());
        }
    }

    public void testSetDefaultThrowableWithoutMethodCall() throws IOException {
        try {
            control.setDefaultThrowable(new RuntimeException());
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals(
                    "method call on the mock needed before setting default Throwable",
                    expected.getMessage());
        }
    }

}
