package com.froggengo.asm.p3;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class L4AddTimeVisitor extends ClassVisitor {

    private String owner;

    public L4AddTimeVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.owner = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("addTime")) {
            return new L4AddTimeMethodVisitor(Opcodes.ASM8, owner, access, name, descriptor, mv);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        //这里会生成静态类属性
        final FieldVisitor fieldVisitor = cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "time", "J", null, 2L);
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
        super.visitEnd();
    }
}
