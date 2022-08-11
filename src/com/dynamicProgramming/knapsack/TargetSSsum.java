package com.dynamicProgramming.knapsack;

//https://leetcode.com/problems/target-sum/
public class TargetSSsum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
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
        return partition(nums.length - 1, nums, 0, totalSum, target, memo);
    }

    private static int partition(int n, int[] nums, int proSum, int totalSum, int target, int [][] memo) {
        if (n == -1) {
            // here we have processed each and every element.
            if ( (proSum - (totalSum - proSum)) == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[n][proSum] != -1) {
            return memo[n][proSum];
        }
        int count = 0;
        count += partition(n - 1, nums, proSum + nums[n], totalSum, target, memo);
        count += partition(n - 1, nums, proSum, totalSum, target, memo);

        memo[n][proSum] = count;
        return memo[n][proSum];
    }
}
