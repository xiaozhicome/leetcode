package com.myself.leetcode.part2021;

public class UniquePaths {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int m = 3, n = 7;
        int m1 = 3, n1 = 2;
        System.out.println(sulotion.uniquePaths(m, n));//预期28
        System.out.println(sulotion.uniquePaths(m1, n1));//预期3
    }

    public static class Sulotion {

        public int uniquePaths(int m, int n) {
            int[] dx = {0, 1};
            int[] dy = {1, 0};
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m-1][n-1];
        }

    }


}
