/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.MockControl;

public class UsageCallCountTest extends TestCase{

    private MockControl control;

    private VoidMethodInterface mock;

    private interface VoidMethodInterface {
        void method();
    }

    public void setUp() {
        control = MockControl.createControl(VoidMethodInterface.class);
        mock = (VoidMethodInterface) control.getMock();
    }

    
    public void testMockWithNoExpectedCallsPassesWithNoCalls() {
        control.replay();
        control.verify();
    }

    
    public void testMockWithNoExpectedCallsFailsAtFirstCall() {
        control.replay();
        assertMethodCallFails();
    }

    
    public void testMockWithOneExpectedCallFailsAtVerify() {
        callMethodOnce();
        control.replay();
        assertVerifyFails();
    }

    
    public void testMockWithOneExpectedCallPassesWithOneCall() {
        callMethodOnce();
        control.replay();
        callMethodOnce();
        control.verify();
    }

    
    public void testMockWithOneExpectedCallFailsAtSecondCall() {
        callMethodOnce();
        control.replay();
        callMethodOnce();
        assertMethodCallFails();
    }

    
    public void tooFewCalls() {
        callMethodThreeTimes();
        control.replay();
        callMethodTwice();
        assertVerifyFails();
    }

    
    public void correctNumberOfCalls() {
        callMethodThreeTimes();
        control.replay();
        callMethodThreeTimes();
        control.verify();
    }

    
    public void tooManyCalls() {
        callMethodThreeTimes();
        control.replay();
        callMethodThreeTimes();
        assertMethodCallFails();
    }

    private void callMethodOnce() {
        mock.method();
    }

    private void callMethodTwice() {
        mock.method();
        mock.method();
    }

    private void callMethodThreeTimes() {
        mock.method();
        mock.method();
        mock.method();
    }

    private void assertVerifyFails() {
        try {
            control.verify();
            fail("Expected AssertionError");
        } catch (AssertionError expected) {
        }
    }

    private void assertMethodCallFails() {
        try {
            mock.method();
            fail("Expected AssertionError");
        } catch (AssertionError expected) {
        }
    }

    
    public void noUpperLimitWithoutCallCountSet() {
        mock.method();
        control.setVoidCallable(MockControl.ONE_OR_MORE);
        control.replay();
        assertVerifyFails();
        mock.method();
        control.verify();
        mock.method();
        control.verify();
        mock.method();
        control.verify();
    }
}
