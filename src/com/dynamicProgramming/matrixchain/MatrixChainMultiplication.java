package com.dynamicProgramming.matrixchain;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        int[][] dp = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(matrixMul(1, arr.length - 1, arr, dp));
    }

    private static int matrixMul(int i, int j, int[] arr, int[][] dp) {
        if (i >= j) return 0;
        if (i + 1 == j) return arr[i-1] * arr[i] * arr[i+1];

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int cost = Integer.MAX_VALUE;
        int temp;
        for(int k = i; k < j; k++) {
            temp = arr[i-1]*arr[k]*arr[j] + matrixMul(i, k, arr, dp) + matrixMul(k + 1, j, arr, dp);
            cost = Math.min(cost, temp);
        }
        dp[i][j] = cost;
        return dp[i][j];
    }
}
