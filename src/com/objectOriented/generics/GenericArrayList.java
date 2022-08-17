package com.objectOriented.generics;

import java.util.Arrays;

// We use Generic for type checking as well as making our life easy.

public class GenericArrayList<T extends Number> {
    private Object[] data = new Object[10];
    private int size = 0;

    public GenericArrayList() {
    }

    public GenericArrayList(int size) {
        this.data = new Object[size];
    }

    public void add(T value) {
        if (isFull()) {
            reSize();
        }
        data[size++] = value;
    }

    public T get(int index) {
        return (T) data[index];
    }

    private void reSize() {
        Object[] temp = new Object[2*size];
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
        GenericArrayList<Integer> list = new GenericArrayList(5);
        for(int i = 0; i < 14; i++) {
            list.add(2*i);
        }

        System.out.println(list.toString());
    }
}
