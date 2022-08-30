package com.slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum2 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0, j = 0; j < nums.length; j++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.add(nums[j]);
            if (j - i + 1 == k) {
                ans[i] = deque.peek();
                if (deque.size() == k) {
                    deque.poll();
                }
                i++;
            }
        }
        return ans;
    }
}
