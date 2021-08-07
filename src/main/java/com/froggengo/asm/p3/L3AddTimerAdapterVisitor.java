package com.froggengo.asm.p3;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 9:12.
 */
public class L3AddTimerAdapterVisitor extends ClassVisitor {

    private static Logger logger = LoggerFactory.getLogger(L3AddTimerAdapterVisitor.class);
    private String owner = "";
    private boolean isInterface = false;

    public L3AddTimerAdapterVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        owner       = name;
        isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
        logger.info("visit:{}",name);
        cv.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        logger.info("visitMethod={}",name);
        MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
        // if (!isInterface && methodVisitor != null && !name.equals("<init>") && !name.equals("main")) {
        if (name.equals("doSomething")) {
            methodVisitor = new L3AddTimerMethod(Opcodes.ASM7, methodVisitor, owner);
        }
        return methodVisitor;

    }

    @Override
    public void visitEnd() {
        logger.info("visitEnd");
        if (!isInterface) {
            FieldVisitor fieldVisitor = cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "time", "J", null, null);
            fieldVisitor.visitEnd();
        }
        super.visitEnd();
    }
}
