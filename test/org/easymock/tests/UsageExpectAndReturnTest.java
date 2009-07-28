/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class UsageExpectAndReturnTest extends TestCase {
    private MockControl control;

    private IMethods mock;

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    
    public void testBooleanType() {
        control.expectAndReturn(mock.booleanReturningMethod(4), true);
        control.replay();
        assertEquals(true, mock.booleanReturningMethod(4));
        control.verify();
    }

    
    public void testLongType() {
        control.expectAndReturn(mock.longReturningMethod(4), 12l);
        control.replay();
        assertEquals((long) 12, mock.longReturningMethod(4));
        control.verify();
    }

    
    public void testFloatType() {
        control.expectAndReturn(mock.floatReturningMethod(4), 12f);
        control.replay();
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        control.verify();
    }

    
    public void testDoubleType() {
        control.expectAndReturn(mock.doubleReturningMethod(4), 12.0);
        control.replay();
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        control.verify();
    }

    
    public void testObject() {
        control.expectAndReturn(mock.objectReturningMethod(4), "12");
        control.replay();
        assertEquals("12", mock.objectReturningMethod(4));
        control.verify();
    }

    
    public void testBooleanAndRange() {
        control.expectAndReturn(mock.booleanReturningMethod(4), true,
                MockControl.ONE);
        control.replay();
        assertEquals(true, mock.booleanReturningMethod(4));
        control.verify();
    }

    
    public void testLongAndRange() {
        control.expectAndReturn(mock.longReturningMethod(4), 12l,
                MockControl.ONE);
        control.replay();
        assertEquals((long) 12, mock.longReturningMethod(4));
        control.verify();
    }

    
    public void testFloatAndRange() {
        control.expectAndReturn(mock.floatReturningMethod(4), 12f,
                MockControl.ONE);
        control.replay();
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        control.verify();
    }

    
    public void testDoubleAndRange() {
        control.expectAndReturn(mock.doubleReturningMethod(4), 12.0,
                MockControl.ONE);
        control.replay();
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        control.verify();
    }

    
    public void testObjectAndRange() {
        control.expectAndReturn(mock.objectReturningMethod(4), "12",
                MockControl.ONE);
        control.replay();
        assertEquals("12", mock.objectReturningMethod(4));
        control.verify();
    }

    
    public void testBooleanAndCount() {
        control.expectAndReturn(mock.booleanReturningMethod(4), true, 2);
        control.replay();
        assertEquals(true, mock.booleanReturningMethod(4));
        assertEquals(true, mock.booleanReturningMethod(4));
        control.verify();
    }

    
    public void testLongAndCount() {
        control.expectAndReturn(mock.longReturningMethod(4), 12l, 2);
        control.replay();
        assertEquals((long) 12, mock.longReturningMethod(4));
        assertEquals((long) 12, mock.longReturningMethod(4));
        control.verify();
    }

    
    public void testFloatAndCount() {
        control.expectAndReturn(mock.floatReturningMethod(4), 12f, 2);
        control.replay();
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        control.verify();
    }

    
    public void testDoubleAndCount() {
        control.expectAndReturn(mock.doubleReturningMethod(4), 12.0, 2);
        control.replay();
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        control.verify();
    }

    
    public void testObjectAndCount() {
        control.expectAndReturn(mock.objectReturningMethod(4), "12", 2);
        control.replay();
        assertEquals("12", mock.objectReturningMethod(4));
        assertEquals("12", mock.objectReturningMethod(4));
        control.verify();
    }

    
    public void testBooleanAndMinMax() {
        control.expectAndReturn(mock.booleanReturningMethod(4), true, 2, 3);
        control.replay();
        assertEquals(true, mock.booleanReturningMethod(4));
        assertEquals(true, mock.booleanReturningMethod(4));
        control.verify();
    }

    
    public void testLongAndMinMax() {
        control.expectAndReturn(mock.longReturningMethod(4), 12l, 2, 3);
        control.replay();
        assertEquals((long) 12, mock.longReturningMethod(4));
        assertEquals((long) 12, mock.longReturningMethod(4));
        control.verify();
    }

    
    public void testFloatAndMinMax() {
        control.expectAndReturn(mock.floatReturningMethod(4), 12f, 2, 3);
        control.replay();
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        assertEquals(12f, mock.floatReturningMethod(4), 0f);
        control.verify();
    }

    
    public void testDoubleAndMinMax() {
        control.expectAndReturn(mock.doubleReturningMethod(4), 12.0, 2, 3);
        control.replay();
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        assertEquals(12.0, mock.doubleReturningMethod(4), 0.0);
        control.verify();
    }

    
    public void testObjectAndMinMax() {
        control.expectAndReturn(mock.objectReturningMethod(4), "12", 2, 3);
        control.replay();
        assertEquals("12", mock.objectReturningMethod(4));
        assertEquals("12", mock.objectReturningMethod(4));
        control.verify();
    }
}
