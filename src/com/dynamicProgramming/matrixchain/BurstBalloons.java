package com.dynamicProgramming.matrixchain;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, nums.length - 1, nums, dp);
    }

    private static int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        int temp;
        if (i == j) {
            temp = nums[i];
            if (i + 1 < nums.length) {
                temp *= nums[i + 1];
            }
            if (i - 1 >= 0) {
                temp *= nums[i-1];
            }
            return temp;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;
        int temp_ans;

        for(int k = i; k <= j; k++) {
            temp_ans = nums[k];

            if (i - 1 >= 0) {
                temp_ans *= nums[i-1];
            }

            if (j + 1 < nums.length) {
                temp_ans *= nums[j+1];
            }


            temp_ans += solve(i, k - 1, nums, dp) + solve(k+1, j, nums, dp);
            ans = Math.max(ans, temp_ans);
        }
        dp[i][j] = ans;
        return ans;
    }
}
