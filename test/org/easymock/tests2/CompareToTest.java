/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;
import org.easymock.EasyMock;

import java.math.BigDecimal;

import org.easymock.internal.matchers.*;
import org.easymock.jdk14.EasyMockTestCase;

public class CompareToTest extends EasyMockTestCase{

    public void testTestNotComparable() {
        CompareTo cmpTo = new CompareTo(new Long(5)) {

            protected String getName() {
                return null;
            }

            protected boolean matchResult(int result) {
                fail("Shouldn't be called since the passed argument is not Comparable");
                return true;
            }

        };

        assertFalse(cmpTo.matches(new Object()));
    }

    public void testTestLessThan() {
        test(new LessThan("b"), true, false, false, "lt");
    }

    public void testTestGreateThan() {
        test(new GreaterThan("b"), false, true, false, "gt");
    }

    public void testTestLessOrEqual() {
        test(new LessOrEqual("b"), true, false, true, "leq");
    }

    public void testTestGreateOrEqual() {
        test(new GreaterOrEqual("b"), false, true, true, "geq");
    }

    public void testTestCompareEqual() {
        test(new CompareEqual("b"), false, false, true, "cmpEq");

        // Make sure it works when equals provide a different result than
        // compare
        CompareEqual cmpEq = new CompareEqual(new BigDecimal("5.00"));
        assertTrue(cmpEq.matches(new BigDecimal("5")));
    }

    private void test(CompareTo cmpTo, boolean lower, boolean higher, boolean equals, String name) {

        assertEquals(lower, cmpTo.matches("a"));
        assertEquals(equals, cmpTo.matches("b"));
        assertEquals(higher, cmpTo.matches("c"));

        StringBuffer sb = new StringBuffer();
        cmpTo.appendTo(sb);
        assertEquals(name + "(b)", sb.toString());
    }
}
