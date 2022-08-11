package com.maze;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking {
    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        boolean[][] visited = {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int[][] maze = new int[3][3];
        System.out.println(printAllPath(row, col, "", visited, maze, 1));
    }

    private static ArrayList<String> printAllPath(int row, int col, String path, boolean[][] visited, int[][] maze, int level) {
        if (row > visited.length - 1 || col > visited[0].length - 1) {
            return new ArrayList<>();
        }
        if (row == visited.length - 1 && col == visited[0].length - 1) {
            maze[row][col] = level;
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            for(int[] arr : maze) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (visited[row][col]) return list;
        visited[row][col] = true;
        maze[row][col] = level;

        list.addAll(printAllPath(row+1, col, path + 'D', visited, maze, level + 1));
        list.addAll(printAllPath(row, col+1, path + 'R', visited, maze, level + 1));

        if (row > 0 ) {
            list.addAll(printAllPath(row - 1, col, path + 'U', visited, maze, level + 1));
        }

        if (col > 0) {
            list.addAll(printAllPath(row, col - 1, path + 'L', visited, maze, level + 1));
        }

        visited[row][col] = false;
        maze[row][col] = 0;
        return list;
    }
}
