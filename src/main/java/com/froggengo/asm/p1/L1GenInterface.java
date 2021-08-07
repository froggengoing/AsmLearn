package com.froggengo.asm.p1;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import javassist.bytecode.Opcode;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:28.
 */
public class L1GenInterface {

    public static void main(String[] args) throws IOException {
        final ClassWriter classWriter = new ClassWriter(0);
        // 不加ACC_INTERFACE，则为class文件
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC + Opcodes.ACC_INTERFACE,"com/froggengo/asm/gen/p1/GenInterface1",null,null, null);
        classWriter.visitEnd();
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/gen/p1/GenInterface1.class",classWriter.toByteArray());
    }
}
