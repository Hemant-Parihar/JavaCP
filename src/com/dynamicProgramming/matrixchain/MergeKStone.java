package com.dynamicProgramming.matrixchain;

import java.util.ArrayList;

public class MergeKStone {
    public static void main(String[] args) {
        int[] stones = {3,2,4,1};
        System.out.println(mergeStones(stones, 2));
    }

    static ArrayList<Integer> prefixSum = new ArrayList<>();

    public static int mergeStones(int[] stones, int k) {
        prefixSum.add(0);
        for(int i = 1; i <= stones.length; i++) {
            prefixSum.add(prefixSum.get(i-1) + stones[i - 1]);
        }
        return solve( stones, k, 0, stones.length - 1);
    }

    static int solve(int[] stones, int k, int i, int j) {
        int n = j - i + 1;
        if (k != 2 && (n % (k - 1) != 1) ) return -1;

        if (i > j) return -1;
        if (i == j) return 0;
        if (j - i + 1 < k) return -1;
        if (j - i + 1 == k) {
            return prefixSum.get(j+1) - prefixSum.get(i);
        }

        int left, right, temp_ans;
        int ans = Integer.MAX_VALUE;
        for(int itr = i+1; itr <= j - (k-2); itr++) {
            left = solve(stones, k, i, itr - 1);
            if (left != -1) {
                right = solve(stones, k, itr + (k-2), j);
                if (right != -1) {
                    temp_ans = 2*right + 2*left + (prefixSum.get(itr + (k-2) + 1) - prefixSum.get(itr + 1) );
                    ans = Math.min(ans, temp_ans);
                }
            }
        }
        return ans;
    }
}
