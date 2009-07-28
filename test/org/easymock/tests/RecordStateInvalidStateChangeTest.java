/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.internal.RecordState;
import org.easymock.jdk14.IMethods;

public class RecordStateInvalidStateChangeTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    
    public void testActivateWithoutReturnValue() {
        mock.oneArg(false);
        try {
            control.replay();
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals(
                    "missing behavior definition for the preceeding method call oneArg(false)",
                    e.getMessage());
            assertTrue("stack trace must be cut", Util.getStackTrace(e)
                    .indexOf(RecordState.class.getName()) == -1);
        }
    }

    
    public void testSecondCallWithoutReturnValue() {
        mock.oneArg(false);
        try {
            mock.oneArg(false);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals(
                    "missing behavior definition for the preceeding method call oneArg(false)",
                    e.getMessage());
            assertTrue("stack trace must be cut", Util.getStackTrace(e)
                    .indexOf(RecordState.class.getName()) == -1);
        }
    }

    
    public void testVerifyWithoutActivation() {
        try {
            control.verify();
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("calling verify is not allowed in record state", e
                    .getMessage());
        }
    }
}
