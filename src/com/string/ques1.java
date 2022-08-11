package com.string;

public class ques1 {
    public static void main(String[] args) {
        // When the string remove all the occurence of a.
        String str = "abc";
//        System.out.println(removeAlla(str));
        System.out.println(removeAllaRecursive(str, 0, new StringBuilder()));
    }

    private static String removeAlla(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'a') {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    private static String removeAllaRecursive(String str, int currIndex, StringBuilder builder) {
        if (str == null || str.length() == 0 || currIndex >= str.length()) {
            return builder.toString();
        }
        if (str.charAt(currIndex) != 'a') {
            builder.append(str.charAt(currIndex));
        }
        return removeAllaRecursive(str, currIndex + 1, builder);
    }
}
