package com.froggengo.asm.p1;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/7 17:46.
 */
public class L6ReadMethodInnerClass {

    public static void main(String[] args) throws Exception {
        final ClassReader classReader = new ClassReader(L6InnerClass2.class.getName());
        final ClassVisitor classVisitor = new L6ClassVisitorImpl(Opcodes.ASM8);
        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG);
        /**
         * visit=name:com/froggengo/asm/p1/L6InnerClass2,signature:null
         * nestMember=com/froggengo/asm/p1/L6InnerClass2$1
         * innerClass==name：com/froggengo/asm/p1/L6InnerClass2$1,outerName：null,innerName：null
         * visitMethod==name:<init>,descriptor:()V
         * visitMethod==name:outerMethod,descriptor:()V
         * visitEnd
         */
    }
}
