package com.froggengo.asm.p4;

import com.froggengo.asm.p2.ClassVisistorImpl;
import com.froggengo.asm.p3.L4AddTimeAdapterClass;
import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * @author froggengo@qq.com
 * @date 2021/8/4 0:25.
 */
public class L1Main {

    public static void main(String[] args) throws IOException {
        final Textifier textifier = new Textifier();
        final PrintWriter printWriter = new PrintWriter(System.out, true);
        final ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM8) {
            @Override
            public void visitInnerClass(String name, String outerName, String innerName, int access) {
                super.visitInnerClass(name, outerName, innerName, access);
                System.out.println("inner class:" +name+"--" +outerName + "/" + innerName);
                try {
                    final ClassReader classReader = new ClassReader(name);
                    classReader.accept(new ClassVisistorImpl(Opcodes.ASM8),ClassReader.SKIP_DEBUG);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        final TraceClassVisitor traceClassVisitor = new TraceClassVisitor(classVisitor,printWriter);

        final ClassReader classReader = new ClassReader(L1AddTimeAdapterClass.class.getName());
        classReader.accept(traceClassVisitor, ClassReader.SKIP_DEBUG);
    }

}
