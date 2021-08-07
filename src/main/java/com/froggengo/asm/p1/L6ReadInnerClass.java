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
public class L6ReadInnerClass {

    public static void main(String[] args) throws IOException {
        final ClassReader classReader = new ClassReader(L6InnerClass1.class.getName());
        final ClassVisitor classVisitor = new L6ClassVisitorImpl(Opcodes.ASM8);
        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG);
        /**
         * visit=name:com/froggengo/asm/p1/L6InnerClass1,signature:null
         * nestMember=com/froggengo/asm/p1/L6InnerClass1$InnerClass
         * nestMember=com/froggengo/asm/p1/L6InnerClass1$InnerClass$InnerClass2
         * innerClass==name：com/froggengo/asm/p1/L6InnerClass1$InnerClass,outerName：com/froggengo/asm/p1/L6InnerClass1,innerName：InnerClass
         * innerClass==name：com/froggengo/asm/p1/L6InnerClass1$InnerClass$InnerClass2,outerName：com/froggengo/asm/p1/L6InnerClass1$InnerClass,innerName：InnerClass2
         * field==name:name,descriptor:Ljava/lang/String;,signature:null
         * field==name:staticName,descriptor:Ljava/lang/String;,signature:null
         * visitMethod==name:<init>,descriptor:()V
         * visitMethod==name:doSomething,descriptor:()V
         * visitEnd
         */
    }
}
