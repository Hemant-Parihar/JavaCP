package com.string;

//https://practice.geeksforgeeks.org/problems/implement-strstr/1
//https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class StrStr {
    public static void main(String[] args) {
        String search = "abad";
        String str = "ababad";
        System.out.println(strstr(str, search));
    }

    public static int strstr(String s, String x)
    {
        if (x.length() == 0) return -1;

        for(int i = 0; i < s.length(); i++) {
            int j = 0; int temp_i = i;
            while(j < x.length() && temp_i < s.length() && s.charAt(temp_i) == x.charAt(j)) {
                j++;
                temp_i++;
            }
            if (j == x.length()) {
                // means all element of the x are scaned.
                return i;
            }
        }
        return -1;
    }
}
