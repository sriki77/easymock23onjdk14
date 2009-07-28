/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

public class GreaterThan extends CompareTo {

    public GreaterThan(Comparable value) {
        super(value);
    }

    protected String getName() {
        return "gt";
    }

    protected boolean matchResult(int result) {
        return result > 0;
    }    
}
