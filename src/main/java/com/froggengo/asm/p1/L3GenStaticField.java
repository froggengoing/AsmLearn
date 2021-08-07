package com.froggengo.asm.p1;


import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:29.
 */
public class L3GenStaticField {

    private static long timer = 2;

    public static void main(String[] args) throws IOException {
        final ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "com/froggengo/asm/gen/p1/GenClassField1", null, "java/lang/Object", null);
        //增加龙类型的静态变量，初始值设为null
        //静态变量的复制,在字节码生成的<clinit>方法中
        {
            final FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "timer", "J", null, null);
            fieldVisitor.visitEnd();
        }

        classWriter.visitEnd();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenClassField1.class", classWriter.toByteArray());
    }
}
