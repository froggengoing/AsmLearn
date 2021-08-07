package com.froggengo.asm.p2;

import com.froggengo.asm.uitl.ClassOutputUtil;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/7/30 19:09.
 */
public class L3ClassWriteDemo {

    public static void main(String[] args) throws IOException {
        ClassWriter clz = new ClassWriter(0);
        String[] interfaces={"pkg/Mesureable"};
        clz.visit(Opcodes.V11,Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT +Opcodes.ACC_INTERFACE,"pkg/Compable",null,
                  "java/lang/Object",interfaces);
        clz.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,"LESS","I",null,-1).visitEnd();
        clz.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,"MORE","I",null,0).visitEnd();
        clz.visitEnd();
        final byte[] bytes = clz.toByteArray();
        ClassOutputUtil.byte2File(null,bytes);

    }


}
