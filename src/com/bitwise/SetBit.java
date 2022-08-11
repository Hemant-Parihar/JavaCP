package com.bitwise;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/single-number-ii/
public class SetBit {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        int[] add = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                // At this point, I will add all the i's bit.
                add[i] = add[i] + (nums[j] % 2);
                nums[j] = nums[j] >> 2;
            }
        }
        int ans = 0; int pow = 1;
        for(int i = 0; i < 32; i++) {
            System.out.println(add[i] + " ");
            ans += (add[i] % 3) * pow;
            pow *= 2;
        }
        System.out.println(ans);
    }
}
