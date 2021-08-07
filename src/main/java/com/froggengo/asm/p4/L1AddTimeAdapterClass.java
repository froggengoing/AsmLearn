package com.froggengo.asm.p4;

import java.util.function.Function;

/**
 * @author froggengo@qq.com
 * @date 2021/8/2 23:43.
 */
public class L1AddTimeAdapterClass {

    public void addTime() throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(1000);
        Function<Integer, String> func = (a) -> {
            return "i am " + a + " years old ";
        };
        final String res = func.apply(9);
        System.out.println(res);
        final Function<Integer, String> func2 = new Function<>() {

            @Override
            public String apply(Integer integer) {
                return "today is " + integer;
            }
        };
        System.out.println(func2.apply(12));

    }

    ;

}
