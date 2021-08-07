package com.froggengo.asm.p3;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.logging.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 8:58.
 */
public class L3AddTimeAdapterDemo {

    // static long time = 0;
    public void doSomething() {
        // time -= System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // time += System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        System.currentTimeMillis();
        final ClassReader classReader = new ClassReader("com.froggengo.asm.p3.L3AddTimeAdapterDemo");
        final ClassWriter classWriter = new ClassWriter(classReader, 0);
        final L3AddTimerAdapterVisitor classVisitor = new L3AddTimerAdapterVisitor(Opcodes.ASM8, classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        final L3MyLoader loader = new L3MyLoader();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/res/l3/p3/L3AddTimeAdapterDemo.class",classWriter.toByteArray());
        final Class<?> aClass = loader.defineClass("com.froggengo.asm.p3.L3AddTimeAdapterDemo", classWriter.toByteArray());
        final Method method = aClass.getDeclaredMethod("doSomething");
        final Field field = aClass.getDeclaredField("time");
        final Object instance = aClass.getConstructor().newInstance();
        method.invoke(instance);
        System.out.println(field.get(instance));
    }

}
