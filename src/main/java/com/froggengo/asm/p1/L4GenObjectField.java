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
public class L4GenObjectField {
    public static void main(String[] args) throws IOException {
        final ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "com/froggengo/asm/gen/p1/GenObjectField1", null, "java/lang/Object", null);
        //与类属性的区别是没有加ACC_STATIC
        {
            final FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PRIVATE, "timer", "J", null, null);
            fieldVisitor.visitEnd();
        }
        classWriter.visitEnd();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenObjectField1.class", classWriter.toByteArray());
    }
}
