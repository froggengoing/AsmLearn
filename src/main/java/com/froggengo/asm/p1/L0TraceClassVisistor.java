package com.froggengo.asm.p1;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.TypePath;

/**
 * @author froggengo@qq.com
 * @date 2021/7/31 19:33.
 */
public class L0TraceClassVisistor extends ClassVisitor {

    public L0TraceClassVisistor(int api) {
        super(api);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.printf("Method:%s=%s=%s=%s%n", access, name, descriptor, signature);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {
        System.out.printf("Module:%s=%s=%s%n", name, access, version);
        return super.visitModule(name, access, version);
    }

    @Override
    public void visitNestHost(String nestHost) {
        super.visitNestHost(nestHost);
        System.out.println("nestHost:" + nestHost);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
        System.out.println("source：" + source + "=" + debug);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.printf("visit:%s=%s=%s=%s=%s%n", version, access, name, signature, superName);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.printf("Field:%s=%s=%s=%s=%s%n", access,  name,  descriptor,  signature,  value);
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.printf("Annotation:%s=%s%n", descriptor,  visible);
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
        System.out.printf("Attribute:%s=%n",attribute.type);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.printf("TypeAnnotation:%s=%s=%s%n", typeRef,  typePath,descriptor);
        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }
}
