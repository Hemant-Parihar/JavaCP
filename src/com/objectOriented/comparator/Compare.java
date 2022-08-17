package com.objectOriented.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        Student stu1 = new Student(12, 35);
        Student stu2 = new Student(42, 18);
        Student stu3 = new Student(24, 20);
        Student stu4 = new Student(64, 53);
        Student stu5 = new Student(26, 25);

        Student[] list = {stu1, stu2, stu3, stu4, stu5};

        System.out.println(Arrays.toString(list));
        Arrays.sort(list, (o1, o2) -> (int)(o1.getMarks() - o2.getMarks()));
        System.out.println(Arrays.toString(list));

        if (stu1.compareTo(stu2) > 0) {
            System.out.println("Studnet 1 is having more marks.");
        }
    }
}
