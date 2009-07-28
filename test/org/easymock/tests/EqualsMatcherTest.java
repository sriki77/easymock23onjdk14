/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import junit.framework.TestCase;

import org.easymock.ArgumentsMatcher;
import org.easymock.MockControl;

public class EqualsMatcherTest extends TestCase {
    final ArgumentsMatcher MATCHER = MockControl.EQUALS_MATCHER;

    public void testEqualsMatcher() {
        assertTrue(MATCHER.matches(null, null));
        assertFalse(MATCHER.matches(null, new Object[0]));
        assertFalse(MATCHER.matches(new Object[0], null));
        assertFalse(MATCHER.matches(new Object[] { "" }, new Object[] { null }));
        assertFalse(MATCHER.matches(new Object[] { null }, new Object[] { "" }));
        assertTrue(MATCHER
                .matches(new Object[] { null }, new Object[] { null }));
        assertTrue(MATCHER.matches(new Object[] { "x" }, new Object[] { "x" }));
    }

    public void testDifferentNumberOfArguments() {
        assertFalse(MATCHER.matches(new Object[2], new Object[3]));
    }
}