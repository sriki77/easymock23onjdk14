/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import junit.framework.TestCase;
import org.easymock.EasyMock;

import org.easymock.IAnswer;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class CallbackTest extends EasyMockTestCase{

    private IMethods mock;

    private static class Callback implements IAnswer {
        private int callCount;

        private Object result;

        public Callback(Object result) {
            this.result = result;
        }

        public void run() {
        }

        public int getCallCount() {
            return callCount;
        }

        public Object answer() throws Throwable {
            callCount++;
            return result;
        }
    }

    public void setUp() {
        mock = (IMethods) createStrictMock(IMethods.class);
    }

    public void testCallback() {
        Callback c1 = new Callback("1");
        Callback c2 = new Callback(null);
        Callback c3 = new Callback(null);

        expect(mock.oneArg("2")).andAnswer(c1).times(2);
        mock.simpleMethodWithArgument("One");
        expectLastCall().andAnswer(c2);
        mock.simpleMethodWithArgument("Two");
        expectLastCall().andAnswer(c3).times(2);

        replay(mock);

        mock.oneArg("2");
        mock.oneArg("2");
        try {
            mock.oneArg("2");
        } catch (AssertionError ignored) {
        }
        try {
            mock.simpleMethodWithArgument("Two");
        } catch (AssertionError ignored) {
        }
        mock.simpleMethodWithArgument("One");
        try {
            mock.simpleMethodWithArgument("One");
        } catch (AssertionError ignored) {
        }
        mock.simpleMethodWithArgument("Two");
        mock.simpleMethodWithArgument("Two");
        try {
            mock.simpleMethodWithArgument("Two");
        } catch (AssertionError ignored) {
        }
        verify(mock);

        assertEquals(2, c1.getCallCount());
        assertEquals(1, c2.getCallCount());
        assertEquals(2, c3.getCallCount());
    }
}
