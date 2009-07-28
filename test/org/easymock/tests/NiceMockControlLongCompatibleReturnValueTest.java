/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class NiceMockControlLongCompatibleReturnValueTest extends TestCase {

    MockControl control;

    IMethods mock;

    public void setUp() {
        control = MockControl.createNiceControl(IMethods.class);
        mock = (IMethods) control.getMock();
        control.replay();
    }

    public void testByteReturningValue() {
        assertEquals((byte) 0, mock.byteReturningMethod(12));
        control.verify();
    }

    public void testShortReturningValue() {
        assertEquals((short) 0, mock.shortReturningMethod(12));
        control.verify();
    }

    public void testCharReturningValue() {
        assertEquals((char) 0, mock.charReturningMethod(12));
        control.verify();
    }

    public void testIntReturningValue() {
        assertEquals(0, mock.intReturningMethod(12));
        control.verify();
    }

    public void testLongReturningValue() {
        assertEquals((long) 0, mock.longReturningMethod(12));
        control.verify();
    }
}