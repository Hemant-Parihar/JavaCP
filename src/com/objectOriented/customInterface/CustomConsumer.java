package com.objectOriented.customInterface;

import java.util.ArrayList;

public class CustomConsumer {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }
//        list.forEach((item) -> System.out.println(item));
        Operation sum = (int a, int b) -> a + b;
        Operation prod = (int a, int b) -> a * b;
        Operation diff = (int a, int b) -> a - b;
        TestInterface testSum = (int a, int b) -> a + b;

        System.out.println(testSum.testOperation(3, 4));

        CustomConsumer myCal = new CustomConsumer();
//        System.out.println(myCal.operate(3, 4 ,sum));
//        System.out.println(myCal.operate(3, 4 ,prod));
//        System.out.println(myCal.operate(3, 4 ,diff));
    }

    int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}