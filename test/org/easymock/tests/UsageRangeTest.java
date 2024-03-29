/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import java.util.Iterator;

import org.easymock.MockControl;
import org.easymock.internal.Range;

public class UsageRangeTest extends TestCase {

    private Iterator mock;

    private MockControl control;

    public void setUp() {
        control = MockControl.createStrictControl(Iterator.class);
        mock = (Iterator) control.getMock();
    }

    public void testZeroOrMoreNoCalls() {
        mock.hasNext();
        control.setReturnValue(false, MockControl.ZERO_OR_MORE);
        control.replay();
        control.verify();
    }

    public void testZeroOrMoreOneCall() {
        mock.hasNext();
        control.setReturnValue(false, MockControl.ZERO_OR_MORE);
        control.replay();
        assertFalse(mock.hasNext());
        control.verify();
    }

    public void testZeroOrMoreThreeCalls() {
        mock.hasNext();
        control.setReturnValue(false, MockControl.ZERO_OR_MORE);
        control.replay();
        assertFalse(mock.hasNext());
        assertFalse(mock.hasNext());
        assertFalse(mock.hasNext());
        control.verify();
    }

    public void testCombination() {
        mock.hasNext();
        control.setReturnValue(true, MockControl.ONE_OR_MORE);
        mock.next();
        control.setReturnValue("1");

        mock.hasNext();
        control.setReturnValue(true, MockControl.ONE_OR_MORE);
        mock.next();
        control.setReturnValue("2");

        mock.hasNext();
        control.setReturnValue(false, MockControl.ONE_OR_MORE);

        control.replay();

        assertTrue(mock.hasNext());
        assertTrue(mock.hasNext());
        assertTrue(mock.hasNext());

        assertEquals("1", mock.next());

        try {
            mock.next();
            fail();
        } catch (AssertionError expected) {
        }

        assertTrue(mock.hasNext());

        assertEquals("2", mock.next());

        assertFalse(mock.hasNext());

        control.verify();

    }

    public void testWithIllegalOwnRange() {
        mock.hasNext();
        try {
            control.setReturnValue(true, new Range(2, 7));
        } catch (IllegalArgumentException e) {
            assertEquals("Unexpected Range", e.getMessage());
        }
    }
}
