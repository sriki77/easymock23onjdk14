/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.easymock.internal.EqualsMatcher;
import org.easymock.internal.Invocation;

public class InvocationTest extends TestCase {

    private Invocation call;

    private Invocation equalCall;

    private Invocation nonEqualCall;

    public void setUp() throws SecurityException, NoSuchMethodException {
        Object[] arguments1 = new Object[] { "" };
        Object[] arguments2 = new Object[] { "" };
        Object[] arguments3 = new Object[] { "X" };
        Method m = Object.class.getMethod("equals",
                new Class[] { Object.class });
        Object mock = new Object();
        call = new Invocation(mock, m, arguments1);
        equalCall = new Invocation(mock, m, arguments2);
        nonEqualCall = new Invocation(mock, m, arguments3);
    }

    public void testEquals() {
        assertFalse(call.equals(null));
        assertFalse(call.equals(""));
        assertTrue(call.equals(equalCall));
        assertFalse(call.equals(nonEqualCall));
    }

    public void testHashCode() {
        try {
            call.hashCode();
            fail();
        } catch (UnsupportedOperationException expected) {
            assertEquals("hashCode() is not implemented", expected.getMessage());
        }
    }

    public void testShouldDisplayMocksToStringIfValidJavaIdentifier()
            throws SecurityException, NoSuchMethodException {
        class ToString {
            private final String name;

            public ToString(String name) {
                this.name = name;
            }

            public String toString() {
                return name;
            }

            public void aMethod() {
            }
        }

        Method method = ToString.class.getMethod("aMethod", new Class[0]);
        Invocation invocation = new Invocation(new ToString("validJavaIdentifier"),
                method, null);

        assertEquals(invocation.toString(new EqualsMatcher()),
                "validJavaIdentifier.aMethod()");

        invocation = new Invocation(new ToString("no-valid-java-identifier"),
                method, null);

        assertEquals(invocation.toString(new EqualsMatcher()), "aMethod()");

    }
}