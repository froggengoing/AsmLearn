package com.froggengo.asm.p1;

import com.froggengo.asm.p3.L3MyLoader;
import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:31.
 */
public class L5GenAddTwoNumMethod {

    public int addTwoNUm(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        final ClassWriter classWriter = new ClassWriter(0);
        classWriter
            .visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "com/froggengo/asm/gen/p1/GenMethod1", null, "java/lang/Object",
                   null);
        {
            final MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "addTwoNum", "(II)I", null, null);
            final Label label = new Label();
            mv.visitLabel(label);
            // 0是this ,所以从1开始
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitInsn(Opcodes.IADD);
            mv.visitInsn(Opcodes.IRETURN);
            final Label label1 = new Label();
            mv.visitLabel(label1);
            // 必须执行visiLocalVariable， 变量名为var1 和var2
            // descriptor必须加分号;
            // 否则报错Field "this" in class com/froggengo/asm/gen/p1/GenMethod1 has illegal signature
            mv.visitLocalVariable("this", "Lcom/froggengo/asm/gen/p1/GenMethod1;", null, label, label1, 0);
            mv.visitLocalVariable("a", "I", null, label, label1, 1);
            mv.visitLocalVariable("b", "I", null, label, label1, 2);
            // 两个ILOAD，后执行IADD，栈的高度有2变成1，所以最大为2
            //这里包括了this，所以本地变量表为3
            mv.visitMaxs(2, 3);

            mv.visitEnd();
        }
        // 还必须生成构造方法init
        {
            final MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            final Label label = new Label();
            mv.visitLabel(label);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            //调用父类
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            final Label label1 = new Label();
            mv.visitLabel(label1);
            mv.visitLocalVariable("this", "Lcom/froggengo/asm/gen/p1/GenMethod1;", null, label, label1, 0);
            // 这里最大栈为什么为1
            // 这里改为2也可以，应该是申请最大栈的高度，给多了也可以执行
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        classWriter.visitEnd();
        final byte[] bytes = classWriter.toByteArray();
        final Class<?> aClass = new L3MyLoader().defineClass("com.froggengo.asm.gen.p1.GenMethod1", bytes);
        final Method[] declaredMethods = aClass.getDeclaredMethods();
        //必须与类型对应，int.class 不能用Integer.class
        final Method method = aClass.getDeclaredMethod("addTwoNum", int.class, int.class);
        final Object instance = aClass.getConstructor(null).newInstance();
        System.out.println(method.invoke(instance, 2, 4));
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenMethod1.class", bytes);

    }
}
