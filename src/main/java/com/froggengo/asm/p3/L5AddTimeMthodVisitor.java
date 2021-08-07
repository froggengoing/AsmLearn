package com.froggengo.asm.p3;

import javassist.bytecode.Opcode;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * @author froggengo@qq.com
 * @date 2021/8/3 9:00.
 */
public class L5AddTimeMthodVisitor extends LocalVariablesSorter {


    private final String owner;
    private int time;
    private LocalVariablesSorter localVariablesSorter;
    AnalyzerAdapter analyzerAdapter;
    protected L5AddTimeMthodVisitor(int api, String owner, String name,int access, String descriptor, MethodVisitor methodVisitor) {
        super(api, access, descriptor, methodVisitor);
        // this.localVariablesSorter=new LocalVariablesSorter(access,descriptor,this);
        // this.analyzerAdapter = new AnalyzerAdapter(owner,access,name,descriptor,this);
        this.owner = owner;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        time = newLocal(Type.LONG_TYPE);
        mv.visitVarInsn(Opcodes.LSTORE, time);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || Opcodes.ATHROW == opcode) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LLOAD, time);
            mv.visitInsn(Opcodes.LSUB);
            mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "time", "J");
            mv.visitInsn(Opcodes.LADD);
            mv.visitFieldInsn(Opcode.PUTSTATIC, owner, "time", "J");
        }
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack + 4, maxLocals);
    }
}
