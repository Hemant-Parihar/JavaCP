package com.dynamicProgramming.knapsack;

public class EqualPartitionSubSetSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        boolean[] board = new boolean[nums.length];
        for(int i = 0; i < board.length; i++) {
            board[i] = false;
        }
        return partition(nums.length - 1, nums, board);
    }

    private static boolean partition(int n, int[] nums, boolean[] board) {
        if (n == -1) {
            // here we have processed each and every element.
            int proSum, unProSum;
            proSum = unProSum = 0;
            for(int i = 0; i < board.length; i++) {
                if (board[i] == true) {
                    proSum += nums[i];
                } else {
                    unProSum += nums[i];
                }
            }
            return (proSum == unProSum);
        }
        boolean processed, unProcessed;
        board[n] = true;
        processed = partition(n - 1, nums, board);
        board[n] = false;
        unProcessed = partition(n - 1, nums, board);
        return processed || unProcessed;
    }
}
