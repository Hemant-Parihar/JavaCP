package com.string;

public class StringLearn {
    public static void main(String[] args) {
        // How Strings are stored in java.
        // Strings are stored in the Java Pool. Java Pool manages the strings.
        // If there are two strings with same value, then Java pool won't create any new strings.
        // Actually both the reference variable will point to the same string.
        // Strings are immutable. Once they are created, they can't be change. Only new one can be created.


        String a = "Hemant";
        String b = "Hemant";
        System.out.println(a == b);

        // == is comparison operator. Here it will compare that both the reference variable are pointing to the same object.
        // Also, there is no pointer concept in java.

        // We can explicitly tell java to create the string with the new keyword.
        // It will create the string object outside the java pool.
        // Remember: Whenever we are using new keyboard, we are taking the space in heap memory.

        String name1 = new String("Hemant");
        String name2 = new String("Hemant");
        System.out.println(name1 == name2);

        // As we have use the new keyword, they are pointing to the different object.

        // To check whether it is pointing to the same value we can use .equals method on the string class.
        System.out.println(name1.equals(name2));
    }
}
