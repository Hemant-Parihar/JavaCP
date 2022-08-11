package com.dynamicProgramming.knapsack;

public class EqualParitionSubSetSumTopDown {
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
        int sum = totalSum / 2;
        boolean[][] memo = new boolean[nums.length+1][sum+1];

        for(int i = 0; i < memo.length; i++) {
            memo[i][0] = true;
        }
        for(int i = 1; i < memo[0].length; i++) {
            memo[0][i] = false;
        }

        for(int i = 1; i < memo.length; i++) {
            for(int j = 1; j < memo[0].length; j++) {
                if (nums[i-1] <= j) {
                    // we are considering this element.
                    memo[i][j] = memo[i-1][j - nums[i-1]] || memo[i-1][j];
                } else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[nums.length][sum];
    }
}
