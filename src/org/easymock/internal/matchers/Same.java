/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import org.easymock.IArgumentMatcher;

public class Same implements IArgumentMatcher {

    private final Object expected;

    public Same(Object expected) {
        this.expected = expected;
    }

    public Same(long cValue) {
        this(new Long(cValue));
    }
    
    public Same(char cValue) {
        this(new Character(cValue));
    }
    
    public Same(float cValue) {
        this(new Float(cValue));
    }
    
    public Same(double cValue) {
        this(new Double(cValue));
    }
    
    public Same(boolean cValue) {
        this(new Boolean(cValue));
    }

    public boolean matches(Object actual) {
        return expected == actual;
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("same(");
        appendQuoting(buffer);
        buffer.append(expected);
        appendQuoting(buffer);
        buffer.append(")");
    }

    private void appendQuoting(StringBuffer buffer) {
        if (expected instanceof String) {
            buffer.append("\"");
        } else if (expected instanceof Character) {
            buffer.append("'");
        }
    }
}
