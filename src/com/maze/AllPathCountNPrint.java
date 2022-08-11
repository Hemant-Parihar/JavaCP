package com.maze;

import java.util.ArrayList;
import java.util.List;

public class AllPathCountNPrint {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
//        System.out.println(countAllPath(row, col, ""));
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println(printAllPathMaze(0, 0,"", maze));
    }

    private static int countAllPath(int row, int col, String path) {
        if (row < 1 || col < 1) return 0;
        if (row == 1 && col == 1) {
            System.out.println(path);
            return 1;
        }
        return countAllPath(row-1, col, path + 'D') + countAllPath(row, col-1, path + 'R');
    }

    private static ArrayList<String> printAllPath(int row, int col, String path) {
        if (row < 1 || col < 1) {
            return new ArrayList<>();
        }
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(printAllPath(row-1, col, path + 'D'));
        list.addAll(printAllPath(row, col-1, path + 'R'));
        return list;
    }

    private static ArrayList<String> printAllPathMaze(int row, int col, String path, boolean[][] maze) {
        if (row > maze.length - 1 || col > maze[0].length - 1) {
            return new ArrayList<>();
        }
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (!maze[row][col]) return list;

        list.addAll(printAllPathMaze(row+1, col, path + 'D', maze));
        list.addAll(printAllPathMaze(row, col+1, path + 'R', maze));

        return list;
    }
}
