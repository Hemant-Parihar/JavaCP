package com.dynamicProgramming.matrixchain;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/submissions/
public class PalindromePartioning {

    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(partition("bb"));
    }

    public static List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        dp(s, temp);
        return ans;
    }

    private static void dp(String s, List<String> temp) {
        if (s.length() == 1) {
            temp.add(s);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else if (s.length() == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                temp.add(s.substring(0, i + 1));
                dp(s.substring(i+1), temp);
                temp.remove(temp.size() - 1);
            }
        }
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
