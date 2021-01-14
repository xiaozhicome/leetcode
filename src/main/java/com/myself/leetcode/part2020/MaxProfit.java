package com.myself.leetcode.part2020;

public class MaxProfit {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a={7,1,5,3,6,4};
        int[] b={7,6,4,3,1};
        System.out.println(sulotion.maxProfit(a));
        System.out.println(sulotion.maxProfit(b));
    }

    public static class Sulotion{

        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }
            int[][][] dp =new int[prices.length][2][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = 0;
            dp[0][1][1] = -prices[0];
            dp[0][1][0] = 0;
            for(int i=1;i<prices.length;i++){
                //交易0次，不持有股票
                dp[i][0][0]=0;
                dp[i][0][1]=0;
                //交易一次，持有股票，今天买入，休息
                dp[i][1][1]=Math.max(dp[i-1][0][0]-prices[i],dp[i-1][1][1]);
                //交易一次，不持有股票，今天卖出，休息
                dp[i][1][0]=Math.max(dp[i-1][1][1]+prices[i],dp[i-1][1][0]);
            }

            return Math.max(
                    Math.max(dp[prices.length-1][1][1],dp[prices.length-1][1][0]),
                    dp[prices.length-1][0][0]);
        }

    }


}
