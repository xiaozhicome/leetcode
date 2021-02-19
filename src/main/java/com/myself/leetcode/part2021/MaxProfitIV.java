package com.myself.leetcode.part2021;

public class MaxProfitIV {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();

    }

    public static class Sulotion {

        public int maxProfit(int k, int[] prices) {
            if(prices.length==0){
                return 0;
            }
            //dp当天手里的钱，天数i,交易次数j,是否持有股票k
            int[][][] dp = new int[prices.length][k + 1][2];
            for (int j = 0; j <= k; j++) {
                if (j == 1) {
                    dp[0][1][1] = -prices[0];
                }
            }
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j <= k; j++) {
                    //第i天持有股票=前一天已经持有股票，前一天没有持有股票今天买入股票
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][1];
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                    //第i天没有股票=前一天没有持有股票，前一天持有股票今天卖出
                    if (j == 0) {
                        dp[i][j][0] = dp[i - 1][j][0];
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    }
                }

            }
            int max = 0;
            for (int j = 0; j <= k; j++) {
                int temp = Math.max(dp[prices.length - 1][j][0], dp[prices.length - 1][j][1]);
                if (temp > max) {
                    max = temp;
                }
            }
            return max;
        }

    }


}
