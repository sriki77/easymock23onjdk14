/*
 * Copyright (c) 2001-2007 OFFIS, Henri Tremblay.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock;

/**
 * See {@link EasyMock#cmp}
 */
public abstract class LogicalOperator {
    public static final LogicalOperator LESS_THAN = new LogicalOperator("<") {
        public boolean matchResult(int result) {
            return result < 0;
        }
    };

    public static final LogicalOperator LESS_OR_EQUAL = new LogicalOperator("<=") {
        public boolean matchResult(int result) {
            return result <= 0;
        }
    };

    public static final LogicalOperator EQUAL = new LogicalOperator("==") {
        public boolean matchResult(int result) {
            return result == 0;
        }
    };

    public static final LogicalOperator GREATER_OR_EQUAL = new LogicalOperator(">=") {
        public boolean matchResult(int result) {
            return result >= 0;
        }
    };

    public static final LogicalOperator GREATER = new LogicalOperator(">") {
        public boolean matchResult(int result) {
            return result > 0;
        }
    };

    private String symbol;

    private LogicalOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract boolean matchResult(int result);
}
