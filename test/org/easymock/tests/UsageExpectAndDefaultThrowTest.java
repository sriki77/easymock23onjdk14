/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;
import org.easymock.jdk14.IMethods;

/**
 * Same as UsageExpectAndThrowTest except that each mocked method is called
 * twice to make sure the defaulting works fine.
 * 
 * @author Henri Tremblay
 */
public class UsageExpectAndDefaultThrowTest extends TestCase {
    private MockControl control;

    private IMethods mock;

    private static RuntimeException EXCEPTION = new RuntimeException();

    public void setUp() {
        control = MockControl.createControl(IMethods.class);
        mock = (IMethods) control.getMock();
    }

    public void testBooleanType() {
        control.expectAndDefaultThrow(mock.booleanReturningMethod(4), EXCEPTION);
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

    public void testLongType() {
        control.expectAndDefaultThrow(mock.longReturningMethod(4), EXCEPTION);
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

    public void testFloatType() {
        control.expectAndDefaultThrow(mock.floatReturningMethod(4), EXCEPTION);
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

    public void testDoubleType() {
        control.expectAndDefaultThrow(mock.doubleReturningMethod(4), EXCEPTION);
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

    public void testObject() {
        control.expectAndDefaultThrow(mock.objectReturningMethod(4), EXCEPTION);
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

    public void testThrowableAndDefaultThrowable() throws Exception {

        mock.oneArg("1");

        EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
        control.setDefaultThrowable(new IllegalStateException());

        control.replay();

        try {
            mock.oneArg("1");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            mock.oneArg("1");
        } catch (IllegalStateException ignored) {
        }
        try {
            mock.oneArg("2");
        } catch (IllegalStateException ignored) {
        }
        control.verify();
    }

}
