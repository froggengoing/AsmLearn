package com.froggengo.asm.p2;

import java.io.IOException;
import java.util.ArrayList;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

/**
 * @author froggengo@qq.com
 * @date 2021/7/31 19:37.
 */
public class L2ClassReaderDemo {

    public static void main(String[] args) throws IOException {
        final ClassReader classReader = new ClassReader(ArrayList.class.getName());
        classReader.accept(new ClassVisistorImpl(Opcodes.ASM8), ClassReader.EXPAND_FRAMES);
    }

}
