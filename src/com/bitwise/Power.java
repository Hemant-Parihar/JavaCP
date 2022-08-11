package com.bitwise;

// Find b^a
public class Power {
    public static void main(String[] args) {
        int base = 2;
        int pow = 4;
        int ans = 1;
        while(pow > 0) {
            if ((pow&1) == 1) {
                ans *= base;
            }
            pow = pow >> 1;
            base = base * base;
        }
        System.out.println(ans);
    }
    // Interesting thing here is that, Time complexity is log(pow).
    // If we keep multiply base, pow times, then time complexity is pow.
    // Therefore, this solution is optimized.
}
