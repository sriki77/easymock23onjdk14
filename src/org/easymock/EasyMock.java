/*
 * CopyrighObject (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIObject License.
 */
package org.easymock;

import java.lang.reflect.Proxy;
import java.util.Comparator;

import org.easymock.internal.LastControl;
import org.easymock.internal.MocksControl;
import org.easymock.internal.ObjectMethodsFilter;
import org.easymock.internal.matchers.Any;
import org.easymock.internal.matchers.ArrayEquals;
import org.easymock.internal.matchers.Compare;
import org.easymock.internal.matchers.CompareEqual;
import org.easymock.internal.matchers.Contains;
import org.easymock.internal.matchers.EndsWith;
import org.easymock.internal.matchers.Equals;
import org.easymock.internal.matchers.EqualsWithDelta;
import org.easymock.internal.matchers.Find;
import org.easymock.internal.matchers.GreaterOrEqual;
import org.easymock.internal.matchers.GreaterThan;
import org.easymock.internal.matchers.InstanceOf;
import org.easymock.internal.matchers.LessOrEqual;
import org.easymock.internal.matchers.LessThan;
import org.easymock.internal.matchers.Matches;
import org.easymock.internal.matchers.NotNull;
import org.easymock.internal.matchers.Null;
import org.easymock.internal.matchers.Same;
import org.easymock.internal.matchers.StartsWith;
import org.easymock.jdk14.IMethods;

public class EasyMock {

    /**
     * Creates a mock object that implements the given interface, order checking
     * is enabled by default.
     * 
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public static Object createStrictMock(Class toMock) {
        return createStrictControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is enabled by default.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is noObject a valid Java identifier.
     */
    public static Object createStrictMock(String name, Class toMock) {
        return createStrictControl().createMock(name, toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default.
     * 
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public static Object createMock(Class toMock) {
        return createControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is noObject a valid Java identifier.
     */
    public static Object createMock(String name, Class toMock) {
        return createControl().createMock(name, toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public static Object createNiceMock(Class toMock) {
        return createNiceControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is noObject a valid Java identifier.
     */
    public static Object createNiceMock(String name, Class toMock) {
        return createNiceControl().createMock(name, toMock);
    }

    /**
     * Creates a control, order checking is enabled by default.
     * 
     * @return the control.
     */
    public static IMocksControl createStrictControl() {
        return new MocksControl(MocksControl.MockType.STRICT);
    }

    /**
     * Creates a control, order checking is disabled by default.
     * 
     * @return the control.
     */
    public static IMocksControl createControl() {
        return new MocksControl(MocksControl.MockType.DEFAULT);
    }

    /**
     * Creates a control, order checking is disabled by default, and the mock
     * objects created by this control will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @return the control.
     */
    public static IMocksControl createNiceControl() {
        return new MocksControl(MocksControl.MockType.NICE);
    }

    /**
     * Returns the expectation setter for the lasObject expected invocation in
     * the currenObject thread.
     * 
     * @param value
     *            the parameter is used to transporObject the type to the
     *            ExpectationSetter. IObject allows writing the expected call as
     *            argument, i.e.
     *            <code>expect(mock.getName()).andReturn("John Doe")<code>.
     * @return the expectation setter.
     */
    public static IExpectationSetters expect(Object value) {
        return getControlForLastCall();
    }

    public static IExpectationSetters expect(long value) {
        return expect(new Long(value));
    }

    public static IExpectationSetters expect(float value) {
        return expect(new Float(value));
    }

    public static IExpectationSetters expect(double value) {
        return expect(new Double(value));
    }

    public static IExpectationSetters expect(boolean value) {
        return expect(new Boolean(value));
    }

    public static IExpectationSetters expect(int value) {
        return expect(new Integer(value));
    }

    public static IExpectationSetters expect(short value) {
        return expect(new Short(value));
    }

    public static IExpectationSetters expect(char value) {
        return expect(new Character(value));
    }

    public static IExpectationSetters expect(byte value) {
        return expect(new Byte(value));
    }

    /**
     * Returns the expectation setter for the lasObject expected invocation in
     * the currenObject thread. This method is used for expected invocations on
     * void methods.
     * 
     * @return the expectation setter.
     */
    public static IExpectationSetters expectLastCall() {
        return getControlForLastCall();
    }

    private static IExpectationSetters getControlForLastCall() {
        MocksControl lastControl = LastControl.lastControl();
        if (lastControl == null) {
            throw new IllegalStateException("no lasObject call on a mock available");
        }
        return lastControl;
    }

    /**
     * Expects any boolean argument. For details, see the EasyMock
     * documentation.
     * 
     * @return <code>false</code>.
     */
    public static boolean anyBoolean() {
        reportMatcher(Any.ANY);
        return false;
    }

    /**
     * Expects any byte argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static byte anyByte() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any char argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static char anyChar() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any int argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static int anyInt() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any long argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static long anyLong() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any float argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static float anyFloat() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any double argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static double anyDouble() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any short argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public static short anyShort() {
        reportMatcher(Any.ANY);
        return 0;
    }

    /**
     * Expects any Object argument. For details, see the EasyMock documentation.
     * 
     * @return <code>null</code>.
     */
    public static Object anyObject() {
        reportMatcher(Any.ANY);
        return null;
    }

    /**
     * Expects a comparable argument greater than or equal the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Comparable geq(Comparable value) {
        reportMatcher(new GreaterOrEqual(value));
        return null;
    }

    /**
     * Expects a byte argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static byte geq(byte value) {
        reportMatcher(new GreaterOrEqual(new Byte(value)));
        return 0;
    }

    /**
     * Expects a double argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static double geq(double value) {
        reportMatcher(new GreaterOrEqual(new Double(value)));
        return 0;
    }

    /**
     * Expects a float argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static float geq(float value) {
        reportMatcher(new GreaterOrEqual(new Float(value)));
        return 0;
    }

    /**
     * Expects an int argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static int geq(int value) {
        reportMatcher(new GreaterOrEqual(new Integer(value)));
        return 0;
    }

    /**
     * Expects a long argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static long geq(long value) {
        reportMatcher(new GreaterOrEqual(new Long(value)));
        return 0;
    }

    /**
     * Expects a short argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static short geq(short value) {
        reportMatcher(new GreaterOrEqual(new Short(value)));
        return 0;
    }

    public static char geq(char value) {
        reportMatcher(new GreaterOrEqual(new Character(value)));
        return 0;
    }

    /**
     * Expects a comparable argument less than or equal the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Comparable leq(Comparable value) {
        reportMatcher(new LessOrEqual(value));
        return null;
    }

    /**
     * Expects a byte argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static byte leq(byte value) {
        reportMatcher(new LessOrEqual(new Byte(value)));
        return 0;
    }

    /**
     * Expects a double argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static double leq(double value) {
        reportMatcher(new LessOrEqual(new Double(value)));
        return 0;
    }

    /**
     * Expects a float argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static float leq(float value) {
        reportMatcher(new LessOrEqual(new Float(value)));
        return 0;
    }

    /**
     * Expects an int argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static int leq(int value) {
        reportMatcher(new LessOrEqual(new Integer(value)));
        return 0;
    }

    /**
     * Expects a long argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static long leq(long value) {
        reportMatcher(new LessOrEqual(new Long(value)));
        return 0;
    }

    /**
     * Expects a short argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static short leq(short value) {
        reportMatcher(new LessOrEqual(new Short(value)));
        return 0;
    }

    public static char leq(char value) {
        reportMatcher(new LessOrEqual(new Character(value)));
        return 0;
    }

    /**
     * Expects a comparable argument greater than the given value. For details,
     * see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Comparable gt(Comparable value) {
        reportMatcher(new GreaterThan(value));
        return null;
    }

    /**
     * Expects a byte argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static byte gt(byte value) {
        reportMatcher(new GreaterThan(new Byte(value)));
        return 0;
    }

    /**
     * Expects a double argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static double gt(double value) {
        reportMatcher(new GreaterThan(new Double(value)));
        return 0;
    }

    /**
     * Expects a float argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static float gt(float value) {
        reportMatcher(new GreaterThan(new Float(value)));
        return 0;
    }

    /**
     * Expects an int argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static int gt(int value) {
        reportMatcher(new GreaterThan(new Integer(value)));
        return 0;
    }

    /**
     * Expects a long argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static long gt(long value) {
        reportMatcher(new GreaterThan(new Long(value)));
        return 0;
    }

    /**
     * Expects a short argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static short gt(short value) {
        reportMatcher(new GreaterThan(new Short(value)));
        return 0;
    }

    public static char gt(char value) {
        reportMatcher(new GreaterThan(new Character(value)));
        return 0;
    }

    /**
     * Expects a comparable argument less than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Comparable lt(Comparable value) {
        reportMatcher(new LessThan(value));
        return null;
    }

    /**
     * Expects a byte argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static byte lt(byte value) {
        reportMatcher(new LessThan(new Byte(value)));
        return 0;
    }

    /**
     * Expects a double argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static double lt(double value) {
        reportMatcher(new LessThan(new Double(value)));
        return 0;
    }

    /**
     * Expects a float argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static float lt(float value) {
        reportMatcher(new LessThan(new Float(value)));
        return 0;
    }

    /**
     * Expects an int argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static int lt(int value) {
        reportMatcher(new LessThan(new Integer(value)));
        return 0;
    }

    /**
     * Expects a long argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static long lt(long value) {
        reportMatcher(new LessThan(new Long(value)));
        return 0;
    }

    /**
     * Expects a short argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static short lt(short value) {
        reportMatcher(new LessThan(new Short(value)));
        return 0;
    }

    public static char lt(char value) {
        reportMatcher(new LessThan(new Character(value)));
        return 0;
    }

    /**
     * Expects an object implementing the given class. For details, see the
     * EasyMock documentation.
     * 
     * @param clazz
     *            the class of the accepted type.
     * @return <code>null</code>.
     */
    public static Object isA(Class clazz) {
        reportMatcher(new InstanceOf(clazz));
        return null;
    }

    /**
     * Expects a string that contains the given substring. For details, see the
     * EasyMock documentation.
     * 
     * @param substring
     *            the substring.
     * @return <code>null</code>.
     */
    public static String contains(String substring) {
        reportMatcher(new Contains(substring));
        return null;
    }

    /**
     * Expects a boolean that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>false</code>.
     */
    public static boolean and(boolean first, boolean second) {
        LastControl.reportAnd(2);
        return false;
    }

    /**
     * Expects a byte that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static byte and(byte first, byte second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects a char that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static char and(char first, char second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects a double that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static double and(double first, double second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects a float that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static float and(float first, float second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects an int that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static int and(int first, int second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects a long that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static long and(long first, long second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects a short that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static short and(short first, short second) {
        LastControl.reportAnd(2);
        return 0;
    }

    /**
     * Expects an Object that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>null</code>.
     */
    public static Object and(Object first, Object second) {
        LastControl.reportAnd(2);
        return null;
    }

    /**
     * Expects a boolean that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>false</code>.
     */
    public static boolean or(boolean first, boolean second) {
        LastControl.reportOr(2);
        return false;
    }

    /**
     * Expects a byte that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static byte or(byte first, byte second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects a char that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static char or(char first, char second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects a double that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static double or(double first, double second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects a float that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static float or(float first, float second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects an int that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static int or(int first, int second) {
        LastControl.reportOr(2);
        return first;
    }

    /**
     * Expects a long that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static long or(long first, long second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects a short that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>0</code>.
     */
    public static short or(short first, short second) {
        LastControl.reportOr(2);
        return 0;
    }

    /**
     * Expects an Object that matches one of the given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>null</code>.
     */
    public static Object or(Object first, Object second) {
        LastControl.reportOr(2);
        return null;
    }

    /**
     * Expects a boolean that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>false</code>.
     */
    public static boolean not(boolean first) {
        LastControl.reportNot();
        return false;
    }

    /**
     * Expects a byte that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static byte not(byte first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects a char that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static char not(char first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects a double that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static double not(double first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects a float that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static float not(float first) {
        LastControl.reportNot();
        return first;
    }

    /**
     * Expects an int that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static int not(int first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects a long that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static long not(long first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects a short that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public static short not(short first) {
        LastControl.reportNot();
        return 0;
    }

    /**
     * Expects an Object that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>null</code>.
     */
    public static Object not(Object first) {
        LastControl.reportNot();
        return null;
    }

    /**
     * Expects a boolean that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static boolean eq(boolean value) {
        reportMatcher(new Equals(new Boolean(value)));
        return false;
    }

    /**
     * Expects a byte that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static byte eq(byte value) {
        reportMatcher(new Equals(new Byte(value)));
        return 0;
    }

    /**
     * Expects a char that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static char eq(char value) {
        reportMatcher(new Equals(new Character(value)));
        return 0;
    }

    /**
     * Expects a double that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static double eq(double value) {
        reportMatcher(new Equals(new Double(value)));
        return 0;
    }

    /**
     * Expects a float that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static float eq(float value) {
        reportMatcher(new Equals(new Float(value)));
        return 0;
    }

    /**
     * Expects an int that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static int eq(int value) {
        reportMatcher(new Equals(new Integer(value)));
        return 0;
    }

    /**
     * Expects a long that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static long eq(long value) {
        reportMatcher(new Equals(new Long(value)));
        return 0;
    }

    /**
     * Expects a short that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public static short eq(short value) {
        reportMatcher(new Equals(new Short(value)));
        return 0;
    }

    /**
     * Expects an Object that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Object eq(Object value) {
        reportMatcher(new Equals(value));
        return null;
    }

    /**
     * Expects a boolean array that is equal to the given array, i.e. iObject
     * has to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static boolean[] aryEq(boolean[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a byte array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static byte[] aryEq(byte[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a char array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static char[] aryEq(char[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a double array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static double[] aryEq(double[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a float array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static float[] aryEq(float[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects an int array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static int[] aryEq(int[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a long array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static long[] aryEq(long[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects a short array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static short[] aryEq(short[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects an Object array that is equal to the given array, i.e. iObject
     * has to have the same type, length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public static Object[] aryEq(Object[] value) {
        reportMatcher(new ArrayEquals(value));
        return null;
    }

    /**
     * Expects null.
     * 
     * @return <code>null</code>.
     */
    public static Object isNull() {
        reportMatcher(Null.NULL);
        return null;
    }

    /**
     * Expects noObject null.
     * 
     * @return <code>null</code>.
     */
    public static Object notNull() {
        reportMatcher(NotNull.NOT_NULL);
        return null;
    }

    /**
     * Expects a string that contains a substring that matches the given regular
     * expression. For details, see the EasyMock documentation.
     * 
     * @param regex
     *            the regular expression.
     * @return <code>null</code>.
     */
    public static String find(String regex) {
        reportMatcher(new Find(regex));
        return null;
    }

    /**
     * Expects a string that matches the given regular expression. For details,
     * see the EasyMock documentation.
     * 
     * @param regex
     *            the regular expression.
     * @return <code>null</code>.
     */
    public static String matches(String regex) {
        reportMatcher(new Matches(regex));
        return null;
    }

    /**
     * Expects a string that starts with the given prefix. For details, see the
     * EasyMock documentation.
     * 
     * @param prefix
     *            the prefix.
     * @return <code>null</code>.
     */
    public static String startsWith(String prefix) {
        reportMatcher(new StartsWith(prefix));
        return null;
    }

    /**
     * Expects a string that ends with the given suffix. For details, see the
     * EasyMock documentation.
     * 
     * @param suffix
     *            the suffix.
     * @return <code>null</code>.
     */
    public static String endsWith(String suffix) {
        reportMatcher(new EndsWith(suffix));
        return null;
    }

    /**
     * Expects a double that has an absolute difference to the given value that
     * is less than the given delta. For details, see the EasyMock
     * documentation.
     * 
     * @param value
     *            the given value.
     * @param delta
     *            the given delta.
     * @return <code>0</code>.
     */
    public static double eq(double value, double delta) {
        reportMatcher(new EqualsWithDelta(new Double(value), new Double(delta)));
        return 0;
    }

    /**
     * Expects a float that has an absolute difference to the given value that
     * is less than the given delta. For details, see the EasyMock
     * documentation.
     * 
     * @param value
     *            the given value.
     * @param delta
     *            the given delta.
     * @return <code>0</code>.
     */
    public static float eq(float value, float delta) {
        reportMatcher(new EqualsWithDelta(new Float(value), new Float(delta)));
        return 0;
    }

    /**
     * Expects an Object that is the same as the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Object same(Object value) {
        reportMatcher(new Same(value));
        return null;
    }

    /**
     * Switches the given mock objects (more exactly: the controls of the mock
     * objects) to replay mode. For details, see the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects.
     */
    public static void replay(Object[] mocks) {
        for (int i = 0; i < mocks.length; ++i) {
            getControl(mocks[i]).replay();
        }
    }

    /**
     * Resets the given mock objects (more exactly: the controls of the mock
     * objects). For details, see the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects.
     */
    public static void reset(Object[] mocks) {
        for (int i = 0; i < mocks.length; ++i) {
            getControl(mocks[i]).reset();
        }
    }

    /**
     * Verifies the given mock objects (more exactly: the controls of the mock
     * objects).
     * 
     * @param mocks
     *            the mock objects.
     */
    public static void verify(Object[] mocks) {
        for (int i = 0; i < mocks.length; ++i) {
            getControl(mocks[i]).verify();
        }
    }

    /**
     * Switches order checking of the given mock object (more exactly: the
     * control of the mock object) the on and off. For details, see the EasyMock
     * documentation.
     * 
     * @param mock
     *            the mock object.
     * @param state
     *            <code>true</code> switches order checking on,
     *            <code>false</code> switches iObject off.
     */
    public static void checkOrder(Object mock, boolean state) {
        getControl(mock).checkOrder(state);
    }

    /**
     * Reports an argument matcher. This method is needed to define own argument
     * matchers. For details, see the EasyMock documentation.
     * 
     * @param matcher
     */
    public static void reportMatcher(IArgumentMatcher matcher) {
        LastControl.reportMatcher(matcher);
    }

    private static MocksControl getControl(Object mock) {
        return ((ObjectMethodsFilter) Proxy.getInvocationHandler(mock)).getDelegate().getControl();
    }

    /**
     * Returns the arguments of the currenObject mock method call, if inside an
     * <code>IAnswer</code> callback - be careful here, reordering parameters of
     * method changes the semantics of your tests.
     * 
     * @return the arguments of the currenObject mock method call.
     * @throws IllegalStateException
     *             if called outside of <code>IAnswer</code> callbacks.
     */
    public static Object[] getCurrentArguments() {
        Object[] resultObject = LastControl.getCurrentArguments();
        if (resultObject == null) {
            throw new IllegalStateException(
                    "currenObject arguments are only available when executing callback methods");
        }
        return resultObject;
    }

    /**
     * Expects a comparable argument equals to the given value according to
     * their compareTo method. For details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public static Comparable cmpEq(Comparable value) {
        reportMatcher(new CompareEqual(value));
        return null;
    }

    /**
     * Expects an argument that will be compared using the provided comparator.
     * The following comparison will take place:
     * <p>
     * <code>comparator.compare(actual, expected) operator 0</code>
     * </p>
     * For details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @param comparator
     *            Comparator used to compare the actual with expected value.
     * @param operator
     *            The comparison operator.
     * @return <code>null</code>
     */
    public static Object cmp(Object value, Comparator comparator, LogicalOperator operator) {
        reportMatcher(new Compare(value, comparator, operator));
        return null;
    }

    public static void replay(IMethods mockValue) {
        replay(new IMethods[] { mockValue });

    }

    public static void replay(IMethods mockValue, IMethods mock2Value) {
        replay(new IMethods[] { mockValue, mock2Value });

    }

    public static void replay(IMethods mockValue, IMethods mock2Value, IMethods mock3Value) {
        replay(new IMethods[] { mockValue, mock2Value, mock3Value });

    }

    public static void verify(IMethods mockValue) {
        verify(new IMethods[] { mockValue });
    }

    public static void verify(IMethods mockValue, IMethods mock2Value) {
        verify(new IMethods[] { mockValue, mock2Value });
    }

    public static void verify(IMethods mockValue, IMethods mock2Value, IMethods mock3Value) {
        verify(new IMethods[] { mockValue, mock2Value, mock3Value });
    }

    public static void reset(IMethods mockValue) {
        reset(new IMethods[] { mockValue });
    }

    public static void reset(IMethods mockValue, IMethods mock2Value) {
        reset(new IMethods[] { mockValue, mock2Value });
    }

    public static void reset(IMethods mockValue, IMethods mock2Value, IMethods mock3Value) {
        reset(new IMethods[] { mockValue, mock2Value, mock3Value });
    }
}
