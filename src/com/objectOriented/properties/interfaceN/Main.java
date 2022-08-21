package com.objectOriented.properties.interfaceN;

public class Main {
    public static void main(String[] args) {
        /*
            Java has a big problem. It doesn't support multi inheritance. You can't inherit from multiple class.
             A ( fun()) -> C
             B ( fun()) -> C

             Now C is confused which function to call? (Ambiguity)

             How Java solve this problem? Using Interface.
             In Interfaces we define, what need to be done, not how it is done.
             Even though there are multiple fun() in different interface. But class is free to write override and have its own implementation.
         */

        Car car = new Car();

    }
}
