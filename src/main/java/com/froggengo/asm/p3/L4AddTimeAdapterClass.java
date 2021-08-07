package com.froggengo.asm.p3;

import java.util.function.Function;
import org.objectweb.asm.ClassVisitor;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 23:43.
 */
public class L4AddTimeAdapterClass {

    public void addTime() throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(1000);
    }

    ;

}
