package com.froggengo.asm.p1;

import java.util.function.Function;

/**
 * @author froggengo@qq.com
 * @date 2021/8/6 0:09.
 */
public class L6InnerClass2 {

    public void outerMethod() {
        final Function<String, String> func = new Function<>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };
    }

}
