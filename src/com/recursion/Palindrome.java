package com.recursion;

public class Palindrome {
    public static void main(String[] args) {
        String str = "bababab";
        System.out.println(isPalindrome(str, 0, str.length()));
    }

    private static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if ( str.indexOf(start) != str.indexOf(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}
