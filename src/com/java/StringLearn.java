package com.java;

public class StringLearn {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[0]); // This should print 0.

        String[] str = new String[4];
        System.out.println(str[0]); // As we have not initialze, it is printing null.
        // Array of non primitive data type, will result null, if we don't initialize it.
        // But it is not the case with array of primitive data type.

        // Moreever, In java array are stored in the heap memory.
        // And in heap memory, the object may not be continuous.
        // Therefore, array in java may not be continuous.

        // Array will pe pointed out by reference, where each element is an object.

        // Java don't have pointers.
    }
}
