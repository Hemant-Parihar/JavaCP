package com.objectOriented;

public class FinalClass {
    public static void main(String[] args) {
        Integer a = 5;
        a = 6;
        change(a);
        System.out.println(a);
    }
    // Here Integer is object then why it is not changing a value, when we passed it.
    // When object are passed to a function parameter, they are passed as reference as a value.
    // Everything in java is passed by value only.
    private static void change(Integer a) {
        a = 7;
    }
}
