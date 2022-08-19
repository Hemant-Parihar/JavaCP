package com.objectOriented.properties.polymorphism;

public class Shape {
    public void area() {
        System.out.println("We are in the shape class.");
    }

    /*
        Final method can't be over ridden. Also they can be used to prevent Inheritance.
     */

        // Early Binding: Determining which method to run at compile time.
        // Late Binding: Determining which method to run at runtime.
//    final public void area() {
//        System.out.println("We are in the shape class.");
//    }
}
