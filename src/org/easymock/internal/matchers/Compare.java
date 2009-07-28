/*
 * Copyright (c) 2001-2007 OFFIS, Henri Tremblay.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import java.util.Comparator;

import org.easymock.IArgumentMatcher;
import org.easymock.LogicalOperator;

public class Compare implements IArgumentMatcher {

    private Object expected;

    private Comparator comparator;

    private LogicalOperator operator;

    public Compare(Object expected, Comparator comparator, LogicalOperator result) {
        this.expected = expected;
        this.comparator = comparator;
        this.operator = result;
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append(comparator + "(" + expected + ") " + operator.getSymbol()
                + " 0");
    }

    public boolean matches(Object actual) {
        if(actual == null) {
            return false;
        }
        return operator.matchResult(comparator.compare(actual, expected));
    }

}
