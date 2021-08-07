package com.froggengo.asm.p1;

import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/8/5 15:34.
 */
public class L6ReadLamda {

    public static void main(String[] args) throws Exception {
        final ClassReader classReader = new ClassReader(L6InnerClass3.class.getName());
        final ClassVisitor classVisitor = new L6ClassVisitorImpl(Opcodes.ASM8);
        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG);
    }
    /**
     * visit=name:com/froggengo/asm/p1/L6InnerClass3,signature:null
     * innerClass==name：java/lang/invoke/MethodHandles$Lookup,outerName：java/lang/invoke/MethodHandles,innerName：Lookup
     * visitMethod==name:<init>,descriptor:()V
     * visitMethod==name:outerMethod,descriptor:()V
     * visitMethod==name:lambda$outerMethod$0,descriptor:(Ljava/lang/String;)Ljava/lang/String;
     * visitEnd
     */
}
