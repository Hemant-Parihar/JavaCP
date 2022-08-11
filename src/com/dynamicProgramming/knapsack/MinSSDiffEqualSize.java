package com.dynamicProgramming.knapsack;

//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
public class MinSSDiffEqualSize {
    public static void main(String[] args) {
        int[] arr = {2,-1,0,4,-2,-9};
        System.out.println(canPartition(arr));
    }

    public static int canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

//        int [][] memo = new int[nums.length][totalSum+1];
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = 0; j < totalSum + 1; j++) {
//                memo[i][j] = -1;
//            }
//        }
        return partition(nums.length - 1, nums, 0, totalSum, 0);
    }

    private static int partition(int n, int[] nums, int proSum, int totalSum, int s1) {
        if (n == -1 && s1 == nums.length / 2) {
            // here we have processed each and every element.
            return Math.abs((totalSum - proSum) - proSum);
        }
        if (n == -1) {
            return Integer.MAX_VALUE;
        }

//        if (memo[n][proSum] != -1) {
//            return memo[n][proSum];
//        }

        int processed = Integer.MAX_VALUE, unProcessed;
        if (s1 < nums.length / 2) {
            processed = partition(n - 1, nums, proSum + nums[n], totalSum, s1 + 1);
        }

        unProcessed = partition(n - 1, nums, proSum, totalSum, s1);

//        memo[n][proSum] = Math.min(processed, unProcessed);

        return Math.min(processed, unProcessed);
    }
}
