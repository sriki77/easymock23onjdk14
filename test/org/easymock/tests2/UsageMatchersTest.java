/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests2;

import junit.framework.TestCase;
import org.easymock.EasyMock;

import org.easymock.jdk14.EasyMockTestCase;
import org.easymock.jdk14.IMethods;

public class UsageMatchersTest extends EasyMockTestCase {
    public void testAdditionalMatchersFailAtReplay() {

        try {
            IMethods mock = (IMethods) createMock(IMethods.class);
            lt(5);
            replay(mock);
            fail("Should Throw Exception");    
        } catch (IllegalStateException e) {
            
        }
    }

}
