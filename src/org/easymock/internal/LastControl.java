/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import java.util.*;

import org.easymock.IArgumentMatcher;
import org.easymock.internal.matchers.And;
import org.easymock.internal.matchers.Not;
import org.easymock.internal.matchers.Or;

public class LastControl {
    private static final ThreadLocal threadToControl = new ThreadLocal();

    private static final ThreadLocal threadToCurrentArguments = new ThreadLocal();

    private static final ThreadLocal threadToArgumentMatcherStack = new ThreadLocal();

    public static synchronized void reportLastControl(MocksControl control) {
        threadToControl.set(control);
    }

    public static synchronized MocksControl lastControl() {
        return (MocksControl) threadToControl.get();
    }

    public static synchronized void reportMatcher(IArgumentMatcher matcher) {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        if (stack == null) {
            stack = new Stack();
            threadToArgumentMatcherStack.set(stack);
        }
        stack.push(matcher);
    }

    public static synchronized List pullMatchers() {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        if (stack == null) {
            return null;
        }
        threadToArgumentMatcherStack.set(null);
        return new ArrayList(stack);
    }

    public static synchronized void reportAnd(int count) {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        assertState(stack != null, "no matchers found.");
        stack.push(new And(popLastArgumentMatchers(count)));
    }

    public static synchronized void reportNot() {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        assertState(stack != null, "no matchers found.");
        stack.push(new Not((IArgumentMatcher) popLastArgumentMatchers(1).get(0)));
    }

    private static List popLastArgumentMatchers(int count) {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        assertState(stack != null, "no matchers found.");
        assertState(stack.size() >= count, "" + count + " matchers expected, "
                + stack.size() + " recorded.");
        List result = new LinkedList();
        result.addAll(stack.subList(stack.size() - count, stack.size()));
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        return result;
    }

    private static void assertState(boolean toAssert, String message) {
        if (!toAssert) {
            threadToArgumentMatcherStack.set(null);
            throw new IllegalStateException(message);
        }
    }

    public static void reportOr(int count) {
        Stack stack = (Stack) threadToArgumentMatcherStack.get();
        assertState(stack != null, "no matchers found.");
        stack.push(new Or(popLastArgumentMatchers(count)));
    }

    public static Object[] getCurrentArguments() {
        Stack stack = (Stack) threadToCurrentArguments.get();
        if (stack == null || stack.empty()) {
            return null;
        }
        return (Object[]) stack.lastElement();
    }

    public static void pushCurrentArguments(Object[] args) {
        Stack stack = (Stack) threadToCurrentArguments.get();
        if (stack == null) {
            stack = new Stack();
            threadToCurrentArguments.set(stack);
        }
        stack.push(args);
    }

    public static void popCurrentArguments() {
        Stack stack = (Stack) threadToCurrentArguments.get();
        stack.pop();
    }
}
