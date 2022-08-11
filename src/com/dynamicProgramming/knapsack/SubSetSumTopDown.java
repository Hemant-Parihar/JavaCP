package com.dynamicProgramming.knapsack;

public class SubSetSumTopDown {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean[][] memo = new boolean[arr.length+1][sum+1];

        for(int i = 0; i < memo.length; i++) {
            memo[i][0] = true;
        }
        for(int i = 1; i < memo[0].length; i++) {
            memo[0][i] = false;
        }

        for(int i = 1; i < memo.length; i++) {
            for(int j = 1; j < memo[0].length; j++) {
                if (arr[i-1] <= j) {
                    // we are considering this element.
                    memo[i][j] = memo[i-1][j - arr[i-1]] || memo[i-1][j];
                } else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        System.out.println(memo[arr.length][sum]);
    }
}
