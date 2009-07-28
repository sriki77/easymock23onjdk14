/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;
import org.easymock.EasyMock;

import java.util.ArrayList;
import java.util.List;

import org.easymock.IArgumentMatcher;
import org.easymock.internal.matchers.*;
import org.easymock.jdk14.EasyMockTestCase;

public class ConstraintsToStringTest extends EasyMockTestCase {
    private StringBuffer buffer;

    public void setUp() {
        buffer = new StringBuffer();
    }

    public void testSameToStringWithString() {
        new Same("X").appendTo(buffer);
        assertEquals("same(\"X\")", buffer.toString());

    }

    public void testNullToString() {
        Null.NULL.appendTo(buffer);
        assertEquals("isNull()", buffer.toString());
    }

    public void testNotNullToString() {
        NotNull.NOT_NULL.appendTo(buffer);
        assertEquals("notNull()", buffer.toString());
    }

    public void testAnyToString() {
        Any.ANY.appendTo(buffer);
        assertEquals("<any>", buffer.toString());
    }

    public void testSameToStringWithChar() {
        new Same('x').appendTo(buffer);
        assertEquals("same('x')", buffer.toString());
    }

    public void testSameToStringWithObject() {
        Object o = new Object() {
            public String toString() {
                return "X";
            }
        };
        new Same(o).appendTo(buffer);
        assertEquals("same(X)", buffer.toString());
    }

    public void testEqualsToStringWithString() {
        new Equals("X").appendTo(buffer);
        assertEquals("\"X\"", buffer.toString());

    }

    public void testEqualsToStringWithChar() {
        new Equals('x').appendTo(buffer);
        assertEquals("'x'", buffer.toString());
    }

    public void testEqualsToStringWithObject() {
        Object o = new Object() {
            public String toString() {
                return "X";
            }
        };
        new Equals(o).appendTo(buffer);
        assertEquals("X", buffer.toString());
    }

    public void testOrToString() {
        List matchers = new ArrayList();
        matchers.add(new Equals(1));
        matchers.add(new Equals(2));
        new Or(matchers).appendTo(buffer);
        assertEquals("or(1, 2)", buffer.toString());
    }

    public void testNotToString() {
        new Not(new Equals(1)).appendTo(buffer);
        assertEquals("not(1)", buffer.toString());
    }

    public void testAndToString() {
        List matchers = new ArrayList();
        matchers.add(new Equals(1));
        matchers.add(new Equals(2));
        new And(matchers).appendTo(buffer);
        assertEquals("and(1, 2)", buffer.toString());
    }

    public void testStartsWithToString() {
        new StartsWith("AB").appendTo(buffer);
        assertEquals("startsWith(\"AB\")", buffer.toString());
    }

    public void testEndsWithToString() {
        new EndsWith("AB").appendTo(buffer);
        assertEquals("endsWith(\"AB\")", buffer.toString());
    }

    public void testContainsToString() {
        new Contains("AB").appendTo(buffer);
        assertEquals("contains(\"AB\")", buffer.toString());
    }

    public void testFindToString() {
        new Find("\\s+").appendTo(buffer);
        assertEquals("find(\"\\\\s+\")", buffer.toString());
    }

    public void testMatchesToString() {
        new Matches("\\s+").appendTo(buffer);
        assertEquals("matches(\"\\\\s+\")", buffer.toString());
    }

}
