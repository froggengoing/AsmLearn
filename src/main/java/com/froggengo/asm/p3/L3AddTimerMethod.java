package com.froggengo.asm.p3;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 9:14.
 */
public class L3AddTimerMethod extends MethodVisitor {

    private static Logger logger = LoggerFactory.getLogger(L3AddTimerMethod.class);

    private final String owner;

    public L3AddTimerMethod(int api, MethodVisitor methodVisitor, String owner) {
        super(api, methodVisitor);
        this.owner = owner;
    }

    @Override
    public void visitCode() {
        logger.info("visitCode");
        mv.visitCode();
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

    }

    @Override
    public void visitInsn(int opcode) {
        logger.info("visitInsn{},",opcode);
        // if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
            mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "time", "J");
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitInsn(Opcodes.LADD);
            mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "time", "J");
        }
        mv.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        logger.info("visitMaxs");
        super.visitMaxs(maxStack, maxLocals);
        mv.visitMaxs(maxStack + 4, maxLocals);
    }
}
