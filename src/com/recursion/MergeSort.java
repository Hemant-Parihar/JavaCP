package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 7, 4, 1, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid+1, end);
    }

    private static void merge(int[] arr, int i, int j, int end) {
        int start= i;
        int end1 = j;
        int end2 = end+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(i <= end1 && j <= end2) {

            if (i == end1) {
                while(j < end2) {
                    list.add(arr[j]);
                    j++;
                }
                break;
            } else if (j == end2) {
                while(i < end1) {
                    list.add(arr[i]);
                    i++;
                }
                break;
            }

            if (arr[i] < arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                j++;
            }
        }
        for(int k = 0; k < list.size(); k++) {
            arr[start + k] = list.get(k);
        }
    }
}
