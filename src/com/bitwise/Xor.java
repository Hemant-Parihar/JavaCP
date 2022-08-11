package com.bitwise;

public class Xor {
    public static void main(String[] args) {
        int num = 3;
        for(int i = num+1; i < 20; i++) {
            System.out.println(i + "=" + (num^i));
            num = num^i;
        }
        int N = 9;
        System.out.println("Ans for " + N);
        System.out.println(xorToNfromO(N) ^ xorToNfromO(num-1));
    }

    static int xorToNfromO(int num) {
        if (num % 4 == 0) {
            return num;
        } else if (num % 4 == 1) {
            return 1;
        } else if (num % 4 == 2) {
            return num + 1;
        } else {
            return 0;
        }
    }
}
