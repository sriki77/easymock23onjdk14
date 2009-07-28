/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class CallbackAndArgumentsTest extends EasyMockTestCase {

    private IMethods mock;

    public void setUp() {
        mock = (IMethods) createStrictMock(IMethods.class);
    }

    public void testCallbackGetsArguments() {

        final StringBuffer buffer = new StringBuffer();

        mock.simpleMethodWithArgument((String) notNull());
        expectLastCall().andAnswer(new IAnswer() {
            public Object answer() {
                buffer.append((String) getCurrentArguments()[0]);
                return null;
            }
        }).times(2);

        replay(mock);

        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");

        verify(mock);

        assertEquals("12", buffer.toString());
    }

    public void testCurrentArgumentsFailsOutsideCallbacks() {
        
        try {
            getCurrentArguments();
            fail("Should throw exception");
        } catch (IllegalStateException e) {
        }
    }

    public void testCallbackGetsArgumentsEvenIfAMockCallsAnother() {

        final StringBuffer buffer = new StringBuffer();

        final IMethods mock2 = (IMethods) createStrictMock(IMethods.class);
        mock2.simpleMethod();
        expectLastCall().andAnswer(new IAnswer() {
            public Object answer() {
                // empty, only needed to force deletion of arguments
                return null;
            }
        }).times(2);

        mock.simpleMethodWithArgument((String) notNull());
        expectLastCall().andAnswer(new IAnswer() {
            public Object answer() {
                mock2.simpleMethod();
                buffer.append((String) getCurrentArguments()[0]);
                return null;
            }
        }).times(2);

        replay(mock);
        replay(mock2);

        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");

        verify(mock);
        verify(mock2);

        assertEquals("12", buffer.toString());
    }
}
