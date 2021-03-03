package com.myself.leetcode.part2021;

public class CoinChange {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] coin = {1, 2, 5};
        int amount = 11;
        System.out.println(sulotion.coinChange(coin, amount));//预期3

        int[] coin2 = {2};
        int amount2 = 3;
        System.out.println(sulotion.coinChange(coin2, amount2));//预期-1

        int[] coin3 = {1};
        int amount3 = 0;
        System.out.println(sulotion.coinChange(coin3, amount3));//预期0
    }

    public static class Sulotion {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                int min = -1;
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        if (dp[i - coins[j]] != -1) {
                            if(min==-1){
                                min = dp[i - coins[j]] + 1;
                            }else{
                                min = Math.min(min, dp[i - coins[j]] + 1);
                            }
                        }
                    }
                }
                dp[i] = min;
            }
            return dp[amount];
        }

    }


}
