package com.dynamicProgramming.matrixchain;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartioning2 {

    public static void main(String[] args) {
        System.out.println(partition("abcdef"));
    }

    public static int partition(String s) {
        int[] memo = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            memo[i] = -1;
        }
        return dp(0, s.length() - 1, s, memo);
    }

    private static int dp(int i, int j, String s, int[] memo) {
        if (i == j) {
            return 0;
        }

        if (isPalindrome(s.substring(i, j+1))) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int ans = s.length();
        int temp_ans;
        for(int k = i; k < s.length(); k++) {
            if (isPalindrome(s.substring(i, k + 1))) {
                if (k == j) {
                    temp_ans = 0;
                } else {
                    temp_ans = 1 + dp(k+1, j, s, memo);
                }
                ans = Math.min(ans, temp_ans);
            }
        }
        memo[i] = ans;
        return ans;
    }

    private static boolean isPalindrome(String substring) {
        for(int i = 0, j = substring.length() - 1; i < j; i++, j--) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
