package com.slidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        // Creating empty priority queue
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        for(int i = 0, j = 0; j < nums.length; j++) {
            if (!pQueue.isEmpty() && pQueue.peek() < nums[j]) {
                // In this case, all the element in pQueue are not worth at all.
                PriorityQueue<Integer> newpQueue
                        = new PriorityQueue<Integer>(
                        Collections.reverseOrder());
                newpQueue.add(nums[j]);
                pQueue = newpQueue;
            } else {
                pQueue.add(nums[j]);
            }
            if (j - i + 1 == k) {
                ans[i] = pQueue.peek();
                if (pQueue.size() == k) {
                    pQueue.remove(nums[i]);
                }
                i++;
            }
        }
        return ans;
    }
}
