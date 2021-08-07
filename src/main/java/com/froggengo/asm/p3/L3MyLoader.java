package com.froggengo.asm.p3;

public class L3MyLoader extends ClassLoader {

    public Class<?> defineClass(String name, byte[] b)
        throws ClassFormatError {
        return defineClass(name, b, 0, b.length);
    }
}
