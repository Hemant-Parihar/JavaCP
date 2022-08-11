package com.dynamicProgramming.knapsack;

import java.util.Scanner;

public class KnapSackTopDown {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Test cases.

        while(T-- > 0) {
            int W = in.nextInt(); // Total Capacity.
            int N = in.nextInt(); // no. of element.
            int[] weight = new int[N];
            int[] value = new int[N];
            int[][] memo = new int[N + 1][W+1];

            for(int i = 0; i < N; i++) {
                weight[i] = in.nextInt();
                value[i] = in.nextInt();
            }
            System.out.println(knapSack(weight, value, memo));
        }
        in.close();
    }

    private static int knapSack(int[] weight, int[] value, int[][] memo) {
        int W = memo[0].length - 1;
        int N = memo.length - 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= W; j++) {
                if (weight[i-1] <= j) {
                    memo[i][j] = Math.max(value[i-1] + memo[i-1][j - weight[i-1]], memo[i-1][j]);
                } else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[N][W];
    }
}
