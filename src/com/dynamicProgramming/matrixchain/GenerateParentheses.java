package com.dynamicProgramming.matrixchain;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(AllParenthesis(6));
    }

    public static List<String> AllParenthesis(int n)
    {
        // Write your code here
        generateParenthesis(n, 0, 0, "");
        return ans;
    }

    private static void generateParenthesis(int n, int left, int right, String str) {
        if (right > left) return;
        if (str.length() == n) {
            if (left == right) {
                ans.add(new String(str));
            }
            return;
        }

        generateParenthesis(n, left + 1, right, str + "(");
        generateParenthesis(n, left, right + 1, str + ")");
    }
}
