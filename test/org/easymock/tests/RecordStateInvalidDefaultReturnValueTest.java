/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class RecordStateInvalidDefaultReturnValueTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testSetInvalidDefaultBooleanReturnValue() {
        mock.oneArg(false);
        try {
            control.setDefaultReturnValue(new Boolean(false));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

    public void testSetInvalidDefaultLongReturnValue() {
        mock.oneArg(false);
        try {
            control.setDefaultReturnValue(new Long(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

    public void testSetInvalidDefaultFloatReturnValue() {
        mock.oneArg(false);
        try {
            control.setDefaultReturnValue(new Float(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

    public void testSetInvalidDefaultDoubleReturnValue() {
        mock.oneArg(false);
        try {
            control.setDefaultReturnValue(new Double(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

    public void testSetInvalidObjectDefaultReturnValue() {
        mock.oneArg(false);
        try {
            control.setDefaultReturnValue(new Object());
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

    public void testSetDefaultReturnValueWithoutMethodCall() {
        try {
            control.setDefaultReturnValue(new Object());
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals(
                    "method call on the mock needed before setting default return value",
                    e.getMessage());
        }
    }
}
