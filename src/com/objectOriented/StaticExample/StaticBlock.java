package com.objectOriented.StaticExample;

public class StaticBlock {
    static int a = 5;
    static int b;

    // This block of code, will only execute once, whenever the first object of this class, will be created.
    static {
        b = a * 4;
    }

    public static void main(String[] args) {
        StaticBlock example1 = new StaticBlock();
        System.out.println(example1.a + " " + example1.b);
        StaticBlock.a += 3;

        StaticBlock example2 = new StaticBlock();
        System.out.println(example2.a + " " + example2.b);
    }
}
