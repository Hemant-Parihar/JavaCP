package com.bitwise;

// Given the number N, find the set bit in it.
public class CountSetBIt {
    public static void main(String[] args) {
        int num = 119;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(setBitFromLSB(num));
        System.out.println(setBitFromMSB(num));
    }

    private static int setBitFromMSB(int num) {
        int count = 0;
        while(num > 0) {
            num = num & (num -1);
            count++;
        }
        return count;
    }

    private static int setBitFromLSB(int num) {
        int count = 0;
        while (num > 0) {
            num = num - (num & -num);
            count++;
        }
        return count;
    }
}
