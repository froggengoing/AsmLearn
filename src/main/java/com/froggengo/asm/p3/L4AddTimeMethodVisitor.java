package com.froggengo.asm.p3;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AnalyzerAdapter;

/**
 * 注意这里是AnalyzerAdapter，自动计数stack
 */
public class L4AddTimeMethodVisitor extends AnalyzerAdapter {


    private final String owner;
    // 覆盖父类的maxStack
    // private int maxStack;

    protected L4AddTimeMethodVisitor(int api, String owner, int access, String name, String descriptor, MethodVisitor methodVisitor) {
        super(api, owner, access, name, descriptor, methodVisitor);
        this.owner = owner;
    }


    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "time", "J");
        mv.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "currentTimeMillis",
            "()J",
            false
        );
        mv.visitInsn(Opcodes.LSUB);
        mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "time", "J");
        // this.maxStack = 4;
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
            mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "time", "J");
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitInsn(Opcodes.LADD);
            mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "time", "J");
            // maxStack = Math.max(maxStack, stack.size() + 4);
        }
        super.visitInsn(opcode);
    }
}
