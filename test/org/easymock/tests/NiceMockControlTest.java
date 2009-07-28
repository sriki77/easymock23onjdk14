/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class NiceMockControlTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createNiceControl(IMethods.class);
        mock = (IMethods) control.getMock();
        control.replay();
    }

    public void testDefaultReturnValueBoolean() {
        assertEquals(false, mock.booleanReturningMethod(12));
        control.verify();
    }

    public void testDefaultReturnValueFloat() {
        assertEquals(0.0f, mock.floatReturningMethod(12), 0.0f);
        control.verify();
    }

    public void testDefaultReturnValueDouble() {
        assertEquals(0.0d, mock.doubleReturningMethod(12), 0.0d);
        control.verify();
    }

    public void testDefaultReturnValueObject() {
        assertEquals(null, mock.objectReturningMethod(12));
        control.verify();
    }
}
