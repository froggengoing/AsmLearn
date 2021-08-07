package com.froggengo.asm.p2;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

/**
 * @author froggengo@qq.com
 * @date 2021/7/31 22:43.
 */
public class L4AddFieldAdapter extends ClassVisitor {

    private final int version;
    private final ClassVisitor classVistor;
    private final String fieldName;
    private final int fieldAccess;
    private final String fieldDesc;
    boolean isExists = false;

    public L4AddFieldAdapter(int version, ClassVisitor classVisitor, String fieldName,
                             int fieldAccess, String fieldDesc) {
        super(version, classVisitor);
        this.version     = version;
        this.classVistor = classVisitor;
        this.fieldName   = fieldName;
        this.fieldAccess = fieldAccess;
        this.fieldDesc   = fieldDesc;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("field=" + name + " desc=" + descriptor);
        if (fieldName.equals("name")) {
            System.out.println("name已存在");
        }
        if (fieldName.equals(name)) {
            this.isExists = true;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        if (!isExists) {
            final FieldVisitor fieldVisitor = cv.visitField(fieldAccess, fieldName, fieldDesc, null, null);
            if (fieldVisitor != null) {
                fieldVisitor.visitEnd();
            }

        }
    }
}
