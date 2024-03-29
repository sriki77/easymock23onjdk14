/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIObject License.
 */
package org.easymock;

/**
 * Controls all the mock objects created by it.
 * For details, see the EasyMock documentation.
 */
public interface IMocksControl extends IExpectationSetters {
    /**
     * Creates a mock object that implements the given interface.
     * @param toMock the class of the interface that the mock object should implement.
     * @return the mock object.
     */
     Object createMock(Class toMock);

    /**
     * Creates a mock object that implements the given interface.
     * @param name the name of the mock object .
     * @param toMock the class of the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException if the name is not a valid Java identifier.
     */
     Object createMock(String name, Class toMock);

    /**
     * Removes all expectations for the mock objects of this control.
     */
    void reset();

    /**
     * Switches the control from record mode to replay mode.
     */
    void replay();

    /**
     * Verifies that all expectations were met. 
     */
    void verify();

    /**
     * Switches order checking on and off.
     * @param state <code>true</code> switches order checking on, <code>false</code> switches it off.
     */
    void checkOrder(boolean state);
}
