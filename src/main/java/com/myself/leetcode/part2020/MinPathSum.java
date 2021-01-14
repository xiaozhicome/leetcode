package com.myself.leetcode.part2020;

public class MinPathSum {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] b = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(sulotion.minPathSum(a));
        System.out.println(sulotion.minPathSum(b));
    }

    public static class Sulotion {

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] x = new int[]{1, 0};
            int[] y = new int[]{0, 1};
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            if (n == 0) {
                return dp[m - 1][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int min = dp[i - x[0]][j - y[0]];
                    for (int z = 1; z < x.length; z++) {
                        min = Math.min(dp[i - x[z]][j - y[z]], min);
                    }
                    dp[i][j] = min + grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }

    }


}
