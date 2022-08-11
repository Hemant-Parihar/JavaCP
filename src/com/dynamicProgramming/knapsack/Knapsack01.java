package com.dynamicProgramming.knapsack;

import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Test cases.

        while(T-- > 0) {
            int W = in.nextInt(); // Total Capacity.
            int N = in.nextInt(); // no. of element.
            int[] weight = new int[N];
            int[] value = new int[N];
            int[][] memo = new int[N][W+1];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < W+1; j++) {
                    memo[i][j] = -1;
                }
            }

            for(int i = 0; i < N; i++) {
                weight[i] = in.nextInt();
                value[i] = in.nextInt();
            }
            System.out.println(knapSack(N-1, W, weight, value, memo));
        }
        in.close();
    }

    private static int knapSack(int n, int w, int[] weight, int[] value, int[][] memo) {
        if (n < 0 || w < 0) {
            return 0;
        }

        if (memo[n][w] != -1) {
            return memo[n][w];
        }

        int consider = 0, notConsider;
        if (weight[n] <= w) {
            consider = value[n] + knapSack(n - 1, w - weight[n], weight, value, memo);
        }
        notConsider = knapSack(n - 1, w, weight, value, memo);
        memo[n][w] = Math.max(consider, notConsider);
        return memo[n][w];
    }
}
