package com.dynamicProgramming.knapsack;

public class MinSSDiff {
    public static void main(String[] args) {
        int[] arr = {1, 4};
        System.out.println(canPartition(arr));
    }

    public static int canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int [][] memo = new int[nums.length][totalSum+1];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < totalSum + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return partition(nums.length - 1, nums, 0, totalSum, memo);
    }

    private static int partition(int n, int[] nums, int proSum, int totalSum, int[][] memo) {
        if (n == -1) {
            // here we have processed each and every element.
            return Math.abs((totalSum - proSum) - proSum);
        }

        if (memo[n][proSum] != -1) {
            return memo[n][proSum];
        }

        int processed, unProcessed;
        processed = partition(n - 1, nums, proSum + nums[n], totalSum, memo);
        unProcessed = partition(n - 1, nums, proSum, totalSum, memo);

        memo[n][proSum] = Math.min(processed, unProcessed);

        return memo[n][proSum];
    }
}
