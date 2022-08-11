package com.maze;

import java.util.ArrayList;
import java.util.List;

public class NKnight {
    public static void main(String[] args) {
        System.out.println(solveNKnight(4).toString());
    }

    public static List<List<String>> solveNKnight(int n) {
        List<List<String>> list = new ArrayList<>();
        int[][] maze = new int[n][n];
        System.out.println(findAns(n, maze, 0, 0, list));
        return list;
    }

    private static int findAns(int n, int[][] maze, int row, int col, List<List<String>> list) {

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
                        strBuilder.append("N");
                    }
                }
                ans.add(strBuilder.toString());
            }
            list.add(ans);
            return 1;
        }

        int count = 0;

        // Q. Can we place the queen at this row and col?
        // To Place the queen, we need to check whether it is conflicting with the other queen or not.
        // We need 3 check, check vertically, check left diagonal, check right diagonal.

        if(canPlace(maze, row, col)) {
            maze[row][col] = 1;
            if (col + 1 < size) {
                count += findAns(n - 1, maze, row, col + 1, list);
            } else if (row + 1 < size) {
                count += findAns(n - 1, maze, row + 1, 0, list);
            }
            maze[row][col] = 0;
        }

        if (col + 1 < size) {
            count += findAns(n, maze, row, col + 1, list);
        } else if (row + 1 < size) {
            count += findAns(n, maze, row + 1, 0, list);
        }

        return count;
    }

    private static boolean canPlace(int[][] maze, int row, int col) {
        int size = maze.length;
        if (row - 2 >= 0) {
            if (col - 1 >= 0 && maze[row-2][col-1] == 1) {
                return false;
            }
            if (col + 1 < size && maze[row-2][col+1] == 1) {
                return false;
            }
        }
        if (col - 2 >= 0) {
            if (row - 1 >= 0 && maze[row-1][col-2] == 1) {
                return false;
            }
        }
        if (col + 2 < size) {
            if (row - 1 >= 0 && maze[row-1][col+2] == 1) {
                return false;
            }
        }
        return true;
    }
}
