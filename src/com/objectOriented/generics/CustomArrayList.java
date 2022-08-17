package com.objectOriented.generics;

import java.util.Arrays;

public class CustomArrayList {

    private int[] data = new int[10];
    public int size = 0;

    public CustomArrayList() {
    }

    public CustomArrayList(int size) {
        this.data = new int[size];
    }

    public void add(int value) {
        if (isFull()) {
            reSize();
        }
        data[size++] = value;
    }

    private void reSize() {
        int[] temp = new int[2*size];
        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(5);
        for(int i = 0; i < 3; i++) {
            list.add(2*i);
        }

        System.out.println(list.toString());
    }
}
