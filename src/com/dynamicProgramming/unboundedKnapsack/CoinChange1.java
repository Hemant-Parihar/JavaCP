package com.dynamicProgramming.unboundedKnapsack;

//https://leetcode.com/problems/coin-change/
public class CoinChange1 {
    public static void main(String[] args) {
        int[] coins =  {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[][] memo = new int[coins.length][amount+1];
        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        int ans = coinChangeRec(coins.length - 1, coins, amount, memo);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private static int coinChangeRec(int n, int[] coins, int amount, int[][] memo) {
        if (amount == 0) return 0;
        if (n == -1) return Integer.MAX_VALUE;

        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }

        int processed = Integer.MAX_VALUE, unprocessed;
        if (coins[n] <= amount) {
            processed = Math.min(processed, (1 + coinChangeRec(n, coins, amount - coins[n], memo)) % Integer.MAX_VALUE);
        }
        unprocessed = coinChangeRec(n - 1, coins, amount, memo);
        memo[n][amount] = Math.min(processed, unprocessed);
        return memo[n][amount];
    }
}
