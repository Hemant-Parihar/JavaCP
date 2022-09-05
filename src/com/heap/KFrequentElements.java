package com.heap;

import javafx.util.Pair;

import java.util.*;

public class KFrequentElements {
    public static void main(String[] args) {
        int[] arr = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (freqMap.containsKey(nums[i]) == false) {
                freqMap.put(nums[i], 1);
            } else {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b)->(a.getKey()-b.getKey()));
        freqMap.forEach( (key, value) -> {
                    if (minHeap.size() == k && value < minHeap.peek().getKey() ) {

                    } else {
                        minHeap.add(new Pair<Integer, Integer>(value, key));
                        if (minHeap.size() == k + 1) {
                            minHeap.poll();
                        }
                    }
                }
        );
        int[] ans = new int[k];
        int index = 0;
        while(minHeap.size() > 0) {
            ans[index] = minHeap.peek().getValue();
            minHeap.poll();
            index++;
        }
        return ans;
    }
}
