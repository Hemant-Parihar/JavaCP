package com.dynamicProgramming.longestCommonSequence;

public class LongestCommonString {
    public static void main(String[] args) {
        String str1 = "KXCGMTMVVGFQQWSPD";
        String str2 = "JXZADDUKVLQPKUZJZHWSUTPCAFSYAIBJHAMMEGWBTPQELRNKBLDXGUZGCSEC";
        // The question is asking for the longest common string.
        // But we are going to find the longest common suffix.
        // This will also be the ans for the longest common string.
        System.out.println(longestCommonSequence(str1, str2, str1.length() - 1, str2.length() - 1, 0));
    }

    private static int longestCommonSequence(String str1, String str2, int n, int m, int count) {
        // Key to write this recussion is that whatever the ans we have found till now, will not be passed to recursive if character are different.
        // This should be the case to find the Longest common suffix.

        // In case of longest common sequence, whatever the ans you have find till now, will be valid even the character are different.
        if (n < 0 || m < 0) {
            return count;
        }

        int processed = 0; int unprocessed = 0;
        if (str1.charAt(n) == str2.charAt(m)) {
            processed = longestCommonSequence(str1, str2, n - 1, m - 1, count + 1);
        } else {
            processed = count;
            unprocessed = Math.max(longestCommonSequence(str1, str2, n - 1, m, 0), longestCommonSequence(str1, str2, n, m - 1, 0));
        }
        return Math.max(processed, unprocessed);
    }
}
