package com.froggengo.asm.p1;

import java.lang.invoke.VarHandle;
import java.util.function.Function;

/**
 * @author froggengo@qq.com
 * @date 2021/8/6 0:09.
 */
public class L6InnerClass1 {

    String name;
    static String staticName;

    class InnerClass {
        String name1;
        public void innerMethod() {
            System.out.println(name);
        }
        class InnerClass2 {

            public void innerMethod2() {
                System.out.println(name);
                System.out.println(name1);
            }
        }
    }

    public void doSomething() {
        System.out.println("hello world!!!");
    }

}
