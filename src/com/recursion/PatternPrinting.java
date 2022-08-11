package com.recursion;

import java.util.Arrays;

public class PatternPrinting {
    public static void main(String[] args) {
        int num = 5;
//        pattern(4, 0);
        int[] arr = {4, 3, 2, 1};
//        bubbleSort(arr, arr.length - 1, 0);
        selectionSort(arr, arr.length - 1, 0, Integer.MIN_VALUE, -1);
        System.out.println(Arrays.toString(arr));
    }

    private static void pattern(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            pattern(row, col + 1);
        } else {
            System.out.println();
            pattern(row - 1, 0);
        }
    }

    private static void selectionSort(int[] arr, int row, int col, int max, int index) {
        if (row == 0) {
            return;
        }
        if (max < arr[col]) {
            max = arr[col];
            index = col;
        }
        if (col < row) {
            selectionSort(arr, row, col + 1, max, index);
        } else {
            // swap maximum element.
            int temp = arr[row];
            arr[row] = arr[index];
            arr[index] = temp;
            selectionSort(arr, row - 1, 0, Integer.MIN_VALUE, -1);
        }
    }

    private static void bubbleSort(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            // check adjacent element.
            if (arr[col] > arr[col + 1]) {
                // swap
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }

    private static void pattern2(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            pattern(row, col + 1);
            System.out.print("*");
        } else {
            pattern(row - 1, 0);
            System.out.println();
        }
    }


}
