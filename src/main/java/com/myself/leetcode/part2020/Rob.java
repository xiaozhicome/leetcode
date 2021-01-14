package com.myself.leetcode.part2020;

public class Rob {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a={1,2,3,1};
        int[] b={2,7,9,3,1};
        int[] c={2,1,1,2};
        System.out.println(sulotion.rob(a));
        System.out.println(sulotion.rob(b));
        System.out.println(sulotion.rob(c));
    }

    public static class Sulotion{

        public int rob(int[] nums) {
            if(nums.length==0){
                return 0;
            }
            if(nums.length==1){
                return nums[0];
            }
            int[] dp =new int[nums.length];
            dp[0]=nums[0];
            dp[1]=Math.max(nums[1],dp[0]);
            for(int i=2;i<nums.length;i++){
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
            return dp[nums.length-1];
        }

        public int rob1(int[] nums) {
            if(nums.length==0){
                return 0;
            }
            if(nums.length==1){
                return nums[0];
            }
            int[][] dp =new int[nums.length][2];
            dp[0][0]=0;
            dp[0][1]=nums[0];
            dp[1][0]=dp[0][1];
            dp[1][1]=nums[1];
            for(int i=2;i<nums.length;i++){
                dp[i][0]=dp[i-1][1];
                dp[i][1]=Math.max(dp[i-2][0],dp[i-2][1])+nums[i];//注意i-2可以偷可以不偷
            }
            return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        }



    }


}
