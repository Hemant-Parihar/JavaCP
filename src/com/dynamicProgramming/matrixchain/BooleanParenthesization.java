package com.dynamicProgramming.matrixchain;

//https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
public class BooleanParenthesization {

    public static void main(String[] args) {
        System.out.println(countWays(5, "T^F|F"));
    }

    static int countWays(int N, String S){
        // code here
        int[][][] dp = new int[N][N][2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(S, 0, N - 1, true, dp);
    }

    static int solve(String str, int i, int j, boolean eval, int[][][] dp) {
        if (i == j) {
            if ( (str.charAt(i) == 'T' && eval == true) || (str.charAt(i) == 'F' && eval == false) ) {
                return 1;
            } else {
                return 0;
            }
        }

        if (i > j) return 0;

        int temp = eval?1:0;

        if (dp[i][j][temp] != -1) {
            return dp[i][j][0];
        }

        int count = 0;
        int temp_count = 0;

        for(int k = i + 1; k < j; k += 2) {
            temp_count = 0;
            int left_true = solve(str, i, k - 1, true, dp);
            int left_false = solve(str, i, k - 1, false, dp);
            int right_true = solve(str, k + 1, j, true, dp);
            int right_false = solve(str, k + 1, j, false, dp);

            if (eval == true) {
                if (str.charAt(k) == '&') {
                    temp_count += left_true * right_true;
                } else if (str.charAt(k) == '|') {
                    temp_count += left_true * right_true;
                    temp_count += left_true * right_false;
                    temp_count += left_false * right_true;
                } else if (str.charAt(k) == '^') {
                    temp_count = left_true * right_false;
                    temp_count += left_false * right_true;
                }
            } else {
                if (str.charAt(k) == '&') {
                    temp_count += left_true * right_false;
                    temp_count += left_false * right_true;
                    temp_count += left_false * right_false;
                } else if (str.charAt(k) == '|') {
                    temp_count += left_false * right_false;
                } else if (str.charAt(k) == '^') {
                    temp_count += left_true * right_true;
                    temp_count += left_false * right_false;
                }
            }
            count += temp_count;
        }
        dp[i][j][temp] = count;
        return count;
    }
}
