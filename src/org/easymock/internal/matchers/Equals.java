/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import org.easymock.IArgumentMatcher;

public class Equals implements IArgumentMatcher {

    private final Object expected;

    public Equals(Object expected) {
        this.expected = expected;
    }
    
    public Equals(char iValue) {
        this(new Character(iValue));
     }

    public Equals(short iValue) {
        this(new Short(iValue));
     }
    
    public Equals(int iValue) {
        this(new Integer(iValue));
     }
    
    public Equals(long iValue) {
       this(new Long(iValue));
    }
    public Equals(float iValue) {
        this(new Float(iValue));
     }
    
    public Equals(double iValue) {
        this(new Double(iValue));
     }
    public Equals(boolean iValue) {
        this(new Boolean(iValue));
     }

    public boolean matches(Object actual) {
        if (this.expected == null) {
            return actual == null;
        }
        return expected.equals(actual);
    }

    public void appendTo(StringBuffer buffer) {
        appendQuoting(buffer);
        buffer.append(expected);
        appendQuoting(buffer);
    }

    private void appendQuoting(StringBuffer buffer) {
        if (expected instanceof String) {
            buffer.append("\"");
        } else if (expected instanceof Character) {
            buffer.append("'");
        }
    }

    protected final Object getExpected() {
        return expected;
    }

    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass()))
            return false;
        Equals other = (Equals) o;
        return this.expected == null && other.expected == null
                || this.expected != null
                && this.expected.equals(other.expected);
    }

    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() is not supported");
    }

}
