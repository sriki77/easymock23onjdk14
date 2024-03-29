/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;

public class UsageUnorderedTest extends TestCase {

    public interface Interface {
        void method(int number);
    }

    public void testMessage() {
        MockControl control = MockControl
                .createControl(Interface.class);
        Interface mock =  (Interface) control.getMock();

        mock.method(0);
        control.setMatcher(MockControl.ALWAYS_MATCHER);
        control.setVoidCallable(1);
        mock.method(0);
        control.setVoidCallable(2);
        mock.method(1);

        control.replay();

        mock.method(6);
        mock.method(7);
        mock.method(1);
        mock.method(25);

        try {
            mock.method(42);
            fail();
        } catch (AssertionError expected) {
            assertEquals("\n  Unexpected method call method(42):"
                    + "\n    method(<any>): expected: 3, actual: 3 (+1)"
                    + "\n    method(<any>): expected: 1, actual: 1 (+1)",
                    expected.getMessage());
        }
    }
}
