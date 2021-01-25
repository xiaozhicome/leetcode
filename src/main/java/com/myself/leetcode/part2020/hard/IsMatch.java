package com.myself.leetcode.part2020.hard;

public class IsMatch {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "ab", p3 = ".*";
        String s4 = "aab", p4 = "c*a*b";
        String s5 = "mississippi", p5 = "mis*is*p*.";

        System.out.println(sulotion.isMatch(s1, p1));//期望 false
        System.out.println(sulotion.isMatch(s2, p2));//期望 true
        System.out.println(sulotion.isMatch(s3, p3));//期望 true
        System.out.println(sulotion.isMatch(s4, p4));//期望 true
        System.out.println(sulotion.isMatch(s5, p5));//期望 false
    }

    public static class Sulotion {

        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            if (s.length() == 0) {

            }
//            char ch = s.charAt(0);
            for (int j = 1; j < n + 1; j++) {
                //使用p匹配''，不是用p匹配s.charAt(0)
                if (j >= 2 && p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                    dp[0][j] = true;
                }
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    char a = s.charAt(i - 1);
                    char b = p.charAt(j - 1);
                    if (a == b) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // a!=b
                        if (b == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else if (b == '*') {
                            if (j >= 2) {
                                char c = p.charAt(j - 2);
                                if (c == a) { //xxxa xxa* 使用a*匹配当前字符1个 || 使用a*匹配0个当前字符
                                    //dp[i][j] = dp[i - 1][j-2] || dp[i - 1][j-1] || dp[i-1][j]
                                    //|| dp[i][j - 2] || dp[i][j-1] || dp[i][j] ;
                                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 2] || dp[i][j - 1];
//                                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                                } else {
                                    // c!=a
                                    if (c == '.') {
                                        //xxxa  xx.* 使用.*匹配或者不使用
                                        //dp[i][j] = dp[i - 1][j-2] || dp[i - 1][j-1] || dp[i-1][j]
                                        //|| dp[i][j - 2] || dp[i][j-1] || dp[i][j] ;
                                        //顺推关系必须成立，先可以多写几个，然后排除
                                        //使用.*匹配当前字符1个 || 使用.*匹配0个当前字符
//                                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
                                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i][j - 1];
//                                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                                    } else {
                                        //xxxa xxb* 匹配0个，j去掉两个字符
                                        dp[i][j] = dp[i][j - 2];
                                    }
                                }
                            }

                        }
                    }
                }
            }
            return dp[m][n];
        }
    }


}
