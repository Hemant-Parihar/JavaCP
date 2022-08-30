package com.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
public class Anagrams {
    public static void main(String[] args) {
        System.out.println(search("abc", "abaacbabc"));
    }

    static int search(String pat, String txt) {
        // code here
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int count = 0; int val;
        int k = pat.length();
        for ( int i = 0; i < k; i++ ) {
            if (!hashMap.containsKey(pat.charAt(i))) {
                hashMap.put(pat.charAt(i), 1);
                count++;
            } else {
                val = hashMap.get(pat.charAt(i));
                hashMap.put(pat.charAt(i), val + 1);
            }
        }

        int ans = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0, j = 0; j < txt.length(); j++) {
            char ch = txt.charAt(j);
            if (hashMap.containsKey(ch)) {
                val = hashMap.get(ch);
                hashMap.put(ch, val - 1);

                if (val - 1 == 0) {
                    count--;
                }
            }

            if (j - i + 1 == k) {
                if (count == 0) {
                    ans++;
                    list.add(i);
                }
                if (hashMap.containsKey(txt.charAt(i))) {
                    val = hashMap.get(txt.charAt(i));
                    hashMap.put(txt.charAt(i), val+1);
                    if (val + 1 == 1) {
                        count++;
                    }
                }
                i++;
            }
        }
        System.out.println(list);
        return ans;
    }
}
