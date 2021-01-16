package com.myself.leetcode.part2020;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {10, 15, 20};
        int[] b = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(sulotion.minCostClimbingStairs(a));
        System.out.println(sulotion.minCostClimbingStairs(b));
    }

    public static class Sulotion{

        public int minCostClimbingStairs(int[] cost) {
            if(cost.length==0){
                return 0;
            }
            if(cost.length==1){
                return 0;
            }
            if(cost.length==2){
                return Math.max(cost[0],cost[1]);
            }
            int[][] dp = new int[cost.length][2];
            dp[0][0]=0;
            dp[0][1]=cost[0];
            dp[1][0]=cost[0];
            dp[1][1]=cost[1];
            for(int i=2;i<cost.length;i++){
                dp[i][0] = dp[i-1][1];
                dp[i][1] = Math.min(dp[i-1][1],dp[i-2][1])+cost[i];
            }
            return Math.min(dp[cost.length-1][0],dp[cost.length-1][1]);
        }

    }


}
