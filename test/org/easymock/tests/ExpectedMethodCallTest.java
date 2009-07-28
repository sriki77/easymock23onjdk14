/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.easymock.internal.ExpectedInvocation;
import org.easymock.internal.Invocation;

public class ExpectedMethodCallTest extends TestCase {

    private ExpectedInvocation call;

    public void setUp() throws SecurityException, NoSuchMethodException {
        Object[] arguments1 = new Object[] { "" };
        Method m = Object.class.getMethod("equals",
                new Class[] { Object.class });
        call = new ExpectedInvocation(new Invocation(null, m, arguments1), null);
    }

    public void testHashCode() {
        try {
            call.hashCode();
            fail();
        } catch (UnsupportedOperationException expected) {
            assertEquals("hashCode() is not implemented", expected.getMessage());
        }
    }
}