package com.froggengo.asm.p3;

import java.io.IOException;
import java.util.logging.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 8:30.
 */
public class L2MethodPrintDemo {

    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        final ClassReader classReader = new ClassReader(L2MethodPrintDemo.class.getName());
        final ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM8) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                System.out.println("main-method:name=" + name);
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new L2MethodPrintAdapter(Opcodes.ASM8, mv);
            }
        };
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);

    }

}
