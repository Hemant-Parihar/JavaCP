package com.objectOriented.StaticExample;

public class InnerClass {

    public class SubClass {
        String name;

        public SubClass(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // This statement is giving error, when I am trying to create an object of subClass.

        //SubClass subClass2 = new SubClass("hello");

        // As subClass is also a member of innerClass, innerclass object should be there.
        // If we want to access subClass
        InnerClass innerClass = new InnerClass();
        InnerClass.SubClass subClass = innerClass.new SubClass("hello");
        System.out.println(subClass.name);


        // We can make the subClass as static to access it.
    }
}
