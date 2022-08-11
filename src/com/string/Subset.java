package com.string;

import java.util.ArrayList;

public class Subset {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
//        String name = "abc";
//        allSubSet(name, "");
//        System.out.println(allSubSet2(name, ""));
        ArrayList<Integer> num = new ArrayList<>();
        int len = 3;
        for(int i = 1; i <= len; i++) {
            num.add(i);
        }
        System.out.println(allSubSetIter(num));
    }

    private static void allSubSet(String name, String str) {
        if (name.isEmpty())  {
            list.add(str);
            return;
        }
        allSubSet(name.substring(1), str + name.charAt(0));
        allSubSet(name.substring(1), str);
    }

    private static ArrayList<String> allSubSet2(String name, String str) {
        if (name.isEmpty())  {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        ArrayList<String> array1 = allSubSet2(name.substring(1), str + name.charAt(0));
        ArrayList<String> array2 = allSubSet2(name.substring(1), str);
        array1.addAll(array2);
        return array1;
    }

    private static ArrayList<ArrayList<Integer>> allSubSetIter(ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for(int i  = 0; i < num.size(); i++) {
            int ele = num.get(i);
            int n = outerList.size();
            for(int j = 0; j < n; j++) {
                ArrayList<Integer> getElement = new ArrayList<>();
                getElement.addAll(outerList.get(j));
                getElement.add(ele);
                outerList.add(getElement);
            }
        }
        return outerList;
    }

}
