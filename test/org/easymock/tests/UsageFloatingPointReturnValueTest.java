/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class UsageFloatingPointReturnValueTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testReturnFloat() {
        mock.floatReturningMethod(0);
        control.setReturnValue(25.0F);
        control.setDefaultReturnValue(34.0F);

        control.replay();

        assertEquals(25.0F, mock.floatReturningMethod(0), 0.0F);
        assertEquals(34.0F, mock.floatReturningMethod(-4), 0.0F);
        assertEquals(34.0F, mock.floatReturningMethod(12), 0.0F);

        control.verify();
    }

    public void testReturnDouble() {
        mock.doubleReturningMethod(0);
        control.setReturnValue(25.0);
        control.setDefaultReturnValue(34.0);

        control.replay();

        assertEquals(25.0, mock.doubleReturningMethod(0), 0.0);
        assertEquals(34.0, mock.doubleReturningMethod(-4), 0.0);
        assertEquals(34.0, mock.doubleReturningMethod(12), 0.0);

        control.verify();
    }
}
