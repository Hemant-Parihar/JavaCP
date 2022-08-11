package com.matrix;

//https://leetcode.com/problems/search-a-2d-matrix-ii/

// We need to search in the matrix for the target element, Matrix is row-wise and col-wise sorted.
public class Sorted {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int row = 0;
        while(n >= 0 && row <= m) {
            if (matrix[row][n] == target) {
                return true;
            } else if (matrix[row][n] > target) {
                n--;
            } else {
                row++;
            }
        }
        return false;
    }
}
