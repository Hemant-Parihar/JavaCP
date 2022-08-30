package com.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSubarray {

    public static void main(String[] args) {
        maximumSumSubarray(2, new ArrayList<Integer>(
                Arrays.asList(100, 200, 300, 400)
        ), 4);
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        // code here
        long sum = 0;
        for(int i = 0; i < K; i++) {
            sum += Arr.get(i);
        }
        long ans = sum;

        for(int i = 0, j = K; j < N; i++, j++) {
            sum += Arr.get(j);
            sum -= Arr.get(i);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
