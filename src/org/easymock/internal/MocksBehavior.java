/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.easymock.ArgumentsMatcher;
import org.easymock.MockControl;

public class MocksBehavior implements IMocksBehavior {

    private final List behaviorLists = new ArrayList();

    private List stubResults = new ArrayList();

    private final boolean nice;

    private boolean checkOrder;

    private int position = 0;

    public MocksBehavior(boolean nice) {
        this.nice = nice;
    }

    public final void addStub(ExpectedInvocation expected, Result result) {
        stubResults.add(new ExpectedInvocationAndResult(expected, result));
    }

    public void addExpected(ExpectedInvocation expected, Result result, Range count) {
        if (legacyMatcherProvider != null) {
            expected = expected.withMatcher(legacyMatcherProvider.getMatcher(expected.getMethod()));
        }
        addBehaviorListIfNecessary(expected);
        lastBehaviorList().addExpected(expected, result, count);
    }

    private final Result getStubResult(Invocation actual) {
        Iterator iter = stubResults.iterator();
        while (iter.hasNext()) {
            ExpectedInvocationAndResult each = (ExpectedInvocationAndResult) iter.next();
            if (each.getExpectedInvocation().matches(actual)) {
                return each.getResult();
            }
        }
        return null;
    }

    private void addBehaviorListIfNecessary(ExpectedInvocation expected) {
        if (behaviorLists.isEmpty() || !lastBehaviorList().allowsExpectedInvocation(expected, checkOrder)) {
            behaviorLists.add(new UnorderedBehavior(checkOrder));
        }
    }

    private UnorderedBehavior lastBehaviorList() {
        return (UnorderedBehavior) behaviorLists.get(behaviorLists.size() - 1);
    }

    public final Result addActual(Invocation actual) {
        int tempPosition = position;
        String errorMessage = "";
        while (position < behaviorLists.size()) {
            Result result = ((UnorderedBehavior) behaviorLists.get(position)).addActual(actual);
            if (result != null) {
                return result;
            }
            errorMessage += ((UnorderedBehavior) behaviorLists.get(position)).toString(actual);
            if (!((UnorderedBehavior) behaviorLists.get(position)).verify()) {
                break;
            }
            position++;
        }
        Result stubOrNice = getStubResult(actual);
        if (stubOrNice == null && nice) {
            stubOrNice =
                    Result.createReturnResult(RecordState.emptyReturnValueFor(actual.getMethod().getReturnType()));
        }
        if (stubOrNice != null) {
            position = tempPosition;
            return stubOrNice;
        }
        throw new AssertionErrorWrapper(new AssertionError("\n  Unexpected method call "
                + actual.toString(MockControl.EQUALS_MATCHER) + ":" + errorMessage.toString()));
    }

    public void verify() {
        boolean verified = true;
        StringBuffer errorMessage = new StringBuffer();
        Iterator iter = behaviorLists.subList(position, behaviorLists.size()).iterator();
        while (iter.hasNext()) {
            UnorderedBehavior behaviorList = (UnorderedBehavior) iter.next();
            errorMessage.append(behaviorList.toString());
            if (!behaviorList.verify()) {
                verified = false;
            }
        }
        if (verified) {
            return;
        }

        throw new AssertionErrorWrapper(new AssertionError("\n  Expectation failure on verify:"
                + errorMessage.toString()));
    }

    public void checkOrder(boolean value) {
        this.checkOrder = value;
    }

    private LegacyMatcherProvider legacyMatcherProvider;

    public LegacyMatcherProvider getLegacyMatcherProvider() {
        if (legacyMatcherProvider == null) {
            legacyMatcherProvider = new LegacyMatcherProvider();
        }
        return legacyMatcherProvider;
    }

    public void setDefaultMatcher(ArgumentsMatcher matcher) {
        getLegacyMatcherProvider().setDefaultMatcher(matcher);
    }

    public void setMatcher(Method method, ArgumentsMatcher matcher) {
        getLegacyMatcherProvider().setMatcher(method, matcher);
    }
}
