/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class RecordStateInvalidUsageTest extends TestCase {

    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    
    public void testSetReturnValueWithoutMethodCall() {
        try {
            control.setReturnValue(false);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals(
                    "method call on the mock needed before setting return value",
                    expected.getMessage());
        }
    }

    
    public void testSetExpectedVoidCallCountWithoutMethodCall() {
        try {
            control.setVoidCallable(3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals(
                    "method call on the mock needed before setting void callable",
                    expected.getMessage());
        }
    }

    
    public void openVoidCallCountWithoutMethodCall() {
        try {
            control.setVoidCallable();
            fail("IllegalStateException expected");
        } catch (Exception expected) {
            assertEquals(
                    "method call on the mock needed before setting void callable",
                    expected.getMessage());
        }
    }

    
    public void testSetWrongReturnValueBoolean() {
        mock.oneArg(false);
        try {
            control.setReturnValue(false);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueShort() {
        mock.oneArg(false);
        try {
            control.setReturnValue((short) 0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueChar() {
        mock.oneArg(false);
        try {
            control.setReturnValue((char) 0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueInt() {
        mock.oneArg(false);
        try {
            control.setReturnValue(0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueLong() {
        mock.oneArg(false);
        try {
            control.setReturnValue((long) 0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueFloat() {
        mock.oneArg(false);
        try {
            control.setReturnValue((float) 0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueDouble() {
        mock.oneArg(false);
        try {
            control.setReturnValue((double) 0);
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }

    
    public void testSetWrongReturnValueObject() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Object());
            fail("IllegalStateException expected");
        } catch (IllegalStateException expected) {
            assertEquals("incompatible return value type", expected
                    .getMessage());
        }
    }
}