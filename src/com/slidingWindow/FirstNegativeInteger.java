package com.slidingWindow;

import java.util.Arrays;

public class FirstNegativeInteger {
    public static void main(String[] args) {
        long[] A = {-8, 2, 3, -6, 10};
        int N = 5, K = 2;
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, N, K)));
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] window = new long[N-K+1];
        int win_index = 0;
        for(int i = 0, j = K-1; i <= j & j < N; ) {
            if (A[i] < 0) {
                window[win_index++] = A[i];
                j++;
                if (j - i + 1 > K) {
                    i++;
                }
            } else if (i == j) {
                window[win_index++] = 0;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return window;
    }
}
