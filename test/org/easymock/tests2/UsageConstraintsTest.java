/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import java.math.BigDecimal;
import java.util.Comparator;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.LogicalOperator;
import org.easymock.internal.matchers.Equals;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class UsageConstraintsTest extends EasyMockTestCase {
    private IMethods mock;

    public void setUp() {
        mock = (IMethods) createMock(IMethods.class);
    }

    public void testEqualsMissing() {
        mock.simpleMethodWithArgument((String) not(eq("asd")));
        try {
            mock.simpleMethodWithArgument((String) not("jkl"));
            fail();
        } catch (IllegalStateException e) {
            assertEquals("no matchers found.", e.getMessage());
        }
        try {
            mock.simpleMethodWithArgument((String) or(eq("jkl"), "asd"));
            fail();
        } catch (IllegalStateException e) {
            assertEquals("2 matchers expected, 1 recorded.", e.getMessage());
        }
        try {
            mock.threeArgumentMethod(1, "asd", (String) eq("asd"));
            fail();
        } catch (IllegalStateException e) {
            assertEquals("3 matchers expected, 1 recorded.", e.getMessage());
        }

    }

    public void testDifferentConstraintsOnSameCall() {
        mock.simpleMethodWithArgument((String) isNull());
        mock.simpleMethodWithArgument((String) notNull());
        replay(mock);
        mock.simpleMethodWithArgument(null);
        mock.simpleMethodWithArgument("2");
    }

    public void testEquals() {
        assertEquals(new Equals(null), new Equals(null));
        assertEquals(new Equals(new Integer(2)), new Equals(new Integer(2)));
        assertFalse(new Equals(null).equals(null));
        assertFalse(new Equals(null).equals("Test"));
        try {
            new Equals(null).hashCode();
            fail();
        } catch (UnsupportedOperationException expected) {
        }
    }

    public void testConstraints() {
        expect(mock.threeArgumentMethod(and(geq(7), leq(10)), isA(String.class), contains("123"))).andReturn("456")
                .atLeastOnce();
        replay(mock);
        boolean failed = false;
        try {
            mock.threeArgumentMethod(11, "", "01234");
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed) {
            fail();
        }
        failed = false;
        try {
            mock.threeArgumentMethod(8, new Object(), "01234");
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed) {
            fail();
        }
        failed = false;
        try {
            mock.threeArgumentMethod(8, "", "no match");
        } catch (AssertionError expected) {
            failed = true;
        }
        if (!failed) {
            fail();
        }
        assertEquals("456", mock.threeArgumentMethod(8, "", "01234"));
        verify(mock);
    }

    public void testAndOverloaded() {
        expect(mock.oneArg(and(eq(false), eq(false)))).andReturn("0");
        expect(mock.oneArg(and(eq((byte) 1), eq((byte) 1)))).andReturn("1");
        expect(mock.oneArg(and(eq('a'), eq('a')))).andReturn("2");
        expect(mock.oneArg(and(eq((double) 1), eq((double) 1)))).andReturn("3");
        expect(mock.oneArg(and(eq((float) 1), eq((float) 1)))).andReturn("4");
        expect(mock.oneArg(and(eq((int) 1), eq((int) 1)))).andReturn("5");
        expect(mock.oneArg(and(eq((long) 1), eq((long) 1)))).andReturn("6");
        expect(mock.oneArg(and(eq((short) 1), eq((short) 1)))).andReturn("7");
        expect(mock.oneArg((String) and(contains("a"), contains("d")))).andReturn("8");
        expect(mock.oneArg(and(isA(Class.class), eq(Object.class)))).andReturn("9");
        replay(mock);
        assertEquals("8", mock.oneArg("abcde"));
        assertEquals("9", mock.oneArg(Object.class));
        assertEquals("0", mock.oneArg(false));
        assertEquals("1", mock.oneArg((byte) 1));
        assertEquals("2", mock.oneArg('a'));
        assertEquals("3", mock.oneArg((double) 1));
        assertEquals("7", mock.oneArg((short) 1));
        assertEquals("4", mock.oneArg((float) 1));
        assertEquals("5", mock.oneArg((int) 1));
        assertEquals("6", mock.oneArg((long) 1));
        verify(mock);
    }

    public void testOrOverloaded() {
        expect(mock.oneArg(or(eq(false), eq(true)))).andReturn("0");
        expect(mock.oneArg(or(eq((byte) 1), eq((byte) 2)))).andReturn("1");
        expect(mock.oneArg(or(eq((char) 1), eq((char) 2)))).andReturn("2");
        expect(mock.oneArg(or(eq((double) 1), eq((double) 2)))).andReturn("3");
        expect(mock.oneArg(or(eq((float) 1), eq((float) 2)))).andReturn("4");
        expect(mock.oneArg(or(eq((int) 1), eq((int) 2)))).andReturn("5");
        expect(mock.oneArg(or(eq((long) 1), eq((long) 2)))).andReturn("6");
        expect(mock.oneArg(or(eq((short) 1), eq((short) 2)))).andReturn("7");
        expect(mock.oneArg((String)or(eq("asd"), eq("jkl")))).andReturn("8");
        expect(mock.oneArg(or(eq(this.getClass()), eq(Object.class)))).andReturn("9");
        replay(mock);
        assertEquals("9", mock.oneArg(Object.class));
        assertEquals("0", mock.oneArg(true));
        assertEquals("1", mock.oneArg((byte) 2));
        assertEquals("2", mock.oneArg((char) 1));
        assertEquals("3", mock.oneArg((double) 2));
        assertEquals("7", mock.oneArg((short) 1));
        assertEquals("8", mock.oneArg("jkl"));
        assertEquals("4", mock.oneArg((float) 1));
        assertEquals("5", mock.oneArg((int) 2));
        assertEquals("6", mock.oneArg((long) 1));
        verify(mock);
    }

    public void testNotOverloaded() {
        expect(mock.oneArg(not(eq(false)))).andReturn("0");
        expect(mock.oneArg(not(eq((byte) 1)))).andReturn("1");
        expect(mock.oneArg(not(eq('a')))).andReturn("2");
        expect(mock.oneArg(not(eq((double) 1)))).andReturn("3");
        expect(mock.oneArg(not(eq((float) 1)))).andReturn("4");
        expect(mock.oneArg(not(eq((int) 1)))).andReturn("5");
        expect(mock.oneArg(not(eq((long) 1)))).andReturn("6");
        expect(mock.oneArg(not(eq((short) 1)))).andReturn("7");
        expect(mock.oneArg((String)not(contains("a")))).andReturn("8");
        expect(mock.oneArg(not(isA(Class.class)))).andReturn("9");
        replay(mock);
        assertEquals("9", mock.oneArg(new Object()));
        assertEquals("0", mock.oneArg(true));
        assertEquals("1", mock.oneArg((byte) 2));
        assertEquals("2", mock.oneArg('b'));
        assertEquals("3", mock.oneArg((double) 2));
        assertEquals("7", mock.oneArg((short) 2));
        assertEquals("8", mock.oneArg("bcde"));
        assertEquals("4", mock.oneArg((float) 2));
        assertEquals("5", mock.oneArg((int) 2));
        assertEquals("6", mock.oneArg((long) 2));
        verify(mock);
    }

    public void testLessOrEqualOverloaded() {
        expect(mock.oneArg(leq((byte) 1))).andReturn("1");
        expect(mock.oneArg(leq((double) 1))).andReturn("3");
        expect(mock.oneArg(leq((float) 1))).andReturn("4");
        expect(mock.oneArg(leq((int) 1))).andReturn("5");
        expect(mock.oneArg(leq((long) 1))).andReturn("6");
        expect(mock.oneArg(leq((short) 1))).andReturn("7");
        expect(mock.oneArg(leq(new BigDecimal("1")))).andReturn("8");
        replay(mock);
        assertEquals("1", mock.oneArg((byte) 1));
        assertEquals("3", mock.oneArg((double) 1));
        assertEquals("7", mock.oneArg((short) 0));
        assertEquals("4", mock.oneArg((float) -5));
        assertEquals("5", mock.oneArg((int) -2));
        assertEquals("6", mock.oneArg((long) -3));
        assertEquals("8", mock.oneArg(new BigDecimal("0.5")));
        verify(mock);
    }

    public void testLessThanOverloaded() {
        expect(mock.oneArg(lt((byte) 1))).andReturn("1");
        expect(mock.oneArg(lt((double) 1))).andReturn("3");
        expect(mock.oneArg(lt((float) 1))).andReturn("4");
        expect(mock.oneArg(lt((int) 1))).andReturn("5");
        expect(mock.oneArg(lt((long) 1))).andReturn("6");
        expect(mock.oneArg(lt((short) 1))).andReturn("7");
        expect(mock.oneArg(lt(new BigDecimal("1")))).andReturn("8");
        replay(mock);
        assertEquals("1", mock.oneArg((byte) 0));
        assertEquals("3", mock.oneArg((double) 0));
        assertEquals("7", mock.oneArg((short) 0));
        assertEquals("4", mock.oneArg((float) -4));
        assertEquals("5", mock.oneArg((int) -34));
        assertEquals("6", mock.oneArg((long) -6));
        assertEquals("8", mock.oneArg(new BigDecimal("0.5")));
        verify(mock);
    }

    public void testGreaterOrEqualOverloaded() {
        expect(mock.oneArg(geq((byte) 1))).andReturn("1");
        expect(mock.oneArg(geq((double) 1))).andReturn("3");
        expect(mock.oneArg(geq((float) 1))).andReturn("4");
        expect(mock.oneArg(geq((int) 1))).andReturn("5");
        expect(mock.oneArg(geq((long) 1))).andReturn("6");
        expect(mock.oneArg(geq((short) 1))).andReturn("7");
        expect(mock.oneArg(geq(new BigDecimal("1")))).andReturn("8");
        replay(mock);
        assertEquals("1", mock.oneArg((byte) 2));
        assertEquals("3", mock.oneArg((double) 1));
        assertEquals("7", mock.oneArg((short) 2));
        assertEquals("4", mock.oneArg((float) 3));
        assertEquals("5", mock.oneArg((int) 4));
        assertEquals("6", mock.oneArg((long) 5));
        assertEquals("8", mock.oneArg(new BigDecimal("1.5")));
        verify(mock);
    }

    public void testGreaterThanOverloaded() {
        expect(mock.oneArg(gt((byte) 1))).andReturn("1");
        expect(mock.oneArg(gt((double) 1))).andReturn("3");
        expect(mock.oneArg(gt((float) 1))).andReturn("4");
        expect(mock.oneArg(gt((int) 1))).andReturn("5");
        expect(mock.oneArg(gt((long) 1))).andReturn("6");
        expect(mock.oneArg(gt((short) 1))).andReturn("7");
        expect(mock.oneArg(gt(new BigDecimal("1")))).andReturn("8");
        replay(mock);
        assertEquals("1", mock.oneArg((byte) 2));
        assertEquals("3", mock.oneArg((double) 2));
        assertEquals("7", mock.oneArg((short) 2));
        assertEquals("4", mock.oneArg((float) 3));
        assertEquals("5", mock.oneArg((int) 2));
        assertEquals("6", mock.oneArg((long) 5));
        assertEquals("8", mock.oneArg(new BigDecimal("1.5")));
        verify(mock);
    }

    public void testCmpTo() {
        expect(mock.oneArg(cmpEq(new BigDecimal("1.5")))).andReturn("0");
        replay(mock);
        assertEquals("0", mock.oneArg(new BigDecimal("1.50")));
        verify(mock);
    }

    public static class A {
        private int value;

        public A(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public void testCompareWithComparator() {
        Comparator comparator = new Comparator() {
            public int compare(Object a1, Object a2) {
                return ((A) a1).getValue() - ((A) a2).getValue();
            }
        };

        // Check my comparator works
        assertTrue(comparator.compare(new A(1), new A(2)) < 0);
        assertTrue(comparator.compare(new A(2), new A(1)) > 0);
        assertTrue(comparator.compare(new A(1), new A(1)) == 0);

        // Now test cmp
        checkOrder(mock, true);

        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.EQUAL))).andReturn("0");

        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.GREATER))).andReturn("1");

        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.GREATER_OR_EQUAL))).andReturn("2");
        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.GREATER_OR_EQUAL))).andReturn("2");

        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.LESS_OR_EQUAL))).andReturn("3");
        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.LESS_OR_EQUAL))).andReturn("3");

        expect(mock.oneArg(cmp(new A(5), comparator, LogicalOperator.LESS_THAN))).andReturn("4");

        replay(mock);

        checkItFails(null); // null is not comparable so always return false
        try {
            mock.oneArg("");
            fail();
        } catch (AssertionError e) {
        } // different type isn't either

        checkItFails(new A(4));
        checkItFails(new A(6));
        assertEquals("0", mock.oneArg(new A(5)));

        checkItFails(new A(4));
        checkItFails(new A(5));
        assertEquals("1", mock.oneArg(new A(6)));

        checkItFails(new A(4));
        assertEquals("2", mock.oneArg(new A(6)));
        assertEquals("2", mock.oneArg(new A(5)));

        checkItFails(new A(6));
        assertEquals("3", mock.oneArg(new A(4)));
        assertEquals("3", mock.oneArg(new A(5)));

        checkItFails(new A(5));
        checkItFails(new A(6));
        assertEquals("4", mock.oneArg(new A(4)));

        verify(mock);
    }

    private void checkItFails(A a) {
        try {
            mock.oneArg(a);
            fail();
        } catch (AssertionError e) {
        }
    }

    public void testAny() {
        expect(mock.oneArg(anyBoolean())).andReturn("0");
        expect(mock.oneArg(anyByte())).andReturn("1");
        expect(mock.oneArg(anyChar())).andReturn("2");
        expect(mock.oneArg(anyDouble())).andReturn("3");
        expect(mock.oneArg(anyFloat())).andReturn("4");
        expect(mock.oneArg(anyInt())).andReturn("5");
        expect(mock.oneArg(anyLong())).andReturn("6");
        expect(mock.oneArg(anyShort())).andReturn("7");
        expect(mock.oneArg((String) anyObject())).andReturn("8");
        expect(mock.oneArg(anyObject())).andReturn("9");
        replay(mock);
        assertEquals("9", mock.oneArg(new Object()));
        assertEquals("0", mock.oneArg(true));
        assertEquals("1", mock.oneArg((byte) 1));
        assertEquals("2", mock.oneArg((char) 1));
        assertEquals("3", mock.oneArg((double) 1));
        assertEquals("7", mock.oneArg((short) 1));
        assertEquals("8", mock.oneArg("Test"));
        assertEquals("4", mock.oneArg((float) 1));
        assertEquals("5", mock.oneArg((int) 1));
        assertEquals("6", mock.oneArg((long) 1));
        verify(mock);
    }

    public void testArrayEquals() {
        expect(mock.oneArray(aryEq(new boolean[] { true }))).andReturn("0");
        expect(mock.oneArray(aryEq(new byte[] { 1 }))).andReturn("1");
        expect(mock.oneArray(aryEq(new char[] { 1 }))).andReturn("2");
        expect(mock.oneArray(aryEq(new double[] { 1 }))).andReturn("3");
        expect(mock.oneArray(aryEq(new float[] { 1 }))).andReturn("4");
        expect(mock.oneArray(aryEq(new int[] { 1 }))).andReturn("5");
        expect(mock.oneArray(aryEq(new long[] { 1 }))).andReturn("6");
        expect(mock.oneArray(aryEq(new short[] { 1 }))).andReturn("7");
        expect(mock.oneArray((String[])aryEq(new String[] { "Test" }))).andReturn("8");
        expect(mock.oneArray(aryEq(new Object[] { "Test" }))).andReturn("9");
        replay(mock);
        assertEquals("9", mock.oneArray(new Object[] { "Test" }));
        assertEquals("0", mock.oneArray(new boolean[] { true }));
        assertEquals("1", mock.oneArray(new byte[] { 1 }));
        assertEquals("2", mock.oneArray(new char[] { 1 }));
        assertEquals("3", mock.oneArray(new double[] { 1 }));
        assertEquals("7", mock.oneArray(new short[] { 1 }));
        assertEquals("8", mock.oneArray(new String[] { "Test" }));
        assertEquals("4", mock.oneArray(new float[] { 1 }));
        assertEquals("5", mock.oneArray(new int[] { 1 }));
        assertEquals("6", mock.oneArray(new long[] { 1 }));
        verify(mock);
    }

    public void testGreaterOrEqual() {
        expect(mock.oneArg(geq(7))).andReturn("1").times(3);
        expect(mock.oneArg(lt(7))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(7));
        assertEquals("2", mock.oneArg(6));
        assertEquals("1", mock.oneArg(8));
        assertEquals("2", mock.oneArg(6));
        assertEquals("1", mock.oneArg(9));

        verify(mock);
    }

    public void testGreaterThan() {
        expect(mock.oneArg(gt(7))).andReturn("1").times(3);
        expect(mock.oneArg(leq(7))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(8));
        assertEquals("2", mock.oneArg(7));
        assertEquals("1", mock.oneArg(9));
        assertEquals("2", mock.oneArg(6));
        assertEquals("1", mock.oneArg(10));

        verify(mock);
    }

    public void testLessOrEqual() {
        expect(mock.oneArg(leq(7))).andReturn("1").times(3);
        expect(mock.oneArg(gt(7))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(7));
        assertEquals("2", mock.oneArg(8));
        assertEquals("1", mock.oneArg(6));
        assertEquals("2", mock.oneArg(9));
        assertEquals("1", mock.oneArg(5));

        verify(mock);
    }

    public void testLessThan() {
        expect(mock.oneArg(lt(7))).andReturn("1").times(3);
        expect(mock.oneArg(geq(7))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(5));
        assertEquals("2", mock.oneArg(7));
        assertEquals("1", mock.oneArg(6));
        assertEquals("2", mock.oneArg(8));
        assertEquals("1", mock.oneArg(4));

        verify(mock);
    }

    public void testTestOr() {
        expect(mock.oneArg(or(eq(7), eq(9)))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(anyInt())).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(7));
        assertEquals("1", mock.oneArg(9));
        assertEquals("2", mock.oneArg(10));

        verify(mock);
    }

    public void testTestNull() {
        expect(mock.threeArgumentMethod(eq(1), isNull(), (String) eq(""))).andReturn("1").atLeastOnce();
        expect(mock.threeArgumentMethod(eq(1), not(isNull()), (String) eq(""))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.threeArgumentMethod(1, null, ""));
        assertEquals("2", mock.threeArgumentMethod(1, new Object(), ""));

        verify(mock);
    }

    public void testTestNotNull() {
        expect(mock.threeArgumentMethod(eq(1), notNull(), (String) eq(""))).andReturn("1").atLeastOnce();
        expect(mock.threeArgumentMethod(eq(1), not(notNull()), (String) eq(""))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.threeArgumentMethod(1, new Object(), ""));
        assertEquals("2", mock.threeArgumentMethod(1, null, ""));

        verify(mock);
    }

    public void testTestFind() {
        expect(mock.oneArg(find("[a-z]+\\d"))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(find("\\d\\d"))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg("1ab12"));
        assertEquals("2", mock.oneArg("312xx"));

        verify(mock);
    }

    public void testTestMatches() {
        expect(mock.oneArg(matches("[a-z]+\\d\\d"))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(matches("\\d\\d\\d"))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg("a12"));
        assertEquals("2", mock.oneArg("131"));

        verify(mock);
    }

    public void testTestContains() {
        expect(mock.oneArg(contains("ab"))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(contains("bc"))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg("xabcx"));
        assertEquals("2", mock.oneArg("xdbcx"));

        verify(mock);
    }

    public void testTestStartsWith() {
        expect(mock.oneArg(startsWith("ab"))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(startsWith("bc"))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg("abcx"));
        assertEquals("2", mock.oneArg("bcxe"));

        verify(mock);
    }

    public void testTestEndsWith() {
        expect(mock.oneArg(endsWith("ab"))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(endsWith("bc"))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg("xab"));
        assertEquals("2", mock.oneArg("xbc"));

        verify(mock);
    }

    public void testEqualsWithDelta() {
        expect(mock.oneArg(eq(1.0D, 0.1D))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(eq(2.0D, 0.1D))).andStubReturn("2");
        expect(mock.oneArg(eq(1.0F, 0.1F))).andReturn("3").atLeastOnce();
        expect(mock.oneArg(eq(2.0F, 0.1F))).andStubReturn("4");
        expect(mock.oneArg(eq(2.0F, 0.1F))).andStubReturn("4");

        replay(mock);

        assertEquals("1", mock.oneArg(1.0));
        assertEquals("1", mock.oneArg(0.91));
        assertEquals("1", mock.oneArg(1.09));
        assertEquals("2", mock.oneArg(2.0));

        assertEquals("3", mock.oneArg(1.0F));
        assertEquals("3", mock.oneArg(0.91F));
        assertEquals("3", mock.oneArg(1.09F));
        assertEquals("4", mock.oneArg(2.0F));

        verify(mock);
    }

    public void testTestSame() {
        Object one = new String("1243");
        Object two = new String("1243");

        assertNotSame(one, two);
        assertEquals(one, two);

        expect(mock.oneArg(same(one))).andReturn("1").atLeastOnce();
        expect(mock.oneArg(same(two))).andStubReturn("2");

        replay(mock);

        assertEquals("1", mock.oneArg(one));
        assertEquals("2", mock.oneArg(two));

        verify(mock);
    }
}
