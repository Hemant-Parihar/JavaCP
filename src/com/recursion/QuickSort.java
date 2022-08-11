package com.recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 3, 8, 9, 4, 2, 4};
//        quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start < 1) return;
        int indexOfPivot = partition(arr, start, end);
        quickSort(arr, start, indexOfPivot - 1);
        quickSort(arr, indexOfPivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int j = start - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                // swap
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return j;
    }
}
