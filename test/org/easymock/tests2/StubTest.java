/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class StubTest extends EasyMockTestCase {
    private IMethods mock;

    public void setUp() {
        mock = (IMethods) createStrictMock(IMethods.class);
    }

    public void testStub() {
        mock.simpleMethodWithArgument("1");
        expectLastCall().anyTimes();
        mock.simpleMethodWithArgument("2");
        expectLastCall().anyTimes();
        mock.simpleMethodWithArgument("3");
        expectLastCall().asStub();

        replay(mock);

        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("1");
        mock.simpleMethodWithArgument("2");
        mock.simpleMethodWithArgument("3");
        mock.simpleMethodWithArgument("3");

        verify(mock);

    }

    public void testStubWithReturnValue() {
        expect(mock.oneArg("1")).andReturn("A").andStubReturn("B");
        expect(mock.oneArg("2")).andThrow(new IllegalArgumentException())
                .andStubThrow(new IllegalStateException());

        replay(mock);

        assertEquals("A", mock.oneArg("1"));
        assertEquals("B", mock.oneArg("1"));
        assertEquals("B", mock.oneArg("1"));
        try {
            mock.oneArg("2");
        } catch (IllegalArgumentException ignored) {
        }
        assertEquals("B", mock.oneArg("1"));
        try {
            mock.oneArg("2");
        } catch (IllegalStateException ignored) {
        }
        assertEquals("B", mock.oneArg("1"));
        try {
            mock.oneArg("2");
        } catch (IllegalStateException ignored) {
        }
        verify(mock);
    }

}
