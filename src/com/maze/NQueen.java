package com.maze;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        System.out.println(solveNQueens(5).toString());
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[][] maze = new int[n][n];
        findAns(n, maze, 0, 0, list);
        return list;
    }

    private static void findAns(int n, int[][] maze, int row, int col, List<List<String>> list) {

        int size = maze.length;
        if (n == 0) {
            // We have found the ans, we have successfully placed all the queens.
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                StringBuilder strBuilder = new StringBuilder();
                for(int j = 0; j < size; j++) {
                    if (maze[i][j] == 0) {
                        strBuilder.append(".");
                    } else {
                        strBuilder.append("Q");
                    }
                }
                ans.add(strBuilder.toString());
            }
            list.add(ans);
            return;
        }

        if (row > (size - n) || row >= size || col >= size) {
            return;
        }

        // Q. Can we place the queen at this row and col?
        // To Place the queen, we need to check whether it is conflicting with the other queen or not.
        // We need 3 check, check vertically, check left diagonal, check right diagonal.

        int rowV = row-1;
        boolean checkV = true;
        while(rowV >= 0) {
            if (maze[rowV][col] == 1) {
                checkV = false;
                break;
            }
            rowV--;
        }

        int colL = col-1;
        rowV = row-1;
        boolean checkLD = true;
        while(colL >= 0 && rowV >= 0) {
            if (maze[rowV][colL] == 1) {
                checkLD = false;
                break;
            }
            colL--;
            rowV--;
        }

        int colR = col + 1;
        rowV = row - 1;
        boolean checkRD = true;
        while(colR < size && rowV >= 0) {
            if (maze[rowV][colR] == 1) {
                checkRD = false;
                break;
            }
            colR++;
            rowV--;
        }

        if (!checkV || !checkRD || !checkLD) {
            if (col != size - 1) {
                findAns(n, maze, row, col+1, list);
            }
            return;
        }

        // Now at this point we have pass all the check. We can place the queen.
        maze[row][col] = 1;

        findAns(n - 1, maze, row+1, 0, list);

        // We are returning back.
        maze[row][col] = 0;

        if (col + 1 < size) {
            findAns(n, maze, row, col + 1, list);
        }

        return;
    }
}
