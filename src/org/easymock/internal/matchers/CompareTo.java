/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import org.easymock.IArgumentMatcher;

public abstract class CompareTo implements IArgumentMatcher {
    private final Comparable expected;

    public CompareTo(Comparable value) {
        this.expected = value;
    }

    public boolean matches(Object actual) {
        
        if(!(actual instanceof Comparable)) {
            return false;
        }
        
        return matchResult(((Comparable) actual).compareTo(expected));
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append(getName() + "(" + expected + ")");
    }
    
    protected abstract String getName();
    
    protected abstract boolean matchResult(int result);
}
