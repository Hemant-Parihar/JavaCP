package com.recursion;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class DiceRoll {

    public static HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        return fun(n, k, target, 0);
    }

    public static int fun(int n, int k, int target, int sum) {
        if (n == 0 && target == sum) {
            return 1;
        }
        if (sum > target || n <= 0) {
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= k; i++) {
            if (sum + i > target) {
                break;
            }
            Pair<Integer, Integer> pair = new Pair<>(n -1, sum + i);
            if (!map.containsKey(pair)) {
                map.put(pair, fun(n - 1, k, target, sum + i) % (int)(Math.pow(10, 9) + 7));
            }
            count = (count + map.get(pair)) % (int)(Math.pow(10, 9) + 7);
        }
        return count;
    }
}
