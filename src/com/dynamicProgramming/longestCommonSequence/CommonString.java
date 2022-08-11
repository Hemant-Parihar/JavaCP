package com.dynamicProgramming.longestCommonSequence;

public class CommonString {
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "ababac";
        int max = 0, globalMax = 0;
        for(int i = 0; i < str1.length(); i++) {
            int tempi = i;
            max = 0;
            for(int j = 0; j < str2.length(); j++) {
                if (tempi < str1.length() && str1.charAt(tempi) == str2.charAt(j)) {
                    max++;
                    tempi++;
                } else {
                    tempi = i;
                    globalMax = Math.max(globalMax, max);
                    max = 0;
                }
            }
        }
        System.out.println(globalMax);
    }
    // This will not work. As we see their is a problem in this solution.
}
