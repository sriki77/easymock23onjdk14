/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.easymock.MockControl;
import org.easymock.internal.ReplayState;
import org.easymock.internal.RuntimeExceptionWrapper;
import org.easymock.jdk14.IMethods;

public class ReplayStateInvalidUsageTest extends TestCase {

    private MockControl control;

    private Exception exception;

    private ReplayState replayState;

    private IMocksControl mocksControl;

    public void setUp() {
        exception = new Exception();
        control = MockControl.createControl(IMethods.class);
        control.replay();
        mocksControl = EasyMock.createControl();
        mocksControl.replay();
    }

    public void testExpectAndThrowObjectWithMinMax() {
        try {
            control.expectAndThrow("", exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowDoubleWithMinMax() {
        try {
            control.expectAndThrow(0.0d, exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowFloatWithMinMax() {
        try {
            control.expectAndThrow(0.0f, exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowLongWithMinMax() {
        try {
            control.expectAndThrow(0, exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowBooleanWithMinMax() {
        try {
            control.expectAndThrow(false, exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowObjectWithCount() {
        try {
            control.expectAndThrow("", exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowDoubleWithCount() {
        try {
            control.expectAndThrow(0.0d, exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowFloatWithCount() {
        try {
            control.expectAndThrow(0.0f, exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowLongWithCount() {
        try {
            control.expectAndThrow(0, exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowBooleanWithCount() {
        try {
            control.expectAndThrow(false, exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowObjectWithRange() {
        try {
            control.expectAndThrow("", exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowDoubleWithRange() {
        try {
            control.expectAndThrow(0.0d, exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowFloatWithRange() {
        try {
            control.expectAndThrow(0.0f, exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowLongWithRange() {
        try {
            control.expectAndThrow(0, exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowBooleanWithRange() {
        try {
            control.expectAndThrow(false, exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowObject() {
        try {
            control.expectAndThrow("", exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowDouble() {
        try {
            control.expectAndThrow(0.0d, exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowFloat() {
        try {
            control.expectAndThrow(0.0f, exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowLong() {
        try {
            control.expectAndThrow(0, exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndThrowBoolean() {
        try {
            control.expectAndThrow(false, exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnObjectWithMinMax() {
        try {
            control.expectAndReturn("", "", 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnDoubleWithMinMax() {
        try {
            control.expectAndReturn(0.0d, 0.0d, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnFloatWithMinMax() {
        try {
            control.expectAndReturn(0.0f, 0.0f, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnLongWithMinMax() {
        try {
            control.expectAndReturn(0, 0, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnBooleanWithMinMax() {
        try {
            control.expectAndReturn(false, false, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnObjectWithCount() {
        try {
            control.expectAndReturn("", "", 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnDoubleWithCount() {
        try {
            control.expectAndReturn(0.0d, 0.0d, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnFloatWithCount() {
        try {
            control.expectAndReturn(0.0f, 0.0f, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnLongWithCount() {
        try {
            control.expectAndReturn(0, 0, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnBooleanWithCount() {
        try {
            control.expectAndReturn(false, false, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnObjectWithRange() {
        try {
            control.expectAndReturn("", "", MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnDoubleWithRange() {
        try {
            control.expectAndReturn(0.0d, 0.0d, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnFloatWithRange() {
        try {
            control.expectAndReturn(0.0f, 0.0f, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnLongWithRange() {
        try {
            control.expectAndReturn(0, 0, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnBooleanWithRange() {
        try {
            control.expectAndReturn(false, false, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnObject() {
        try {
            control.expectAndReturn("", "");
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnDouble() {
        try {
            control.expectAndReturn(0.0d, 0.0d);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnFloat() {
        try {
            control.expectAndReturn(0.0f, 0.0f);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnLong() {
        try {
            control.expectAndReturn(0, 0);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testExpectAndReturnBoolean() {
        try {
            control.expectAndReturn(false, false);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultMatcher() {
        try {
            control.setDefaultMatcher(MockControl.ARRAY_MATCHER);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueObjectWithMinMax() {
        try {
            control.setReturnValue("", 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueDoubleWithMinMax() {
        try {
            control.setReturnValue(0.0d, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueFloatWithMinMax() {
        try {
            control.setReturnValue(0.0f, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueLongWithMinMax() {
        try {
            control.setReturnValue(0, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueBooleanWithMinMax() {
        try {
            control.setReturnValue(false, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetThrowableWithMinMax() {
        try {
            control.setThrowable(exception, 1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetVoidCallableWithMinMax() {
        try {
            control.setVoidCallable(1, 2);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetMatcher() {
        try {
            control.setMatcher(MockControl.ARRAY_MATCHER);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultReturnValueObject() {
        try {
            control.setDefaultReturnValue("");
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultReturnValueDouble() {
        try {
            control.setDefaultReturnValue(0.0d);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultReturnValueFloat() {
        try {
            control.setDefaultReturnValue(0.0f);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultReturnValueLong() {
        try {
            control.setDefaultReturnValue(0);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultReturnValueBoolean() {
        try {
            control.setDefaultReturnValue(false);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultThrowable() {
        try {
            control.setDefaultThrowable(exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetDefaultVoidCallable() {
        try {
            control.setDefaultVoidCallable();
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueObjectWithRange() {
        try {
            control.setReturnValue("", MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueLongWithRange() {
        try {
            control.setReturnValue(0, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueFloatWithRange() {
        try {
            control.setReturnValue(0.0f, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueDoubleWithRange() {
        try {
            control.setReturnValue(0.0d, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueBooleanWithRange() {
        try {
            control.setReturnValue(false, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetThrowableWithRange() {
        try {
            control.setThrowable(exception, MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetVoidCallableWithRange() {
        try {
            control.setVoidCallable(MockControl.ONE);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueObjectWithCount() {
        try {
            control.setReturnValue("", 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueLongWithCount() {
        try {
            control.setReturnValue(0, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueFloatWithCount() {
        try {
            control.setReturnValue(0.0f, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueDoubleWithCount() {
        try {
            control.setReturnValue(0.0d, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueBooleanWithCount() {
        try {
            control.setReturnValue(false, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetThrowableWithCount() {
        try {
            control.setThrowable(exception, 1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetVoidCallableWithCount() {
        try {
            control.setVoidCallable(1);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueObject() {
        try {
            control.setReturnValue("");
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueDouble() {
        try {
            control.setReturnValue(0.0d);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueFloat() {
        try {
            control.setReturnValue(0.0f);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueLong() {
        try {
            control.setReturnValue(0);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetReturnValueBoolean() {
        try {
            control.setReturnValue(false);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetThrowable() {
        try {
            control.setThrowable(exception);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testSetVoidCallable() {
        try {
            control.setVoidCallable();
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testReplay() {
        try {
            control.replay();
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testCreateMock() {
        try {
            mocksControl.createMock(IMethods.class);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testCreateMockWithName() {
        try {
            mocksControl.createMock("", IMethods.class);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testCheckOrder() {
        try {
            mocksControl.checkOrder(true);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testAndStubReturn() {
        try {
            mocksControl.andStubReturn("7");
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testAndStubThrow() {
        try {
            mocksControl.andStubThrow(new RuntimeException());
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testAsStub() {
        try {
            mocksControl.asStub();
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testTimes() {
        try {
            mocksControl.times(3);
            fail("test should throw exception");
        } catch (final IllegalStateException e) {
        }
    }

    public void testAnyTimess() {
        try {
            mocksControl.anyTimes();
            fail("test should throw exception");
        } catch (IllegalStateException e) {
        }
    }
}