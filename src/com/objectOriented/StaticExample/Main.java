package com.objectOriented.StaticExample;

// In Java, flow of the program start from the main function. That is why main is public function.
// main function can be present in any class.

// Every class in java, Inherent Object class.

public class Main {
    public static void main(String[] args) {
        Human Hemant = new Human(28, "Hemant");
        Human Naman = new Human(26, "Naman");

        System.out.println(Hemant.population);
        System.out.println(Naman.population);

        System.out.println(StaticBlock.a);
        StaticBlock.b = 6;
        System.out.println(StaticBlock.b);
    }
}
