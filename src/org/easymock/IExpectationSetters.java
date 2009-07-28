/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock;

/**
 * Allows setting expectations for an associated expected invocation.
 * Implementations of this interface are returned by
 * {@link EasyMock#expect(Object)}, and by {@link EasyMock#expectLastCall()}.
 */
public interface IExpectationSetters {

    /**
     * Sets an object that will be used to calculate the answer for the expected
     * invocation (either return a value, or throw an exception).
     * 
     * @param answer
     *            the object used to answer the invocation.
     * @return this object to allow method call chaining.
     */
    IExpectationSetters andAnswer(IAnswer answer);

    IExpectationSetters andReturn(boolean iValue);

    IExpectationSetters andReturn(char iValue);

    IExpectationSetters andReturn(double iValue);
    IExpectationSetters andReturn(float iValue);
    IExpectationSetters andReturn(int iValue);
    IExpectationSetters andReturn(long iValue);
    /**
     * Sets a return value that will be returned for the expected invocation.
     * 
     * @param value
     *            the value to return.
     * @return this object to allow method call chaining.
     */
    IExpectationSetters andReturn(Object value);

    IExpectationSetters andReturn(short iValue);

    /**
     * Sets a stub object that will be used to calculate the answer for the
     * expected invocation (either return a value, or throw an exception).
     * 
     * @param answer
     *            the object used to answer the invocation.
     */
    void andStubAnswer(IAnswer answer);

    void andStubReturn(boolean value);

    void andStubReturn(double value);

    void andStubReturn(float value);

    void andStubReturn(long value);
    
    void andStubReturn(int value);
    
    void andStubReturn(char value);
    
    void andStubReturn(short value);

    /**
     * Sets a stub return value that will be returned for the expected
     * invocation.
     * 
     * @param value
     *            the value to return.
     */
    void andStubReturn(Object value);

    /**
     * Sets a stub throwable that will be thrown for the expected invocation.
     * 
     * @param throwable
     *            the throwable to throw.
     */
    void andStubThrow(Throwable throwable);

    /**
     * Sets a throwable that will be thrown for the expected invocation.
     * 
     * @param throwable
     *            the throwable to throw.
     * @return this object to allow method call chaining.
     */
    IExpectationSetters andThrow(Throwable throwable);
    /**
     * Expect the last invocation any times.
     * 
     * @return this object to allow method call chaining.
     */
    IExpectationSetters anyTimes();
    /**
     * Sets stub behavior for the expected invocation (this is needed for void
     * methods).
     */
    void asStub();
    /**
     * Expect the last invocation at least once.
     * 
     * @return this object to allow method call chaining.
     */
    IExpectationSetters atLeastOnce();
    /**
     * Expect the last invocation once. This is default in EasyMock.
     * 
     * @return this object to allow method call chaining.
     */
    IExpectationSetters once();
    /**
     * Expect the last invocation <code>count</code> times.
     * 
     * @param count
     *            the number of invocations expected.
     * @return this object to allow method call chaining.
     */
    IExpectationSetters times(int count);
    /**
     * Expect the last invocation between <code>min</code> and
     * <code>max</code> times.
     * 
     * @param min
     *            the minimum number of invocations expected.
     * @param max
     *            the maximum number of invocations expected.
     * @return this object to allow method call chaining.
     */
    IExpectationSetters times(int min, int max);
}
