/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;
import org.easymock.internal.MocksBehavior;
import org.easymock.internal.ReplayState;
import org.easymock.internal.RuntimeExceptionWrapper;

public class ReplayStateInvalidCallsTest extends TestCase {

    private ReplayState control;

    private Exception exception;

    public void setUp() {
        exception = new Exception();
        control = new ReplayState(new MocksBehavior(false));
    }

    public void testExpectAndThrowLongWithMinMax() {
        try {
            control.andThrow(exception);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testExpectAndReturnObjectWithMinMax() {
        try {
            control.andReturn("");
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testSetDefaultMatcher() {
        try {
            control.setDefaultMatcher(MockControl.ARRAY_MATCHER);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAsStub() {
        try {
            control.asStub();
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testSetMatcher() {
        try {
            control.setMatcher(null, MockControl.ARRAY_MATCHER);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testSetDefaultReturnValue() {
        try {
            control.setDefaultReturnValue("");
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testSetDefaultThrowable() {
        try {
            control.setDefaultThrowable(exception);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testSetDefaultVoidCallable() {
        try {
            control.setDefaultVoidCallable();
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testReplay() {
        try {
            control.replay();
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testCheckOrder() {
        try {
            control.checkOrder(true);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndStubReturn() {
        try {
            control.andStubReturn("7");
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndStubThrow() {
        try {
            control.andStubThrow(new RuntimeException());
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndStubAnswer() {
        try {
            control.andStubAnswer(null);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testTimes() {
        try {
            control.times(MockControl.ONE);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testCallback() {
        try {
            control.callback(new Runnable() {
                public void run() {
                };
            });
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndReturn() {
        try {
            control.andReturn(null);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndThrow() {
        try {
            control.andThrow(new RuntimeException());
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testAndAnswer() {
        try {
            control.andAnswer(null);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testDefaultThrowable() {
        try {
            control.setDefaultThrowable(new RuntimeException());
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testDefaultReturnValue() {
        try {
            control.setDefaultReturnValue(null);
            fail("test should throw exception");
        } catch (RuntimeExceptionWrapper e) {
           
        }
    }

    public void testDefaultVoidCallable() {
        try {
            control.setDefaultVoidCallable();
        } catch (Exception e) {
            // TODO Auto-generated catch block
           
        }
    }
}