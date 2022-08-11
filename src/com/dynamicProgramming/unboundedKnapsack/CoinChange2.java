package com.dynamicProgramming.unboundedKnapsack;

public class CoinChange2 {
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
        return ans;
    }

    private static int coinChangeRec(int n, int[] coins, int amount, int[][] memo) {
        if (amount == 0) return 1;
        if (n == -1) return 0;

        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }

        int count = 0;
        if (coins[n] <= amount) {
            count += coinChangeRec(n, coins, amount - coins[n], memo);
        }
        count += coinChangeRec(n - 1, coins, amount, memo);
        memo[n][amount] = count;
        return memo[n][amount];
    }
}
