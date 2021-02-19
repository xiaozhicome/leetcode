package com.myself.leetcode.part2021;

public class MaxProfitWithTransactionFee {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(sulotion.maxProfit(a, fee));//预期8
    }

    public static class Sulotion {

        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            //init i=0
            dp[0][0] = 0;
            dp[0][1] = -prices[0] - fee;
            if (prices.length == 1) {
                return 0;
            }
            for (int i = 1; i < prices.length; i++) {
                //第i天不持有股票 = 第i-1天不持有/第i-1天持有，今天卖出
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //第i天持有股票 = 第i-1天持有/第i-1天不持有，今天买入
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        }

    }


}
