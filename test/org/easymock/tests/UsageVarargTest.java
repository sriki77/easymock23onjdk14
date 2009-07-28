/*
 * Copyright (c) 2001-2007 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.tests;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import junit.framework.TestCase;

import org.easymock.MockControl;

public class UsageVarargTest extends TestCase {

    MockControl control;

    IVarArgs mock;

    public void setUp() {
        control = MockControl.createStrictControl(IVarArgs.class);
        mock =  (IVarArgs) control.getMock();
    }

    public void testVarargObjectAccepted() {
//        mock.withVarargsString(1, "1");
//        mock.withVarargsString(2, "1", "2");
//        mock.withVarargsString(2, "1", "2");
//        mock.withVarargsObject(3, "1");
//        mock.withVarargsObject(4, "1", "2");
//
//        control.replay();
//        mock.withVarargsString(1, "1");
//        mock.withVarargsString(2, "1", "2");
//        mock.withVarargsString(2, "1", "2");
//        mock.withVarargsObject(3, "1");
//        mock.withVarargsObject(4, "1", "2");
//        control.verify();
    }

//    public void testVarargBooleanAccepted() {
//        mock.withVarargsBoolean(1, true);
//        mock.withVarargsBoolean(2, true, false);
//
//        control.replay();
//        mock.withVarargsBoolean(1, true);
//        mock.withVarargsBoolean(2, true, false);
//        control.verify();
//    }
//
//    public void testVarargByteAccepted() {
//        mock.withVarargsByte(1, (byte) 1);
//        mock.withVarargsByte(2, (byte) 1, (byte) 2);
//
//        control.replay();
//        mock.withVarargsByte(1, (byte) 1);
//        mock.withVarargsByte(2, (byte) 1, (byte) 2);
//        control.verify();
//    }
//
//    public void testVarargCharAccepted() {
//        mock.withVarargsChar(1, 'a');
//        mock.withVarargsChar(1, 'a', 'b');
//
//        control.replay();
//        mock.withVarargsChar(1, 'a');
//        mock.withVarargsChar(1, 'a', 'b');
//        control.verify();
//    }
//
//    public void testVarargDoubleAccepted() {
//        mock.withVarargsDouble(1, 1.0d);
//        mock.withVarargsDouble(1, 1.0d, 2.0d);
//
//        control.replay();
//        mock.withVarargsDouble(1, 1.0d);
//        mock.withVarargsDouble(1, 1.0d, 2.0d);
//        control.verify();
//    }
//
//    public void testVarargFloatAccepted() {
//        mock.withVarargsFloat(1, 1.0f);
//        mock.withVarargsFloat(1, 1.0f, 2.0f);
//
//        control.replay();
//        mock.withVarargsFloat(1, 1.0f);
//        mock.withVarargsFloat(1, 1.0f, 2.0f);
//        control.verify();
//    }
//
//    public void testVarargIntAccepted() {
//        mock.withVarargsInt(1, 1);
//        mock.withVarargsInt(1, 1, 2);
//
//        control.replay();
//        mock.withVarargsInt(1, 1);
//        mock.withVarargsInt(1, 1, 2);
//        control.verify();
//    }
//
//    public void testVarargLongAccepted() {
//        mock.withVarargsLong(1, (long) 1);
//        mock.withVarargsLong(1, 1, 2);
//
//        control.replay();
//        mock.withVarargsLong(1, (long) 1);
//        mock.withVarargsLong(1, 1, 2);
//        control.verify();
//    }
//
//    public void testVarargShortAccepted() {
//        mock.withVarargsShort(1, (short) 1);
//        mock.withVarargsShort(1, (short) 1, (short) 2);
//
//        control.replay();
//        mock.withVarargsShort(1, (short) 1);
//        mock.withVarargsShort(1, (short) 1, (short) 2);
//        control.verify();
//    }
//    
//    public void testVarargAcceptedIfArrayIsGiven() {
//        IVarArgs object = (IVarArgs) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { IVarArgs.class }, new InvocationHandler() {
//        
//            public Object invoke(Object proxy, Method method, Object[] args)
//                    throws Throwable {
//                return null;
//            }
//        });
//        object.withVarargsObject(1);
//        object.withVarargsObject(1, (Object) null);
//        object.withVarargsObject(1, (Object[]) null);
//        object.withVarargsObject(1, (Object[]) new Object[0] );
//        object.withVarargsObject(1, false);
//        object.withVarargsObject(1, new boolean[] {true, false});
//    }
}
