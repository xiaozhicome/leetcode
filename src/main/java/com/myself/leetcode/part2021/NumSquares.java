package com.myself.leetcode.part2021;

public class NumSquares {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int a = 12;
        int b = 13;
        System.out.println(sulotion.numSquares(a));//预期3
        System.out.println(sulotion.numSquares(b));//预期2
    }

    public static class Sulotion {

        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int min = dp[i - 1] + 1;
                for (int j = 1; j * j <= i; j++) {
                    int k = dp[i - j * j] + 1;
                    if (k < min) {
                        min = k;
                    }
                }
                dp[i] = min;
            }
            return dp[n];
        }

    }


}
