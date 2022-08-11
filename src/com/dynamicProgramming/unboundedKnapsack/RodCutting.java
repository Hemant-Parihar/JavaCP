package com.dynamicProgramming.unboundedKnapsack;

//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
public class RodCutting {
    public static void main(String[] args) {
        int[] prices =  {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRod(prices, n));
    }

    public static int cutRod(int price[], int n) {
        int size = n;
        int[][] memo = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return rodCutRec(price, n, size, memo);
    }

    private static int rodCutRec(int[] price, int n, int rodSize, int[][] memo) {
        if (n == 0 || rodSize <= 0) {
            // we are left with no more processing of element.
            return 0;
        }

        if (memo[n][rodSize] != -1) {
            return memo[n][rodSize];
        }

        int processed = 0, unprocessed = 0;
        if (n <= rodSize) {
            processed += price[n-1] + rodCutRec(price, n, rodSize - n, memo);
        }
        unprocessed = rodCutRec(price, n - 1, rodSize, memo);
        memo[n][rodSize] = Math.max(processed, unprocessed);
        return memo[n][rodSize];
    }
}
