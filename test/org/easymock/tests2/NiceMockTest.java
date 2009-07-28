/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import junit.framework.TestCase;
import org.easymock.EasyMock;

import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class NiceMockTest extends EasyMockTestCase {

    IMethods mock;

    public void setUp() {
        mock = (IMethods) createNiceMock(IMethods.class);
        replay(mock);
    }

    public void testDefaultReturnValueBoolean() {
        assertEquals(false, mock.booleanReturningMethod(12));
        verify(mock);
    }

    public void testDefaultReturnValueFloat() {
        assertEquals(0.0f, mock.floatReturningMethod(12), 0.0f);
        verify(mock);
    }

    public void testDefaultReturnValueDouble() {
        assertEquals(0.0d, mock.doubleReturningMethod(12), 0.0d);
        verify(mock);
    }

    public void testDefaultReturnValueObject() {
        assertEquals(null, mock.objectReturningMethod(12));
        verify(mock);
    }
}
