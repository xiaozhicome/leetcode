package com.myself.leetcode.part2021;

public class CanJump {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};
        System.out.println(sulotion.canJump(a));//预期true
        System.out.println(sulotion.canJump(b));//预期fale
    }

    public static class Sulotion {

        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                if (!dp[i]) {
                    return false;
                }
                for (int j = 0; j < nums[i] && i + 1 + j < nums.length; j++) {
                    dp[i + 1 + j] = true;
                }
            }
            return dp[nums.length - 1];
        }

    }


}
