package com.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    Integer first;
    Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}

public class KFrequentElements2 {
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
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> (a.first - b.first));
        freqMap.forEach( (key, value) -> {
                    minHeap.add(new Pair(value, key));
                    if (minHeap.size() == k + 1) {
                        minHeap.poll();
                    }
                }
        );
        int[] ans = new int[k];
        int index = 0;
        while(minHeap.size() > 0) {
            ans[index] = minHeap.peek().second;
            minHeap.poll();
            index++;
        }
        return ans;
    }
}
