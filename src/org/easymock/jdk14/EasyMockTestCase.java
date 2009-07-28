package org.easymock.jdk14;

import java.util.Comparator;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;
import org.easymock.IMocksControl;
import org.easymock.LogicalOperator;

/**
 * A junit test case that provides all the easy mock methods. This class
 * compensates for the lack of static imports in JDK 1.4.
 * <p>
 * A test case can extend this class and use the Easymock methods without any
 * imports. The methods in this class are delegates to the actual EasyMock
 * class.
 * 
 * @author Srikanth
 * @see org.easymock.EasyMock
 */
public abstract class EasyMockTestCase extends TestCase {

    /**
     * Expects a boolean that matches both given expectations.
     * 
     * @param first
     *            placeholder for the firsObject expectation.
     * @param second
     *            placeholder for the second expectation.
     * @return <code>false</code>.
     */
    public boolean and(final boolean first, final boolean second) {
        return EasyMock.and(first, second);
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
    public byte and(final byte first, final byte second) {
        return EasyMock.and(first, second);
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
    public char and(final char first, final char second) {
        return EasyMock.and(first, second);
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
    public double and(final double first, final double second) {
        return EasyMock.and(first, second);
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
    public float and(final float first, final float second) {
        return EasyMock.and(first, second);
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
    public int and(final int first, final int second) {
        return EasyMock.and(first, second);
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
    public long and(final long first, final long second) {
        return EasyMock.and(first, second);
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
    public Object and(final Object first, final Object second) {
        return EasyMock.and(first, second);
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
    public short and(final short first, final short second) {
        return EasyMock.and(first, second);
    }

    /**
     * Expects any boolean argument. For details, see the EasyMock
     * documentation.
     * 
     * @return <code>false</code>.
     */
    public boolean anyBoolean() {
        return EasyMock.anyBoolean();
    }

    /**
     * Expects any byte argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public byte anyByte() {
        return EasyMock.anyByte();
    }

    /**
     * Expects any char argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public char anyChar() {
        return EasyMock.anyChar();
    }

    /**
     * Expects any double argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public double anyDouble() {
        return EasyMock.anyDouble();
    }

    /**
     * Expects any float argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public float anyFloat() {
        return EasyMock.anyFloat();
    }

    /**
     * Expects any int argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public int anyInt() {
        return EasyMock.anyInt();
    }

    /**
     * Expects any long argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public long anyLong() {
        return EasyMock.anyLong();
    }

    /**
     * Expects any Object argument. For details, see the EasyMock documentation.
     * 
     * @return <code>null</code>.
     */
    public Object anyObject() {
        return EasyMock.anyObject();
    }

    /**
     * Expects any short argument. For details, see the EasyMock documentation.
     * 
     * @return <code>0</code>.
     */
    public short anyShort() {
        return EasyMock.anyShort();
    }

    /**
     * Expects a boolean array that is equal to the given array, i.e. iObject
     * has to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public boolean[] aryEq(final boolean[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a byte array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public byte[] aryEq(final byte[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a char array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public char[] aryEq(final char[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a double array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public double[] aryEq(final double[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a float array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public float[] aryEq(final float[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects an int array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public int[] aryEq(final int[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a long array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public long[] aryEq(final long[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects an Object array that is equal to the given array, i.e. iObject
     * has to have the same type, length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public Object[] aryEq(final Object[] value) {
        return EasyMock.aryEq(value);
    }

    /**
     * Expects a short array that is equal to the given array, i.e. iObject has
     * to have the same length, and each elemenObject has to be equal.
     * 
     * @param value
     *            the given arry.
     * @return <code>null</code>.
     */
    public short[] aryEq(final short[] value) {
        return EasyMock.aryEq(value);
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
    public void checkOrder(final Object mock, final boolean state) {
        EasyMock.checkOrder(mock, state);
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
    public Object cmp(final Object value, final Comparator comparator, final LogicalOperator operator) {
        return EasyMock.cmp(value, comparator, operator);
    }

    /**
     * Expects a comparable argument equals to the given value according to
     * their compareTo method. For details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Comparable cmpEq(final Comparable value) {
        return EasyMock.cmpEq(value);
    }

    /**
     * Expects a string that contains the given substring. For details, see the
     * EasyMock documentation.
     * 
     * @param substring
     *            the substring.
     * @return <code>null</code>.
     */
    public String contains(final String substring) {
        return EasyMock.contains(substring);
    }

    /**
     * Creates a control, order checking is disabled by default.
     * 
     * @return the control.
     */
    public IMocksControl createControl() {
        return EasyMock.createControl();
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
    public Object createMock(final Class toMock) {
        return EasyMock.createMock(toMock);
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
     * 
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is noObject a valid Java identifier.
     */
    public Object createMock(final String name, final Class toMock) {
        return EasyMock.createMock(name, toMock);
    }

    /**
     * Creates a control, order checking is disabled by default, and the mock
     * objects created by this control will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @return the control.
     */
    public IMocksControl createNiceControl() {
        return EasyMock.createNiceControl();
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
    public Object createNiceMock(final Class toMock) {
        return EasyMock.createNiceMock(toMock);
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
    public Object createNiceMock(final String name, final Class toMock) {
        return EasyMock.createNiceMock(name, toMock);
    }

    /**
     * Creates a control, order checking is enabled by default.
     * 
     * @return the control.
     */
    public IMocksControl createStrictControl() {
        return EasyMock.createStrictControl();
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is enabled by default.
     * 
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public Object createStrictMock(final Class toMock) {
        return EasyMock.createStrictMock(toMock);
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
     * 
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is noObject a valid Java identifier.
     */
    public Object createStrictMock(final String name, final Class toMock) {
        return EasyMock.createStrictMock(name, toMock);
    }

    /**
     * Expects a string that ends with the given suffix. For details, see the
     * EasyMock documentation.
     * 
     * @param suffix
     *            the suffix.
     * @return <code>null</code>.
     */
    public String endsWith(final String suffix) {
        return EasyMock.endsWith(suffix);
    }

    /**
     * Expects a boolean that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public boolean eq(final boolean value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects a byte that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public byte eq(final byte value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects a char that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public char eq(final char value) {
        return EasyMock.eq(value);
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
    public double eq(final double value, final double delta) {
        return EasyMock.eq(value, delta);
    }

    /**
     * Expects a double that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public double eq(final double value) {
        return EasyMock.eq(value);
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
    public float eq(final float value, final float delta) {
        return EasyMock.eq(value, delta);
    }

    /**
     * Expects a float that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public float eq(final float value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects an int that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public int eq(final int value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects a long that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public long eq(final long value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects an Object that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Object eq(final Object value) {
        return EasyMock.eq(value);
    }

    /**
     * Expects a short that is equal to the given value.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public short eq(final short value) {
        return EasyMock.eq(value);
    }

    public IExpectationSetters expect(final boolean value) {
        return EasyMock.expect(value);
    }

    public IExpectationSetters expect(final double value) {
        return EasyMock.expect(value);
    }

    public IExpectationSetters expect(final float value) {
        return EasyMock.expect(value);
    }

    public IExpectationSetters expect(final long value) {
        return EasyMock.expect(value);
    }

    public IExpectationSetters expect(final Object value) {
        return EasyMock.expect(value);
    }

    /**
     * Returns the expectation setter for the lasObject expected invocation in
     * the currenObject thread. This method is used for expected invocations on
     * void methods.
     * 
     * @return the expectation setter.
     */
    public IExpectationSetters expectLastCall() {
        return EasyMock.expectLastCall();
    }

    /**
     * Expects a string that contains a substring that matches the given regular
     * expression. For details, see the EasyMock documentation.
     * 
     * @param regex
     *            the regular expression.
     * @return <code>null</code>.
     */
    public String find(final String regex) {
        return EasyMock.find(regex);
    }

    /**
     * Expects a byte argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public byte geq(final byte value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects a comparable argument greater than or equal the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Comparable geq(final Comparable value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects a double argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public double geq(final double value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects a float argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public float geq(final float value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects an int argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public int geq(final int value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects a long argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public long geq(final long value) {
        return EasyMock.geq(value);
    }

    /**
     * Expects a short argument greater than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public short geq(final short value) {
        return EasyMock.geq(value);
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
    public Object[] getCurrentArguments() {
        return EasyMock.getCurrentArguments();
    }

    /**
     * Expects a byte argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public byte gt(final byte value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects a comparable argument greater than the given value. For details,
     * see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Comparable gt(final Comparable value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects a double argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public double gt(final double value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects a float argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public float gt(final float value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects an int argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public int gt(final int value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects a long argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public long gt(final long value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects a short argument greater than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public short gt(final short value) {
        return EasyMock.gt(value);
    }

    /**
     * Expects an object implementing the given class. For details, see the
     * EasyMock documentation.
     * 
     * @param clazz
     *            the class of the accepted type.
     * @return <code>null</code>.
     */
    public Object isA(final Class clazz) {
        return EasyMock.isA(clazz);
    }

    /**
     * Expects null.
     * 
     * @return <code>null</code>.
     */
    public Object isNull() {
        return EasyMock.isNull();
    }

    /**
     * Expects a byte argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public byte leq(final byte value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a comparable argument less than or equal the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Comparable leq(final Comparable value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a double argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public double leq(final double value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a float argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public float leq(final float value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects an int argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public int leq(final int value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a long argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public long leq(final long value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a short argument less than or equal to the given value. For
     * details, see the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public short leq(final short value) {
        return EasyMock.leq(value);
    }

    /**
     * Expects a byte argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public byte lt(final byte value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a comparable argument less than the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Comparable lt(final Comparable value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a double argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public double lt(final double value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a float argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public float lt(final float value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects an int argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public int lt(final int value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a long argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public long lt(final long value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a short argument less than the given value. For details, see the
     * EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>0</code>.
     */
    public short lt(final short value) {
        return EasyMock.lt(value);
    }

    /**
     * Expects a string that matches the given regular expression. For details,
     * see the EasyMock documentation.
     * 
     * @param regex
     *            the regular expression.
     * @return <code>null</code>.
     */
    public String matches(final String regex) {
        return EasyMock.matches(regex);
    }

    /**
     * Expects a boolean that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>false</code>.
     */
    public boolean not(final boolean first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a byte that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public byte not(final byte first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a char that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public char not(final char first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a double that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public double not(final double first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a float that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public float not(final float first) {
        return EasyMock.not(first);
    }

    /**
     * Expects an int that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public int not(final int first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a long that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public long not(final long first) {
        return EasyMock.not(first);
    }

    /**
     * Expects an Object that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>null</code>.
     */
    public Object not(final Object first) {
        return EasyMock.not(first);
    }

    /**
     * Expects a short that does noObject match the given expectation.
     * 
     * @param first
     *            placeholder for the expectation.
     * @return <code>0</code>.
     */
    public short not(final short first) {
        return EasyMock.not(first);
    }

    /**
     * Expects noObject null.
     * 
     * @return <code>null</code>.
     */
    public Object notNull() {
        return EasyMock.notNull();
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
    public boolean or(final boolean first, final boolean second) {
        return EasyMock.or(first, second);
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
    public byte or(final byte first, final byte second) {
        return EasyMock.or(first, second);
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
    public char or(final char first, final char second) {
        return EasyMock.or(first, second);
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
    public double or(final double first, final double second) {
        return EasyMock.or(first, second);
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
    public float or(final float first, final float second) {
        return EasyMock.or(first, second);
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
    public int or(final int first, final int second) {
        return EasyMock.or(first, second);
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
    public long or(final long first, final long second) {
        return EasyMock.or(first, second);
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
    public Object or(final Object first, final Object second) {
        return EasyMock.or(first, second);
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
    public short or(final short first, final short second) {
        return EasyMock.or(first, second);
    }

    public void replay(final IMethods mock, final IMethods mock2, final IMethods mock3) {
        EasyMock.replay(mock, mock2, mock3);
    }

    public void replay(final IMethods mock, final IMethods mock2) {
        EasyMock.replay(mock, mock2);
    }

    public void replay(final IMethods mock) {
        EasyMock.replay(mock);
    }

    /**
     * Switches the given mock objects (more exactly: the controls of the mock
     * objects) to replay mode. For details, see the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects.
     */
    public void replay(final Object[] mocks) {
        EasyMock.replay(mocks);
    }

    /**
     * Reports an argument matcher. This method is needed to define own argument
     * matchers. For details, see the EasyMock documentation.
     * 
     * @param matcher
     */
    public void reportMatcher(final IArgumentMatcher matcher) {
        EasyMock.reportMatcher(matcher);
    }

    public void reset(final IMethods mock, final IMethods mock2, final IMethods mock3) {
        EasyMock.reset(mock, mock2, mock3);
    }

    public void reset(final IMethods mock, final IMethods mock2) {
        EasyMock.reset(mock, mock2);
    }

    public void reset(final IMethods mock) {
        EasyMock.reset(mock);
    }

    /**
     * Resets the given mock objects (more exactly: the controls of the mock
     * objects). For details, see the EasyMock documentation.
     * 
     * @param mocks
     *            the mock objects.
     */
    public void reset(final Object[] mocks) {
        EasyMock.reset(mocks);
    }

    /**
     * Expects an Object that is the same as the given value. For details, see
     * the EasyMock documentation.
     * 
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    public Object same(final Object value) {
        return EasyMock.same(value);
    }

    /**
     * Expects a string that starts with the given prefix. For details, see the
     * EasyMock documentation.
     * 
     * @param prefix
     *            the prefix.
     * @return <code>null</code>.
     */
    public String startsWith(final String prefix) {
        return EasyMock.startsWith(prefix);
    }

    public void verify(final IMethods mock, final IMethods mock2, final IMethods mock3) {
        EasyMock.verify(mock, mock2, mock3);
    }

    public void verify(final IMethods mock, final IMethods mock2) {
        EasyMock.verify(mock, mock2);
    }

    public void verify(final IMethods mock) {
        EasyMock.verify(mock);
    }

    /**
     * Verifies the given mock objects (more exactly: the controls of the mock
     * objects).
     * 
     * @param mocks
     *            the mock objects.
     */
    public void verify(final Object[] mocks) {
        EasyMock.verify(mocks);
    }
    
    
    
    

}
