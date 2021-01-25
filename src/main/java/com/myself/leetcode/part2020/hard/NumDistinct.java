package com.myself.leetcode.part2020.hard;

public class NumDistinct {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "rabbbit", t1 = "rabbit";
        String s2 = "babgbag", t2 = "bag";

        System.out.println(sulotion.numDistinct(s1, t1));//期望 3
        System.out.println(sulotion.numDistinct(s2, t2));//期望 5
    }

    public static class Sulotion {

        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                dp[i][0] = 1;
            }
            // xa ya
            // xa yb
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }


}
