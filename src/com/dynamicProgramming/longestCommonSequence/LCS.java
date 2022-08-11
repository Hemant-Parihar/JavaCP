package com.dynamicProgramming.longestCommonSequence;

public class LCS {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int[][] memo = new int[str1.length()][str2.length()];
        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(longestCommonSequence(str1, str2, str1.length() - 1, str2.length() - 1, memo));
    }

    private static int longestCommonSequence(String str1, String str2, int n, int m, int[][] memo) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        int processed = 0, unprocessed = 0;
        if (str1.charAt(n) == str2.charAt(m)) {
            processed = 1 + longestCommonSequence(str1, str2, n - 1, m - 1, memo);
        } else {
            unprocessed = Math.max(longestCommonSequence(str1, str2, n - 1, m, memo), longestCommonSequence(str1, str2, n, m - 1, memo));
        }
        memo[n][m] =  Math.max(processed, unprocessed);
        return memo[n][m];
    }
}
