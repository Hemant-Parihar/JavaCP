package com.maze;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minimumPathRecursive(grid, 0, 0));
        System.out.println(minPathSum(grid));
        System.out.println(minimumPathBottomDown(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                ans[i][j] = -1;
            }
        }
        return miniumnPathTopDown(grid, 0, 0, ans);
    }

    private static int minimumPathRecursive(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        } else if ( (row == grid.length - 1) && (col == grid[0].length - 1) ) {
            return grid[row][col];
        }
        int down = minimumPathRecursive(grid, row, col+1);
        int right = minimumPathRecursive(grid, row + 1, col);
        return grid[row][col] + Math.min(down, right);
    }

    private static int minimumPathBottomDown(int[][] grid) {
        int row = grid.length;
        int col = grid.length;
        int[][] ans = new int[row][col];
        ans[0][0] = grid[0][0];
        for(int i = 1; i < col; i++) {
            ans[0][i] = grid[0][i] + ans[0][i-1];
        }
        for(int i = 1; i < row; i++) {
            ans[i][0] = grid[i][0] + ans[i-1][0];
        }
        for(int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                ans[i][j] = grid[i][j] + Math.min(ans[i][j-1], ans[i-1][j]);
            }
        }
        return ans[row - 1][col - 1];
    }



    private static int miniumnPathTopDown(int[][] grid, int row, int col, int[][] ans) {
        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        } else if ( (row == grid.length - 1) && (col == grid[0].length - 1) ) {
            return grid[row][col];
        }
        int down, right;
        if (row + 1 < grid.length && ans[row+1][col] != -1) {
            down = ans[row+1][col];
        } else {
            down = miniumnPathTopDown(grid, row+1, col, ans);
        }
        if (col + 1 < grid.length && ans[row][col + 1] != -1) {
            right = ans[row][col + 1];
        } else {
            right = miniumnPathTopDown(grid, row, col + 1, ans);
        }
        ans[row][col] =  grid[row][col] + Math.min(down, right);
        return ans[row][col];
    }
}
