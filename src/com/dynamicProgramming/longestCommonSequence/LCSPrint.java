package com.dynamicProgramming.longestCommonSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LCSPrint {

    private final static String str1 = "ABCBDAB";
    private final static  String str2 = "BDCABA";
    private static int[][] dp = new int[str1.length() + 1][str2.length() + 1];

    Set<String> set = new HashSet<>();
    HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(longestCommonSequence(str1.length(), str2.length()));
        System.out.println(lcsPrint(str1.length(), str2.length()).toString());
    }

    private static int longestCommonSequence(int n, int m) {
        for(int i = 0; i <= str1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= str2.length(); i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    private static Set<String> lcsPrint(int n, int m) {
        Set<String> s = new HashSet<>();
        if (n == 0 || m == 0) {
            s.add("");
            return s;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            Set<String> temp = lcsPrint(n - 1, m - 1);
            for(String str : temp) {
                s.add(str + str1.charAt(n-1));
            }
        } else {
            if (dp[n-1][m] >= dp[n][m-1]) {
                // we are going up.
                s.addAll(lcsPrint(n - 1, m));
            }

            if (dp[n-1][m] <= dp[n][m-1]) {
                // we are going left.
                s.addAll(lcsPrint(n, m - 1));
                // Note the both are equal means we are getting multiple ans.
            }
        }
        return s;
    }
}
