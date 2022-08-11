package com.bitwise;

public class Reset {
    public static void main(String[] args) {
        // Reset i^th bit.
        int num = 12;
        int i = 3;
        // If we and it with all 1's except 0 at the i^th bit.
        // We have resit it.
        // Now the question is how we can get all 1's expect at i^th bit.
        // compliment of 1 << (i - 1) will work.
        // How to take compliment of a number.
        // If we xor it with all 1's we will get compliment.

        int ans = num & (1 << (i - 1) ^ (Integer.MAX_VALUE));
        System.out.println(ans);
    }
}
