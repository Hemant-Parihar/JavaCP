package com.dynamicProgramming.knapsack;

public class EqualPartitionSubSetSum2 {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if ((totalSum & 1) == 1) return false;

        int [][] memo = new int[nums.length][totalSum+1];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < totalSum + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return partition(nums.length - 1, nums, 0, totalSum, memo);
    }

    private static boolean partition(int n, int[] nums, int proSum, int totalSum, int[][] memo) {
        if (n == -1) {
            // here we have processed each and every element.
            return (proSum == totalSum - proSum);
        }

        if (memo[n][proSum] != -1) {
            if (memo[n][proSum] == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean processed = false, unProcessed;
        if (2 * (proSum + nums[n]) <= totalSum) {
            processed = partition(n - 1, nums, proSum + nums[n], totalSum, memo);
        }
        unProcessed = partition(n - 1, nums, proSum, totalSum, memo);

        if (processed || unProcessed) {
            memo[n][proSum] = 1;
        } else {
            memo[n][proSum] = 0;
        }

        return processed || unProcessed;
    }
}
