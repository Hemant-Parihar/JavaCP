package com.objectOriented.comparator;

import java.util.Objects;

public class Student implements Comparable {
    private int rollNo;
    private int marks;

    public Student(int rollNo, int marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public int compareTo(Object o) {
        int diff = this.marks - ((Student) o).marks;
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && marks == student.marks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, marks);
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
}
