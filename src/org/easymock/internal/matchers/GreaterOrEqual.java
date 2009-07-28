/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

public class GreaterOrEqual extends CompareTo {

    public GreaterOrEqual(Comparable value) {
        super(value);
    }

    protected String getName() {
        return "geq";
    }

    protected boolean matchResult(int result) {
        return result >= 0;
    }
}
