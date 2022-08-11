package com.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombination {
    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        List<String> data = new ArrayList<>(8);
        data.add("abc");
        data.add("def");
        data.add("ghi");
        data.add("jkl");
        data.add("mno");
        data.add("pqrs");
        data.add("tuv");
        data.add("wxyz");
        subSet(data, ans, "", digits);
        return ans;
    }

    private static void subSet(List<String> data, List<String> ans, String processed, String digits) {
        if (digits.isEmpty()) {
            ans.add(processed);
            return;
        }
        int index = (digits.charAt(0) - '0') - 2;
        int n = data.get(index).length();
        for(int i = 0; i < n; i++) {
            subSet(data, ans, processed + data.get(index).charAt(i), digits.substring(1));
        }
    }
}
