package com.froggengo.asm.p3;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * @author froggengo@qq.com
 * @date 2021/8/1 12:29.
 */
public class L1TypeMethodDemo {

    public static void main(String[] args) {
        final int opcode = Type.FLOAT_TYPE.getOpcode(Opcodes.IMUL);
    }
}
