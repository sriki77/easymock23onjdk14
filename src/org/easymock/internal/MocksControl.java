/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import org.easymock.ArgumentsMatcher;
import org.easymock.IAnswer;
import org.easymock.IExpectationSetters;
import org.easymock.IMocksControl;

public class MocksControl implements IMocksControl {

    private IMocksControlState state;

    private IMocksBehavior behavior;

    public static class MockType {
        public static final MockType NICE = new MockType();
        public static final MockType DEFAULT = new MockType();
        public static final MockType STRICT = new MockType();
    }

    private final MockType type;

    public MocksControl(MockType type) {
        this.type = type;
        reset();
    }

    public IMocksControlState getState() {
        return state;
    }

    public Object createMock(Class toMock) {
        try {
            state.assertRecordState();
            IProxyFactory proxyFactory = createProxyFactory(toMock);
            return proxyFactory.createProxy(toMock, new ObjectMethodsFilter(toMock,
                    new MockInvocationHandler(this), null));
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public Object createMock(String name, Class toMock) {
        try {
            state.assertRecordState();
            IProxyFactory proxyFactory = createProxyFactory(toMock);
            return proxyFactory.createProxy(toMock, new ObjectMethodsFilter(toMock,
                    new MockInvocationHandler(this), name));
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    protected IProxyFactory createProxyFactory(Class toMock) {
        return new JavaProxyFactory();
    }

    public final void reset() {
        behavior = new MocksBehavior(type == MockType.NICE);
        behavior.checkOrder(type == MockType.STRICT);
        state = new RecordState(behavior);
        LastControl.reportLastControl(null);
    }

    public void replay() {
        try {
            state.replay();
            state = new ReplayState(behavior);
            LastControl.reportLastControl(null);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void verify() {
        try {
            state.verify();
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        } catch (AssertionErrorWrapper e) {
            throw (AssertionError) e.getAssertionError().fillInStackTrace();
        }
    }

    public void checkOrder(boolean value) {
        try {
            state.checkOrder(value);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    // methods from IBehaviorSetters

    public IExpectationSetters andReturn(Object value) {
        try {
            state.andReturn(value);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters andThrow(Throwable throwable) {
        try {
            state.andThrow(throwable);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters andAnswer(IAnswer answer) {
        try {
            state.andAnswer(answer);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void andStubReturn(Object value) {
        try {
            state.andStubReturn(value);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void andStubThrow(Throwable throwable) {
        try {
            state.andStubThrow(throwable);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void andStubAnswer(IAnswer answer) {
        try {
            state.andStubAnswer(answer);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void asStub() {
        try {
            state.asStub();
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters times(int times) {
        try {
            state.times(new Range(times));
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters times(int min, int max) {
        try {
            state.times(new Range(min, max));
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters once() {
        try {
            state.times(ONCE);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters atLeastOnce() {
        try {
            state.times(AT_LEAST_ONCE);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters anyTimes() {
        try {
            state.times(ZERO_OR_MORE);
            return this;
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    /**
     * Exactly one call.
     */
    public static final Range ONCE = new Range(1);

    /**
     * One or more calls.
     */
    public static final Range AT_LEAST_ONCE = new Range(1, Integer.MAX_VALUE);

    /**
     * Zero or more calls.
     */
    public static final Range ZERO_OR_MORE = new Range(0, Integer.MAX_VALUE);

    public void setLegacyDefaultMatcher(ArgumentsMatcher matcher) {
        try {
            state.setDefaultMatcher(matcher);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void setLegacyMatcher(ArgumentsMatcher matcher) {
        try {
            state.setMatcher(null, matcher);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void setLegacyDefaultReturnValue(Object value) {
        try {
            state.setDefaultReturnValue(value);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public void setLegacyDefaultVoidCallable() {
        state.setDefaultVoidCallable();
    }

    public void setLegacyDefaultThrowable(Throwable throwable) {
        try {
            state.setDefaultThrowable(throwable);
        } catch (RuntimeExceptionWrapper e) {
            throw (RuntimeException) e.getRuntimeException().fillInStackTrace();
        }
    }

    public IExpectationSetters andReturn(long iValue) {
        return andReturn(new Long(iValue));
    }

    public IExpectationSetters andReturn(float iValue) {
        return andReturn(new Float(iValue));
    }

    public IExpectationSetters andReturn(double iValue) {
        return andReturn(new Double(iValue));
    }

    public IExpectationSetters andReturn(boolean iValue) {
        return andReturn(new Boolean(iValue));
    }

    public void andStubReturn(long value) {
        andStubReturn(new Long(value));
        
    }

    public void andStubReturn(float value) {
        andStubReturn(new Float(value));
        
    }

    public void andStubReturn(double value) {
        andStubReturn(new Double(value));
        
    }

    public void andStubReturn(boolean value) {
        andStubReturn(new Boolean(value));
        
    }

    public IExpectationSetters andReturn(char iValue) {
        return andReturn(new Character(iValue));
    }

    public IExpectationSetters andReturn(short iValue) {
        return andReturn(new Short(iValue));
    }

    public IExpectationSetters andReturn(int iValue) {
        return andReturn(new Integer(iValue));
    }

    public void andStubReturn(int valueValue) {
        andStubReturn(new Integer(valueValue));
        
    }

    public void andStubReturn(char valueValue) {
        andStubReturn(new Character(valueValue));
        
    }

    public void andStubReturn(short valueValue) {
        andStubReturn(new Short(valueValue));
        
    }
}
