package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> unProcessed = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            unProcessed.add(nums[i]);
        }
//        permutation(unProcessed, new ArrayList<>(), list);
        boolean[] used = new boolean[nums.length];
        permutation2(unProcessed, new ArrayList<>(), list, used);
        return list;
    }

    private static void permutation(List<Integer> unProcessed, List<Integer> processed, List<List<Integer>> list) {
        if (unProcessed.size() == 0) {
            list.add(processed);
        }
        for(int i = 0; i < unProcessed.size(); i++) {
            List<Integer> newUnProcessed = new ArrayList<>();
            for (int j = 0; j < unProcessed.size(); j++) {
                if (i == j) continue;
                newUnProcessed.add(unProcessed.get(j));
            }
            List<Integer> newProcessed = new ArrayList<>();
            newProcessed.addAll(processed);
            newProcessed.add(unProcessed.get(i));
            permutation(newUnProcessed, newProcessed, list);
        }
    }

    private static void permutation2(List<Integer> unProcessed, List<Integer> processed, List<List<Integer>> list, boolean[] used) {
        if (unProcessed.size() == processed.size()) {
            list.add(new ArrayList<>(processed));
            return;
        }
        for(int i = 0; i < unProcessed.size(); i++) {
            if (used[i] == true) continue;
            used[i] = true;
            processed.add(unProcessed.get(i));
            permutation2(unProcessed, processed, list, used);
            used[i] = false;
            processed.remove(processed.size() - 1);
        }
    }
}
