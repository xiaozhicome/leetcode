package com.myself.leetcode.part2020;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String text1, text2;
        text1 = "abcde";
        text2 = "ace";
        System.out.println(sulotion.longestCommonSubsequence(text1, text2));// 预期 3
        text1 = "abc";
        text2 = "abc";
        System.out.println(sulotion.longestCommonSubsequence(text1, text2));// 预期 3
        text1 = "abc";
        text2 = "def";
        System.out.println(sulotion.longestCommonSubsequence(text1, text2));// 预期 0

    }

    public static class Sulotion {

        public int longestCommonSubsequence(String text1, String text2) {
            int row = text1.length() + 1;
            int column = text2.length() + 1;
            int[][] dp = new int[row][column];

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < column; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    }
                }
            }
            return dp[row - 1][column - 1];
        }


    }


}
