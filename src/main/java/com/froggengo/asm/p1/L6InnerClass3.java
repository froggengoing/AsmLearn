package com.froggengo.asm.p1;

import java.util.function.Function;

/**
 * @author froggengo@qq.com
 * @date 2021/8/6 0:09.
 */
public class L6InnerClass3 {

    public void outerMethod() {
        Function<String, String> lambdaFunc = (var1) -> "hello " + var1;
    }

}
