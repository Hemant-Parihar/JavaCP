package com.dynamicProgramming.longestCommonSequence;

public class PrintAllSubstring {
    public static void main(String[] args) {
        String str = "abc";
        int len = 1;
        while (len <= str.length()) {
            // printing all the string of length len;
            for(int i = 0; i < str.length() - len + 1; i++) {
                System.out.print(str.substring(i, i + len) + " ");
            }
            System.out.println();
            len++;
        }
    }
}
