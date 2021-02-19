package com.myself.leetcode.part2021;

public class MaxProfitII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};
        int[] c = {1, 2, 3, 4, 5};
        System.out.println(sulotion.maxProfit(a));//预期7
        System.out.println(sulotion.maxProfit(b));//预期0
        System.out.println(sulotion.maxProfit(c));//预期4
    }

    public static class Sulotion {

        public int maxProfit(int[] prices) {
            //dp当天手里的钱，天数i,剩余交易次数j,是否持有股票k
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                //第i天持有股票=前一天已经持有股票，前一天没有持有股票今天买入股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                //第i天没有股票=前一天没有持有股票，前一天持有股票今天卖出
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        }

    }


}
