package com.string;

import java.util.ArrayList;

public class Substring {
    public static void main(String[] args) {
        String name = "hemant";
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        allSubString(name, list);
        System.out.println(list);
    }

    private static void allSubString(String name, ArrayList<ArrayList<String>> list) {
        // we need to put all the subset of the string name.
        int len = 0;
        int n = name.length();
        while(len <= n) {
            len++;
            ArrayList<String> newList = new ArrayList<>();
            for(int i = 0; i < n - len + 1; i++) {
                newList.add(name.substring(i, i + len));
            }
            list.add(newList);
        }
    }
}
