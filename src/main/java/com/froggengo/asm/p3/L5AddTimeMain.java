package com.froggengo.asm.p3;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * @author froggengo@qq.com
 * @date 2021/8/3 9:01.
 */
public class L5AddTimeMain {

    public static void main(String[] args) throws Exception {
        final ClassReader classReader = new ClassReader("com.froggengo.asm.p3.L4AddTimeAdapterClass");
        final ClassWriter classWriter = new ClassWriter(classReader,ClassWriter.COMPUTE_FRAMES);
        // final L5AddTimeMthodVisitor mthodVisitor = new L5AddTimeMthodVisitor(Opcodes.ASM8,);
        final L5AddTimeVisitor visitor = new L5AddTimeVisitor(Opcodes.ASM8, classWriter);
        classReader.accept(visitor,ClassReader.SKIP_DEBUG);
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/res/l3/p5/L4AddTimeAdapterClass.class", classWriter.toByteArray());
        final Class<?> aClass = new L3MyLoader().defineClass("com.froggengo.asm.p3.L4AddTimeAdapterClass", classWriter.toByteArray());
        final Object instance = aClass.getConstructor(null).newInstance();
        final Method method = aClass.getDeclaredMethod("addTime");
        final Field field = aClass.getField("time");
        method.invoke(instance);
        System.out.println("时间："+field.get(instance));

    }

}
