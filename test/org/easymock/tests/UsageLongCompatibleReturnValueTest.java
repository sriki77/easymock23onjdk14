/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class UsageLongCompatibleReturnValueTest extends TestCase {
    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testReturnByte() {
        mock.byteReturningMethod(0);
        control.setReturnValue(25);
        control.setDefaultReturnValue(34);

        control.replay();

        assertEquals((byte) 25, mock.byteReturningMethod(0));
        assertEquals((byte) 34, mock.byteReturningMethod(-4));
        assertEquals((byte) 34, mock.byteReturningMethod(12));

        control.verify();
    }

    public void testReturnShort() {
        mock.shortReturningMethod(0);
        control.setReturnValue(25);
        control.setDefaultReturnValue(34);

        control.replay();

        assertEquals((short) 25, mock.shortReturningMethod(0));
        assertEquals((short) 34, mock.shortReturningMethod(-4));
        assertEquals((short) 34, mock.shortReturningMethod(12));

        control.verify();
    }

    public void testReturnChar() {
        mock.charReturningMethod(0);
        control.setReturnValue(25);
        control.setDefaultReturnValue(34);

        control.replay();

        assertEquals((char) 25, mock.charReturningMethod(0));
        assertEquals((char) 34, mock.charReturningMethod(-4));
        assertEquals((char) 34, mock.charReturningMethod(12));

        control.verify();
    }

    public void testReturnInt() {
        mock.intReturningMethod(0);
        control.setReturnValue(25);
        control.setDefaultReturnValue(34);

        control.replay();

        assertEquals(25, mock.intReturningMethod(0));
        assertEquals(34, mock.intReturningMethod(-4));
        assertEquals(34, mock.intReturningMethod(12));

        control.verify();
    }

    public void testReturnLong() {
        mock.longReturningMethod(0);
        control.setReturnValue(25);
        control.setDefaultReturnValue(34);

        control.replay();

        assertEquals((long) 25, mock.longReturningMethod(0));
        assertEquals((long) 34, mock.longReturningMethod(-4));
        assertEquals((long) 34, mock.longReturningMethod(12));

        control.verify();
    }
}
