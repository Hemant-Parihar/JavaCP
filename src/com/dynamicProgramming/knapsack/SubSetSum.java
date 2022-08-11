package com.dynamicProgramming.knapsack;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int[][] memo = new int[arr.length+1][sum+1];

        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(subSetSum(arr, arr.length - 1, sum, memo));
    }

    private static boolean subSetSum(int[] arr, int n, int sum, int[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (n < 0) return false;

        if (memo[n + 1][sum] != -1) {
            if (memo[n+1][sum] == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean processed = false, unProcessed = false;
        if (arr[n] <= sum) {
            processed = subSetSum(arr, n - 1, sum - arr[n], memo);
        }
        if (!processed) {
            unProcessed = subSetSum(arr, n - 1, sum, memo);
        }

        if (processed || unProcessed) {
            memo[n+1][sum] = 1;
        } else {
            memo[n+1][sum] = 0;
        }

        return (processed || unProcessed);
    }
}
