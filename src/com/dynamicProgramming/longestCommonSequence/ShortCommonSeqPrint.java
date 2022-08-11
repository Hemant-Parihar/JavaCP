package com.dynamicProgramming.longestCommonSequence;

import java.util.HashSet;
import java.util.Set;

public class ShortCommonSeqPrint {
    public static void main(String[] args) {
        String str1 = "accabcba";
        String str2 = "aacbbbbbaa";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        System.out.println(lcs(str1, str2, str1.length(), str2.length(), dp));
        String lcs = lcsPrint(str1, str2, str1.length(), str2.length(), dp);
        System.out.println(lcs);
    }

    private static int lcs(String str1, String str2, int n, int m, int[][] dp) {
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
        return dp[str1.length()][str2.length()];
    }

    private static String lcsPrint(String str1, String str2, int n, int m, int[][] dp) {
        StringBuilder ans2 = new StringBuilder();
        while(n > 0 && m > 0) {
            if (str1.charAt(n-1) == str2.charAt(m-1)) {
                ans2.append(str1.charAt(n-1));
                n--;
                m--;
            } else {
                if (dp[n-1][m] > dp[n][m-1]) {
                    ans2.append(str1.charAt(n-1));
                    n--;
                } else {
                    ans2.append(str2.charAt(m-1));
                    m--;
                }
            }
        }
        while (n > 0) {
            ans2.append(str1.charAt(n-1));
            n--;
        }

        while(m > 0) {
            ans2.append(str2.charAt(m-1));
            m--;
        }

        ans2.reverse();
        return ans2.toString();
    }
}
