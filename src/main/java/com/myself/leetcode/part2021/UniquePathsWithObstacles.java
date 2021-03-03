package com.myself.leetcode.part2021;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] b = {{0, 1}, {0, 0}};
        System.out.println(sulotion.uniquePathsWithObstacles(a));//预期2
        System.out.println(sulotion.uniquePathsWithObstacles(b));//预期1
    }

    public static class Sulotion {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            boolean startZero = false;
            for (int i = 0; i < m; i++) {
                if (startZero || obstacleGrid[i][0] == 1) {
                    dp[i][0] = 0;
                    startZero = true;
                } else {
                    dp[i][0] = 1;
                }
            }
            startZero = false;
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
                if (startZero || obstacleGrid[0][j] == 1) {
                    dp[0][j] = 0;
                    startZero = true;
                } else {
                    dp[0][j] = 1;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

    }


}
