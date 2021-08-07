package com.froggengo.asm.p3;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/3 9:00.
 */
public class L5AddTimeVisitor extends ClassVisitor {

    private String owner;

    public L5AddTimeVisitor(int api, ClassWriter classWriter) {
        super(api, classWriter);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.owner  =name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        final MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        if ("addTime".equals(name)) {
            final L5AddTimeMthodVisitor mthodVisitor = new L5AddTimeMthodVisitor(Opcodes.ASM8, owner, name,access,descriptor,
                                                                                          methodVisitor);
            return mthodVisitor;
        }
        return methodVisitor;
    }

    @Override
    public void visitEnd() {
        final FieldVisitor fieldVisitor = cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "time", "J", null, null);
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
        super.visitEnd();
    }

}
