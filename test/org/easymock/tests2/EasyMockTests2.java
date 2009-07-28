package org.easymock.tests2;

import junit.framework.Test;
import junit.framework.TestSuite;

public class EasyMockTests2 {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for org.easymock.tests2");
        //$JUnit-BEGIN$
        suite.addTestSuite(NiceMockTest.class);
        suite.addTestSuite(NameTest.class);
        suite.addTestSuite(ConstraintsToStringTest.class);
        suite.addTestSuite(AnswerTest.class);
        suite.addTestSuite(CallbackAndArgumentsTest.class);
        suite.addTestSuite(StubTest.class);
        suite.addTestSuite(CompareToTest.class);
        suite.addTestSuite(UsageStrictMockTest.class);
        suite.addTestSuite(UsageConstraintsTest.class);
        suite.addTestSuite(UsageTest.class);
        suite.addTestSuite(UsageMatchersTest.class);
        suite.addTestSuite(CallbackTest.class);
        //$JUnit-END$
        return suite;
    }

}
