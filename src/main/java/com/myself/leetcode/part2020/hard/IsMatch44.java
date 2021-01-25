package com.myself.leetcode.part2020.hard;

public class IsMatch44 {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "*";
        String s3 = "cb", p3 = "?a";
        String s4 = "adceb", p4 = "*a*b";
        String s5 = "acdcb", p5 = "a*c?b";

        System.out.println(sulotion.isMatch(s1, p1));//期望 false
        System.out.println(sulotion.isMatch(s2, p2));//期望 true
        System.out.println(sulotion.isMatch(s3, p3));//期望 false
        System.out.println(sulotion.isMatch(s4, p4));//期望 true
        System.out.println(sulotion.isMatch(s5, p5));//期望 false
    }

    public static class Sulotion {

        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j-1) == '*' && dp[0][j - 1]) {
                    dp[0][j] = true;
                }
            }
            // xa ya
            // xa y?  任意一个字符，非空，非字符串
            // xa y*  任意长度字符串，可以为空，与前一个字符无关，直到后一个字符出现
            // xa *?  至少后面一个任意字符
            // xa ?*  普通匹配 y?
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    char si = s.charAt(i - 1);
                    char pi = p.charAt(j - 1);
                    if (si == pi || pi=='?'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(pi == '*'){
                        dp[i][j] = dp[i-1][j-1] || dp[i][j-1] ||dp[i-1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }


}
