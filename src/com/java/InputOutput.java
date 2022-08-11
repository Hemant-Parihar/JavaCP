package com.java;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[5];

        for(int i = 0; i < 5; i++) {
            array[i] = in.nextInt();
        }

        for(int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
