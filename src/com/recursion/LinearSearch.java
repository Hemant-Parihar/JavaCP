package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;

// Return all the index of the target element.
public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {1, 22, 3 , 5 ,5 , 5, 3, 2, 5, 5};
        System.out.println(search(array, 0, 5));
    }

    private static ArrayList<Integer> search(int[] array, int index, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (index >= array.length) return ans;
        if (array[index] == target) {
            ans.add(index);
        }
        ans.addAll(search(array, index+1, target));
        return ans;
    }
}
