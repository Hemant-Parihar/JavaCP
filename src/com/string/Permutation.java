package com.string;

import java.util.ArrayList;

public class Permutation {

    private static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
//        permutation(str, "");
//        System.out.println(list);
        System.out.println(permutation2(str, ""));
    }

    private static void permutation(String unProcessed, String processed) {
        if (unProcessed.isEmpty()) {
            list.add(processed);
            return;
        }
        for(int i = 0; i < unProcessed.length(); i++) {
            String p = processed + unProcessed.charAt(i);
            String up = unProcessed.substring(0, i) + unProcessed.substring(i+1);
            permutation(up, p);
        }
    }

    private static ArrayList<String> permutation2(String unProcessed, String processed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(processed);
            return ans;
        }
        ArrayList<String> ansAll = new ArrayList<>();
        for(int i = 0; i < unProcessed.length(); i++) {
            String p = processed + unProcessed.charAt(i);
            String up = unProcessed.substring(0, i) + unProcessed.substring(i+1);
            ansAll.addAll(permutation2(up, p));
        }
        return ansAll;
    }
}
