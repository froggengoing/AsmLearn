package com.froggengo.asm.gen.p1;

public final class GenMethod1 {
    public int addTwoNum(int var1, int var2) {
        return var1 + var2;
    }

    public static void main(String[] args) {
        System.out.println(new GenMethod1().addTwoNum(1, 2));
    }
}