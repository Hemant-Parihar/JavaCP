package com.heap;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

/*
    Find the Kth largest element in the heap.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
//        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKLargestInSortedOrder(nums, 2));
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() == k + 1) {
                // It means this top element of heap is greater than k element.
                // We need Kth largest element. This top element can never be kth largest element.
                minHeap.poll();
            }
        }
        // At this point, you have heap of size K. You have removed (n - k) element.
        // All of these (n-k) element are minimum then these k element.
        return minHeap.peek();
    }

    public static int[] findKLargestInSortedOrder(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
        Arrays.sort(ans);
        for(int i = 0; i < ans.length / 2; i++) {
            int j = ans.length - i - 1;
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
        }
        return ans;
    }
}
