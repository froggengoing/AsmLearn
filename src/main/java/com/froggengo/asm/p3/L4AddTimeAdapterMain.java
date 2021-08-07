package com.froggengo.asm.p3;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class L4AddTimeAdapterMain {

    public static void main(String[] args) throws Exception {
        final ClassReader classReader = new ClassReader(L4AddTimeAdapterClass.class.getName());
        // COMPUTE_MAXS and COMPUTE_FRAMES
        final ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        final L4AddTimeVisitor visitor = new L4AddTimeVisitor(Opcodes.ASM8, classWriter);
        //这里是使用visitor而不是writer
        //SKIP_DEBUG 报错，必须使用EXPAND_FRAMES？
        classReader.accept(visitor, ClassReader.EXPAND_FRAMES);
        // classReader.accept(visitor, ClassReader.SKIP_DEBUG);
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/res/l3/p4/L4AddTimeAdapterClass.class", classWriter.toByteArray());
        final Class<?> aClass = new L3MyLoader().defineClass("com.froggengo.asm.p3.L4AddTimeAdapterClass", classWriter.toByteArray());
        final Object instance = aClass.getConstructor(null).newInstance();
        final Method method = aClass.getDeclaredMethod("addTime");
        final Field field = aClass.getField("time");
        final Object invoke = method.invoke(instance);
        System.out.println("时间："+field.get(instance));
    }
}
