package com.froggengo.asm.p3;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author froggengo@qq.com
 * @date 2021/8/1 12:31.
 * MethodVisit 首先会访问注释和属性信息，然后才是方法的字节码，这些访问顺序在 visitCode 和 visitMaxs 调用之间。所以
 * 这两个方法可以用于检测字节码在访问序列中的开始和结束。ASM 中提供了三个基于 MethodVisitor API 的组件，用于生成和转化方法。
 *
 * - ClassReader 类分析已编译方法的内容，其在 accept 方法的参数中传递了 ClassVisitor，ClassReader 类将针对这一 ClassVisitor 返回的
 * MethodVisitor 对象调用响应的方法。
 * - ClassWriter 的 visitMethod 方法返回 MethodVisitor 接口的一个实现，它直接以二进制形式生成已编译方法
 * - MethodVisitor类将它接收到的所有方法调用委托给另一个MethodVisitor方法。可以将它看作一个事件筛选器。
 *
 * MethodVisitor 回调方法有：
 * - visitParameter：访问方法一个参数
 * - visitAnnotationDefualt：访问注解接口方法的默认值
 * - visitAnnotaion：访问方法的一个注解
 * - visitTypeAnnotation：访问方法签名上的一个类型的注解
 * - visitAnnotableParameterCount：访问注解参数数量，就是访问方法参数有注解参数个数
 * - visitParameterAnnotation：访问参数的注解，返回一个 AnnotationVisitor 可以访问该注解值
 * - visitAttribute：访问方法的属性
 * - visitCode：开始访问方法代码，此处可以添加方法运行前拦截器
 * - visitFrame：访问方法局部变量的当前状态以及操作栈成员信息
 * - visitIntInsn：访问数值类型指令,当 int 取值-1~5采用 ICONST 指令，取值 -128~127 采用 BIPUSH 指令，取值 -32768~32767 采用 SIPUSH 指令，取值 -2147483648~2147483647 采用 ldc
 * 指令。
 * - visitVarInsn：访问本地变量类型指令
 * - visitTypeInsn：访问类型指令，类型指令会把类的内部名称当成参数 Type
 * - visitFieldInsn：域操作指令，用来加载或者存储对象的 Field
 * - visitMethodInsn：访问方法操作指令
 * - visitDynamicInsn：访问动态类型指令
 * - visitJumpInsn：访问比较跳转指令
 * - visitLabelInsn：访问 label，当会在调用该方法后访问该label标记一个指令
 * - visitLdcInsn：访问 LDC 指令，也就是访问常量池索引
 * - visitLineNumber：访问行号描述
 * - visitMaxs：访问操作数栈最大值和本地变量表最大值
 * - visitLocalVariable：访问本地变量描述
 */
public class L2MethodPrintAdapter extends MethodVisitor {
    private static Logger logger = LoggerFactory.getLogger(L2MethodPrintAdapter.class);
    public L2MethodPrintAdapter(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    @Override
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        super.visitFrame(type, numLocal, local, numStack, stack);
        logger.info("type={},numLocal={},local={},numStack={},stack={}",type,numLocal,local,numStack,stack);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
        logger.info("opcode={},var={}",opcode,var);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        super.visitTryCatchBlock(start, end, handler, type);
        logger.info("start={},end={},handler={},type={}",start, end, handler, type);
    }

    @Override
    public void visitLdcInsn(Object value) {
        super.visitLdcInsn(value);
        logger.info("value={}",value);
    }

    @Override
    public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
        super.visitAnnotableParameterCount(parameterCount, visible);
        logger.info("parameterCoun{}, visible={}",parameterCount, visible);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        logger.info("visitAnnotationDefault");
        return super.visitAnnotationDefault();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        logger.info("AnnotationVisitor:descriptor={},visible={}",descriptor, visible);
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {

        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }
}
