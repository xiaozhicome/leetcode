package com.myself.leetcode.part2020;

public class NumIslands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(board));

    }

    public static class Solution {


        public int numIslands(char[][] grid) {
            int n = 0;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        n++;
                        dfs(i, j, grid, dx, dy);
                    }
                }
            }
            return n;
        }

        private void dfs(int row,
                         int col,
                         char[][] grid,
                         int[] dx,
                         int[] dy) {
            if (row < 0 || row == grid.length || col < 0 || col == grid[0].length
                    || grid[row][col] == '0') {
                return;
            }
            grid[row][col] = '0';
            for (int i = 0; i < dx.length; i++) {
                dfs(row + dx[i], col + dy[i], grid, dx, dy);
            }
            return;
        }
    }
}
