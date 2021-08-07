package com.froggengo.asm.p2;

import java.lang.reflect.Method;
import org.objectweb.asm.Type;

/**
 * @author froggengo@qq.com
 * @date 2021/7/31 18:49.
 * desc:
 * Type是ASM提供的一个辅助类，用于内部类型的转换
 */
public class L1TypeDemo {

    public int testMethod(String value) {
        return value.length();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        final String internalName = Type.getType(String.class).getInternalName();
        final String internalName1 = Type.getInternalName(String.class);
        System.out.println(internalName);
        System.out.println(internalName1);
        final String descriptor = Type.getDescriptor(String.class);
        final String descriptor1 = Type.getType(String.class).getDescriptor();
        System.out.println(descriptor1 + "=" + descriptor);
        //获取方法描述符
        final Method testMethod = L1TypeDemo.class.getDeclaredMethod("testMethod", String.class);
        final String testMethodDesc = Type.getMethodDescriptor(testMethod);
        System.out.println(testMethodDesc);
        //Type 获取方法描述符 ，传入方法的返回值类型和参数类型
        final String methodDescriptor = Type.getMethodDescriptor(Type.INT_TYPE, Type.LONG_TYPE);
        System.out.println(methodDescriptor);
        //获取方法的参数类型
        final Type[] argumentTypes = Type.getArgumentTypes(testMethod);
        for (Type argumentType : argumentTypes) {
            System.out.println("argumentType=" + argumentType);
        }
        //获取方法的返回值
        final Type returnType = Type.getReturnType(testMethod);
        System.out.println("returnType=" + returnType);
    }

}
