package com.froggengo.asm.p2;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * @author froggengo@qq.com
 * @date 2021/7/31 23:36.
 */
public class L4AddFieldDemo {

    String name = "hello world";

    public static void main(String[] args) throws IOException {
        final ClassReader classReader = new ClassReader("com.froggengo.asm.p2.L4AddFieldDemo");
        final ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        final L4AddFieldAdapter classVisitor = new L4AddFieldAdapter(Opcodes.ASM8, classWriter, "age", Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC,
                                                                     "Ljava/lang/String");
        classReader.accept(classVisitor,ClassReader.SKIP_CODE);
        //输出
        final ClassVisistorImpl printVisistor = new ClassVisistorImpl(Opcodes.ASM8);
        final ClassReader printReader = new ClassReader(classWriter.toByteArray());
        printReader.accept(printVisistor,ClassReader.SKIP_CODE);
        //src/main/java/com/froggengo/asm/p2/L4AddFieldDemo.java
        ClassOutputUtil.byte2File("src/main/java/com/froggengo/asm/res/L4AddFieldDemo.class",classWriter.toByteArray());


    }

}
