package com.froggengo.asm.p1;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:28.
 */
public class L2GenClass {

    public static void main(String[] args) throws IOException {
        final ClassWriter classWriter = new ClassWriter(0);
        // 这里增加的final标记
        // 默认父类为Object
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC +Opcodes.ACC_FINAL, "com/froggengo/asm/gen/p1/GenClass1", null, "java/lang/Object", null);
        classWriter.visitEnd();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenClass1.class", classWriter.toByteArray());
    }
}
