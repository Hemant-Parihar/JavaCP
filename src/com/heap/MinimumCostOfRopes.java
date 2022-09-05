package com.heap;

import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class MinimumCostOfRopes {
    public static void main(String[] args) {

    }

    long minCost(long arr[], int n)
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
        }
        long ans = 0; long rope1, rope2;
        while(minHeap.size() > 1) {
            rope1 = minHeap.poll();
            rope2 = minHeap.poll();
            minHeap.add(rope1 + rope2);
            ans += rope1 + rope2;
        }
        return ans;
    }
}
