package com.myself.leetcode.part2021;

public class CoinChangeII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] coin = {1, 2, 5};
        int amount = 5;
        System.out.println(sulotion.change(amount, coin));//预期4

        int[] coin2 = {2};
        int amount2 = 3;
        System.out.println(sulotion.change(amount2, coin2));//预期0

        int[] coin3 = {10};
        int amount3 = 10;
        System.out.println(sulotion.change(amount3, coin3));//预期1
    }

    public static class Sulotion {


        public int change(int amount, int[] coins) {
            //排列问题与组合问题的区别，
            //排列问题顺序不同也算不同方案
            //组合问题顺序不同算作一种方案，需要按固定顺序选择方案，怎么固定顺序，就需要按照不同硬币已有顺序选择
            //完全背包 先循环物品种类，再循环体积
            int m = coins.length + 1;
            int n = amount + 1;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i < m; i++) {//硬币种类
                for (int j = 1; j < n; j++) {//金额
                    if (j - coins[i - 1] >= 0) {
                        //TODO dp[i-1][j - coins[i - 1]]不对，因为这里是完全背包
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

        public int change1(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 1; i < amount + 1; i++) {
                int count = 0;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        count += dp[i - coins[j]];
                    }
                }
                dp[i] = count;
            }
            return dp[amount];
        }

    }


}
