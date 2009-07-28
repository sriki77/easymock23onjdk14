/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.easymock.internal.ExpectedInvocation;
import org.easymock.internal.Invocation;

public class MatchableArgumentsTest extends TestCase {

    private Object[] arguments;

    private Object[] arguments2;

    public void setUp() {
        arguments = new Object[] { "" };
        arguments2 = new Object[] { "", "" };
    }

    public void testEquals() throws SecurityException, NoSuchMethodException {
        Method toPreventNullPointerExceptionm = Object.class.getMethod(
                "toString", new Class[] {});

        Object mock = new Object();

        ExpectedInvocation matchableArguments = new ExpectedInvocation(
                new Invocation(mock, toPreventNullPointerExceptionm, arguments),
                null);
        ExpectedInvocation nonEqualMatchableArguments = new ExpectedInvocation(
                new Invocation(mock, toPreventNullPointerExceptionm, arguments2),
                null);

        assertFalse(matchableArguments.equals(null));
        assertFalse(matchableArguments.equals(nonEqualMatchableArguments));
    }
}