package com.dynamicProgramming.longestCommonSequence;

public class LPS {
    public static void main(String[] args) {
        String str = "bbbab";
        String str2 = reverse(str);
        System.out.println(LCS(str.length(), str2.length(), str, str2));
    }

    private static String reverse(String str) {
        StringBuilder strR = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            strR.append(str.charAt(i));
        }
        return strR.toString();
    }

    private static int LCS(int n, int m, String word1, String word2) {
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
