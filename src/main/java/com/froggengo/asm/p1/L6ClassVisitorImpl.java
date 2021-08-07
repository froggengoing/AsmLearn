package com.froggengo.asm.p1;

import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:35.
 */
public class L6ClassVisitorImpl extends ClassVisitor {

    public L6ClassVisitorImpl(int api) {
        super(api);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.printf("visit=name:%s,signature:%s %n", name, signature);
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public void visitNestHost(String nestHost) {
        System.out.println("nestHost=" + nestHost);
        super.visitNestHost(nestHost);
    }

    @Override
    public void visitNestMember(String nestMember) {
        System.out.println("nestMember=" + nestMember);
        super.visitNestMember(nestMember);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
        System.out.printf("innerClass==name：%s,outerName：%s,innerName：%s %n", name, outerName, innerName);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.printf("field==name:%s,descriptor:%s,signature:%s %n", name, descriptor, signature);
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.printf("visitMethod==name:%s,descriptor:%s %n", name, descriptor);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }


    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
        System.out.printf("outClass:%s,%s,%s %n", owner, name, descriptor);
        super.visitOuterClass(owner, name, descriptor);
    }


    @Override
    public void visitSource(String source, String debug) {
        System.out.printf("source:%S,debug:%s", source, debug);
        super.visitSource(source, debug);
    }

    @Override
    public void visitEnd() {
        System.out.println("visitEnd");
        super.visitEnd();
    }

}
