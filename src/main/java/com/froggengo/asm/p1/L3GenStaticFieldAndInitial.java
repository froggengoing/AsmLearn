package com.froggengo.asm.p1;


import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:29.
 */
public class L3GenStaticFieldAndInitial {

    private static long timer = 2;

    public static void main(String[] args) throws IOException {
        final ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "com/froggengo/asm/gen/p1/GenStaticFieldAndInitial1", null, "java/lang/Object"
            , null);
        //增加龙类型的静态变量，初始值设为null
        //静态变量的复制,在字节码生成的<clinit>方法中
        {
            final FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "timer", "J", null, null);
            fieldVisitor.visitEnd();
        }
        // 调用<cinit>方法
        {
            final MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
            methodVisitor.visitCode();
            //这里必须使用Long对象,否则字节码无法反编译
            methodVisitor.visitLdcInsn(Long.valueOf(2));
            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC,"com/froggengo/asm/gen/p1/GenStaticFieldAndInitial1","timer","J");
            methodVisitor.visitInsn(Opcodes.RETURN);
            // maxStack – maximum stack size of the method.
            // maxLocals – maximum number of local variables for the method
            // 这里只有两个操作,一个将2进栈,为static field赋值
            // 不涉及到本地局部变量表
            methodVisitor.visitMaxs(2,0);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenStaticFieldAndInitial1.class", classWriter.toByteArray());
    }
}
