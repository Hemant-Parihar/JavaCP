package com.objectOriented.properties.polymorphism;

public class Main {
    public static void main(String[] args) {
        // Polymorphism means many(poly) ways to represent(morphism).
        // There are two types of Polymorphism.

        /*
        1. Over loading. (Static Polymorphism).
            It is static because it is determine during the compile time.
            In over loading, method can have same name, but different return type or parameters.
            We see this mostly in case of Constructor.

         2. Over Riding (Dynamic Polymorphism).
            It is dynamic, as it is determined during the run time.
            In it Java determine, which method to run. First it will look in the object, then object super, then more super class. Etc.
         */

        Shape shape = new Shape();
        Shape circle = new Circle();
        shape.area();
        circle.area();
        // System.out.println(circle.name);
        // We are able to reference circle object using the Shape class, but it will have access to only shape properties and method.
        // Because Shape can't look what circle have (circle extends shape).

        // Determination which method to run is happen at run time.
    }
}
