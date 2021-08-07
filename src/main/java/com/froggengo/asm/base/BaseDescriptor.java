package com.froggengo.asm.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author froggengo@qq.com
 * @date 2021/8/3 17:49.
 */
public class BaseDescriptor {

    //B
    byte byteType;
    //Ljava/lang/Byte;
    Byte byteTypeOb;
    //S
    short shortType;
    //Ljava/lang/Short;
    Short shortTypeOb;
    // I
    int intType;
    //Ljava/lang/Integer;
    Integer intTypeOb;
    //J
    long longType;
    //Ljava/lang/Long;
    Long longTypeOb;
    //F
    float floatType;
    //Ljava/lang/Float;
    Float floatTypeOb;
    //D
    double doubleType;
    //Ljava/lang/Double;
    Double doubleTypeOb;
    //C
    char charType;
    //Ljava/lang/String;
    String stringType;
    //Ljava/util/List;
    //java/util/ArrayList
    List list = new ArrayList<String>();
    //Ljava/lang/Void;
    Void a;
    //类似的void 的描述时V

    public long add(long a, long b) {
        return a + b;
    }

}
