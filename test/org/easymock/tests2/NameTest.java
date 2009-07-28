package org.easymock.tests2;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class NameTest extends EasyMockTestCase {
    public void testNameForMock() {
        IMethods mock = (IMethods) createMock("mock", IMethods.class);
        mock.simpleMethod();
        replay(mock);
        try {
            verify(mock);
        } catch (AssertionError expected) {
            String actualMessage = expected.getMessage();
            String expectedMessage = "\n  Expectation failure on verify:\n    mock.simpleMethod(): expected: 1, actual: 0";
            assertEquals(expectedMessage, actualMessage);         
        }
    }
    public void testNameForStrictMock() {
        IMethods mock = (IMethods) createStrictMock("mock", IMethods.class);
        mock.simpleMethod();
        replay(mock);
        try {
            verify(mock);
        } catch (AssertionError expected) {
            String actualMessage = expected.getMessage();
            String expectedMessage = "\n  Expectation failure on verify:\n    mock.simpleMethod(): expected: 1, actual: 0";
            assertEquals(expectedMessage, actualMessage);         
        }
    }
    public void testNameForNiceMock() {
        IMethods mock = (IMethods) createNiceMock("mock", IMethods.class);
        mock.simpleMethod();
        replay(mock);
        try {
            verify(mock);
        } catch (AssertionError expected) {
            String actualMessage = expected.getMessage();
            String expectedMessage = "\n  Expectation failure on verify:\n    mock.simpleMethod(): expected: 1, actual: 0";
            assertEquals(expectedMessage, actualMessage);         
        }
    }
  
    public void testNameForMocksControl() {
        IMocksControl control = createControl();
        IMethods mock = (IMethods) control.createMock("mock", IMethods.class);
        mock.simpleMethod();
        replay(mock);
        try {
            verify(mock);
        } catch (AssertionError expected) {
            String actualMessage = expected.getMessage();
            String expectedMessage = "\n  Expectation failure on verify:\n    mock.simpleMethod(): expected: 1, actual: 0";
            assertEquals(expectedMessage, actualMessage);         
        }
    }
    
    public void testShouldThrowIllegalArgumentExceptionIfNameIsNoValidJavaIdentifier() {
        try {
            createMock("no-valid-java-identifier", IMethods.class);
            throw new AssertionError();
        } catch (IllegalArgumentException expected) {
            assertEquals("'no-valid-java-identifier' is not a valid Java identifier.", expected.getMessage());
        }
    }

}
