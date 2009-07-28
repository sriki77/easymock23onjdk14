/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import java.util.Arrays;

import org.easymock.IAnswer;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class AnswerTest extends EasyMockTestCase {

    private IMethods mock;

    public void setUp() {
        mock = (IMethods) createMock(IMethods.class);
    }

 

    
    public void testAnswer() {
        IAnswer firstAnswer = new IAnswer() {
            public Object answer() {
                assertTrue(Arrays.equals(new Object[] { new Integer(1), "2", "3" },
                        getCurrentArguments()));
                return "Call answered";
            }
        };

        IAnswer secondAnswer = new IAnswer() {
            public Object answer() {
                assertTrue(Arrays.equals(new Object[] { new Integer(1), "2", "3" },
                        getCurrentArguments()));
                throw new IllegalStateException("Call answered");
            }
        };

        expect(mock.threeArgumentMethod(1, "2", "3")).andAnswer(firstAnswer)
                .andReturn("Second call").andAnswer(secondAnswer).andReturn(
                        "Fourth call");

        replay(mock);

        assertEquals("Call answered", mock.threeArgumentMethod(1, "2", "3"));
        assertEquals("Second call", mock.threeArgumentMethod(1, "2", "3"));
        try {
            mock.threeArgumentMethod(1, "2", "3");
            fail();
        } catch (IllegalStateException expected) {
            assertEquals("Call answered", expected.getMessage());
        }
        assertEquals("Fourth call", mock.threeArgumentMethod(1, "2", "3"));

        verify(mock);
    }

    public void testStubAnswer() {
        IAnswer firstAnswer = new IAnswer() {
            public Object answer() {
                assertTrue(Arrays.equals(new Object[] { new Integer(1), "2", "3" },
                        getCurrentArguments()));
                return "Call answered";
            }
        };

        IAnswer secondAnswer = new IAnswer() {
            public Object answer() {
                assertTrue(Arrays.equals(new Object[] { new Integer(1), "2", "4" },
                        getCurrentArguments()));
                return "Call answered";
            }
        };

        expect(mock.threeArgumentMethod(1, "2", "3")).andReturn(42)
                .andStubAnswer(firstAnswer);
        expect(mock.threeArgumentMethod(1, "2", "4")).andStubAnswer(
                secondAnswer);

        replay(mock);

        assertEquals(new Integer(42), mock.threeArgumentMethod(1, "2", "3"));
        assertEquals("Call answered", mock.threeArgumentMethod(1, "2", "3"));
        assertEquals("Call answered", mock.threeArgumentMethod(1, "2", "4"));
        assertEquals("Call answered", mock.threeArgumentMethod(1, "2", "3"));
        assertEquals("Call answered", mock.threeArgumentMethod(1, "2", "3"));

        verify(mock);
    }

    public void testNullAnswerNotAllowed() {
        try {
            expect(mock.threeArgumentMethod(1, "2", "3")).andAnswer(null);
            fail();
        } catch (NullPointerException expected) {
            assertEquals("answer object must not be null", expected
                    .getMessage());
        }
    }

    public void testNullStubAnswerNotAllowed() {
        try {
            expect(mock.threeArgumentMethod(1, "2", "3")).andStubAnswer(null);
            fail();
        } catch (NullPointerException expected) {
            assertEquals("answer object must not be null", expected
                    .getMessage());
        }
    }

}
