package com.objectOriented.StaticExample;

// Static Keyword.
// There are some properties that are not related to the object, but it is common to all the object.
// For such property we can use the static keywords.

// Remember, whenever we are using static keyword, it is gonna stay in the memory till the program run.


/*
    You can access the static variable/method, without creating the object at all.

    Static Variable / method, belongs to the class, not object.

    Static method, can only refer to the static variable / method. Because if it is not static that's mean it is depending on the object.
    And Object may not be created when we are referring/accessing it.

    Objects are created at RunTime, but static methods are resolved during compile time.
 */

public class Human {
    int age;
    String name;
    static long population = 0;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        Human.population++;
    }
}
