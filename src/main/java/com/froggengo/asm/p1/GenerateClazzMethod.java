package com.froggengo.asm.p1;

import com.froggengo.asm.HelloWorld;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

public class GenerateClazzMethod {

    public static void main(java.lang.String[] args) throws Exception{
        ClassPool pool = ClassPool.getDefault();
        final CtClass ctClass1 = pool.get(HelloWorld.class.getName());

        // 创建类信息
        CtClass ctClass = pool.makeClass("com.froggengo.asm.HelloWorld");

        // 添加方法
        CtMethod mainMethod = new CtMethod(CtClass.voidType, "main", new CtClass[]{pool.get(String[].class.getName())}, ctClass);
        mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
        mainMethod.setBody("{System.out.println(\"hi javassist! Greetings from 小傅哥(bugstack.cn)\");}");

        ctClass.addMethod(mainMethod);

        // 输出类的内容
        ctClass.writeFile();

        // 测试调用
        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Method main = clazz.getDeclaredMethod("main", String[].class);
        main.invoke(obj, (Object) new String[1]);

    }

}