#Readme page for the project

# Introduction #

EasyMock 2.3 works only on Java 5 and above.
This project removes all the Java 5 features from the code
and the entire code is compiled using J2SE 1.4.

This port makes the features of EasyMock 2.3  available
for use in projects running on J2SE 1.4.


# Usage #

  1. Put `easymock23_jdk14.jar` in the CLASSPATH.
  1. Extend `org.easymock.jdk14.EasyMockTestCase` - this is a JUnit 3 test case that makes the easy mock methods available to the tests.