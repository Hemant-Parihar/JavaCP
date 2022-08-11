package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
//            list.add(in.nextInt());
            map.put(i, in.nextInt());
        }

        System.out.println(map);
    }
}
