/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

public class UsageExpectAndThrowTest extends TestCase {
    private MockControl control;

    private IMethods mock;

    private static RuntimeException EXCEPTION = new RuntimeException();

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    
    public void testBooleanType() {
        control.expectAndThrow(mock.booleanReturningMethod(4), EXCEPTION);
        control.replay();
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testLongType() {
        control.expectAndThrow(mock.longReturningMethod(4), EXCEPTION);
        control.replay();
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testFloatType() {
        control.expectAndThrow(mock.floatReturningMethod(4), EXCEPTION);
        control.replay();
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testDoubleType() {
        control.expectAndThrow(mock.doubleReturningMethod(4), EXCEPTION);
        control.replay();
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testObject() {
        control.expectAndThrow(mock.objectReturningMethod(4), EXCEPTION);
        control.replay();
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testBooleanAndRange() {
        control.expectAndThrow(mock.booleanReturningMethod(4), EXCEPTION,
                MockControl.ONE);
        control.replay();
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testLongAndRange() {
        control.expectAndThrow(mock.longReturningMethod(4), EXCEPTION,
                MockControl.ONE);
        control.replay();
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testFloatAndRange() {
        control.expectAndThrow(mock.floatReturningMethod(4), EXCEPTION,
                MockControl.ONE);
        control.replay();
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testDoubleAndRange() {
        control.expectAndThrow(mock.doubleReturningMethod(4), EXCEPTION,
                MockControl.ONE);
        control.replay();
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testObjectAndRange() {
        control.expectAndThrow(mock.objectReturningMethod(4), EXCEPTION,
                MockControl.ONE);
        control.replay();
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testBooleanAndCount() {
        control.expectAndThrow(mock.booleanReturningMethod(4), EXCEPTION, 2);
        control.replay();
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testLongAndCount() {
        control.expectAndThrow(mock.longReturningMethod(4), EXCEPTION, 2);
        control.replay();
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testFloatAndCount() {
        control.expectAndThrow(mock.floatReturningMethod(4), EXCEPTION, 2);
        control.replay();
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testDoubleAndCount() {
        control.expectAndThrow(mock.doubleReturningMethod(4), EXCEPTION, 2);
        control.replay();
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testObjectAndCount() {
        control.expectAndThrow(mock.objectReturningMethod(4), EXCEPTION, 2);
        control.replay();
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testBooleanAndMinMax() {
        control.expectAndThrow(mock.booleanReturningMethod(4), EXCEPTION, 2, 3);
        control.replay();
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
        try {
            mock.booleanReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testLongAndMinMax() {
        control.expectAndThrow(mock.longReturningMethod(4), EXCEPTION, 2, 3);
        control.replay();
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
        try {
            mock.longReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testFloatAndMinMax() {
        control.expectAndThrow(mock.floatReturningMethod(4), EXCEPTION, 2, 3);
        control.replay();
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
        try {
            mock.floatReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testDoubleAndMinMax() {
        control.expectAndThrow(mock.doubleReturningMethod(4), EXCEPTION, 2, 3);
        control.replay();
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
        try {
            mock.doubleReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

    
    public void testObjectAndMinMax() {
        control.expectAndThrow(mock.objectReturningMethod(4), EXCEPTION, 2, 3);
        control.replay();
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
        try {
            mock.objectReturningMethod(4);
            fail();
        } catch (RuntimeException exception) {
            assertSame(EXCEPTION, exception);
        }
        control.verify();
    }

}
