/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class RecordStateInvalidReturnValueTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

   
    public void testSetInvalidBooleanReturnValue() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Boolean(false));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }

    }

   
    public void testSetInvalidLongReturnValue() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Long(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidFloatReturnValue() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Float(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidDoubleReturnValue() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Double(0));
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidObjectReturnValue() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Object());
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidBooleanReturnValueCount() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Boolean(false), 3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }

    }

   
    public void testSetInvalidLongReturnValueCount() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Long(0), 3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidFloatReturnValueCount() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Float(0), 3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidDoubleReturnValueCount() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Double(0), 3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetInvalidObjectReturnValueCount() {
        mock.oneArg(false);
        try {
            control.setReturnValue(new Object(), 3);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("incompatible return value type", e.getMessage());
        }
    }

   
    public void testSetReturnValueForVoidMethod() {
        mock.simpleMethod();
        try {
            control.setReturnValue(null);
            fail("IllegalStateException expected");
        } catch (IllegalStateException e) {
            assertEquals("void method cannot return a value", e.getMessage());
        }
    }
}
