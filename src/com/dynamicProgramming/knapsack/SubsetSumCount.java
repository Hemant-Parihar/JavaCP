package com.dynamicProgramming.knapsack;

public class SubsetSumCount {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int[][] memo = new int[arr.length+1][sum+1];

        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(subSetSum(arr, arr.length - 1, sum, memo));
    }

    private static int subSetSum(int[] arr, int n, int sum, int[][] memo) {
        if (sum == 0) {
            return 1;
        }
        if (n < 0) return 0;

        if (memo[n + 1][sum] != -1) {
            return memo[n+1][sum];
        }

        int count = 0;
        if (arr[n] <= sum) {
            count += subSetSum(arr, n - 1, sum - arr[n], memo);
        }
        count += subSetSum(arr, n - 1, sum, memo);

        memo[n+1][sum] = count;

        return memo[n+1][sum];
    }
}
