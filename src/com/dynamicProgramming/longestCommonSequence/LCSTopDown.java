package com.dynamicProgramming.longestCommonSequence;

public class LCSTopDown {
    public static void main(String[] args) {
        String str1 = "hemant";
        String str2 = "parihar";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 0; i < str1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < str2.length(); i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

    }
}
