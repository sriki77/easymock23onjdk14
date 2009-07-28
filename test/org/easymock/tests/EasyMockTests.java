package org.easymock.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class EasyMockTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for org.easymock.tests");
        //$JUnit-BEGIN$
        suite.addTestSuite(RecordStateInvalidThrowableTest.class);
        suite.addTestSuite(UsageThrowableTest.class);
        suite.addTestSuite(RecordStateInvalidDefaultThrowableTest.class);
        suite.addTestSuite(ArgumentsMatcherTest.class);
        suite.addTestSuite(InvocationTest.class);
        suite.addTestSuite(RecordStateInvalidStateChangeTest.class);
        suite.addTestSuite(NiceMockControlLongCompatibleReturnValueTest.class);
        suite.addTestSuite(UsageCallCountTest.class);
        suite.addTestSuite(ArrayMatcherTest.class);
        suite.addTestSuite(UsageLongCompatibleReturnValueTest.class);
        suite.addTestSuite(UsageVarargTest.class);
        suite.addTestSuite(ReplayStateInvalidUsageTest.class);
        suite.addTestSuite(UsageExpectAndThrowTest.class);
        suite.addTestSuite(UsageVerifyTest.class);
        suite.addTestSuite(UsageDefaultReturnValueTest.class);
        suite.addTestSuite(MatchableArgumentsTest.class);
        suite.addTestSuite(EqualsMatcherTest.class);
        suite.addTestSuite(MockNameTest.class);
        suite.addTestSuite(UsageExpectAndDefaultReturnTest.class);
        suite.addTestSuite(UsageRangeTest.class);
        suite.addTestSuite(RecordStateInvalidMatcherTest.class);
        suite.addTestSuite(ExpectedMethodCallTest.class);
        suite.addTestSuite(RecordStateMethodCallMissingTest.class);
        suite.addTestSuite(UsageUnorderedTest.class);
        suite.addTestSuite(LegacyBehaviorTests.class);
        suite.addTestSuite(UsageOverloadedMethodTest.class);
        suite.addTestSuite(RecordStateInvalidUsageTest.class);
        suite.addTestSuite(UsageExpectAndDefaultThrowTest.class);
        suite.addTestSuite(StacktraceTest.class);
        suite.addTestSuite(ObjectMethodsTest.class);
        suite.addTestSuite(RecordStateInvalidRangeTest.class);
        suite.addTestSuite(UsageFloatingPointReturnValueTest.class);
        suite.addTestSuite(ReplayStateInvalidCallsTest.class);
        suite.addTestSuite(UsageOverloadedDefaultValueTest.class);
        suite.addTestSuite(RecordStateInvalidReturnValueTest.class);
        suite.addTestSuite(NiceMockControlTest.class);
        suite.addTestSuite(UsageStrictMockTest.class);
        suite.addTestSuite(UsageExpectAndReturnTest.class);
        suite.addTestSuite(DefaultMatcherTest.class);
        suite.addTestSuite(RecordStateInvalidDefaultReturnValueTest.class);
        suite.addTestSuite(UsageTest.class);
        //$JUnit-END$
        return suite;
    }

}
