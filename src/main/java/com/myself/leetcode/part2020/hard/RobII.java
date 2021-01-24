package com.myself.leetcode.part2020.hard;

public class RobII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {2, 3, 2};
        int[] b = {1, 2, 3, 1};
        int[] c = {0};
        System.out.println(sulotion.rob(a));//预期3
        System.out.println(sulotion.rob(b));//预期4
        System.out.println(sulotion.rob(c));//预期0
    }

    public static class Sulotion {

        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            //1:n-1 0不偷
            int[] dp = new int[nums.length];
            dp[0] = 0;
            dp[1] = Math.max(nums[1], dp[0]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            int a = dp[nums.length - 1];
            //0:n-2 n-1不偷
            dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1], dp[0]);
            for (int i = 2; i < nums.length - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            int b = dp[nums.length - 2];
            return Math.max(a, b);
        }


    }


}
