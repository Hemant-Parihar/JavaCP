package com.recursion;

// Reverse a number.
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(123, 0));
    }

    private static int reverse(int num, int ans) {
        if (num == 0) {
            return ans;
        }
        ans = 10*ans + (num % 10);
        return reverse(num / 10, ans);
    }
}
