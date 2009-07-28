/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import java.lang.reflect.Method;

import org.easymock.ArgumentsMatcher;
import org.easymock.internal.matchers.ArrayEquals;

public class Invocation {

    private final Object mock;

    private final Method method;

    private final Object[] arguments;

    public Invocation(Object mock, Method method, Object[] args) {
        this.mock = mock;
        this.method = method;
        this.arguments = args==null?new Object[0]:args;
    }

    
    public Object getMock() {
        return mock;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(this.getClass()))
            return false;

        Invocation other = (Invocation) o;

        return this.mock.equals(other.mock) && this.method.equals(other.method)
                && this.equalArguments(other.arguments);
    }

    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() is not implemented");
    }

    private boolean equalArguments(Object[] arguments) {
        if (this.arguments.length != arguments.length) {
            return false;
        }
        for (int i = 0; i < this.arguments.length; i++) {
            Object myArgument = this.arguments[i];
            Object otherArgument = arguments[i];

            if (isPrimitiveParameter(i)) {
                if (!myArgument.equals(otherArgument)) {
                    return false;
                }
            } else {
                if (myArgument != otherArgument) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPrimitiveParameter(int parameterPosition) {
        Class[] parameterTypes = method.getParameterTypes();
        return parameterTypes[parameterPosition].isPrimitive();
    }

    public boolean matches(Invocation actual, ArgumentsMatcher matcher) {
        return this.mock.equals(actual.mock) && this.method.equals(actual.method)
                && matcher.matches(this.arguments, actual.arguments);
    }

    public String toString(ArgumentsMatcher matcher) {
        return getMockAndMethodName() + "(" + matcher.toString(arguments) + ")";
    }

    public String getMockAndMethodName() {
        String mockName = mock.toString();
        String methodName = method.getName();
        if (toStringIsDefined(mock) && isJavaIdentifier(mockName)) {
            return mockName + "." + methodName;
        } else {
            return methodName;
        }
    }

    private boolean toStringIsDefined(Object o) {
        try {
            o.getClass().getDeclaredMethod("toString", (Class[]) null).getModifiers();
            return true;
        } catch (SecurityException ignored) {
            // ///CLOVER:OFF
            return false;
            // ///CLOVER:ON
        } catch (NoSuchMethodException shouldNeverHappen) {
            // ///CLOVER:OFF
            throw new RuntimeException("The toString() method could not be found!");
            // ///CLOVER:ON
        }
    }

    public static boolean isJavaIdentifier(String mockName) {
        if (mockName.length() == 0 || mockName.indexOf(' ') > -1
                || !Character.isJavaIdentifierStart(mockName.charAt(0))) {
            return false;
        }
        char[] c = mockName.substring(1).toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (!Character.isJavaIdentifierPart(c[i])) {
                return false;
            }
        }
        return true;
    }
}
