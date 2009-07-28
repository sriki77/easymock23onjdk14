/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import java.util.Iterator;
import java.util.List;

import org.easymock.IArgumentMatcher;

public class And implements IArgumentMatcher {

    private final List matchers;

    public And(List matchers) {
        this.matchers = matchers;
    }

    public boolean matches(Object actual) {
        Iterator iterator=matchers.iterator();
        while (iterator.hasNext()) {
            IArgumentMatcher matcher = (IArgumentMatcher) iterator.next();
            if (!matcher.matches(actual)) {
                return false;
            }
        }
        return true;
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("and(");
        for (Iterator it = matchers.iterator(); it.hasNext();) {
            ((IArgumentMatcher) it.next()).appendTo(buffer);
            if (it.hasNext()) {
                buffer.append(", ");
            }
        }
        buffer.append(")");
    }
}
