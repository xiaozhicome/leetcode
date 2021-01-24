package com.myself.leetcode.part2020.hard;

/**
 * 边界条件太多，代码巨复杂
 */
public class NumDecodings {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String a = "12";
        String b = "226";
        String c = "0";
        String d = "1";
        String e = "10";
        String f = "2101";
        String g = "1201234";
        System.out.println(sulotion.numDecodings(a));
        System.out.println(sulotion.numDecodings(b));
        System.out.println(sulotion.numDecodings(c));
        System.out.println(sulotion.numDecodings(d));
        System.out.println(sulotion.numDecodings(e));
        System.out.println(sulotion.numDecodings(f));
        System.out.println(sulotion.numDecodings(g));
    }

    public static class Sulotion {

        public int numDecodings(String s) {
            int[] dp = new int[s.length()];
            //dp[0]
            int current = s.charAt(0) - '0';
            int last = current;
            if (current == 0) {
                dp[0] = 0;
            } else {
                dp[0] = 1;
            }
            if (s.length() == 1) {
                return dp[s.length() - 1];
            }
            //dp[1]
            current = s.charAt(1) - '0';
            if (last == 0) {
                if (current == 0) {
                    return 0;
                } else {
                    dp[1] = dp[0];
                }
            } else if (last == 1) {
                if (current == 0) {
                    dp[1] = 1;//i-2
                } else {
                    dp[1] = dp[0] + 1;
                }
            } else if (last == 2) {
                if (current == 0) {
                    dp[1] = 1;//i-2
                } else if (current <= 6) {
                    dp[1] = dp[0] + 1;
                } else {
                    dp[1] = dp[0];
                }
            } else {
                if (current == 0) {
                    return 0;
                } else {
                    dp[1] = dp[0];
                }
            }
//            int n = last * 10 + current;
//            if (n == 0 && n > 26) {
//                return 0;//不对 例如29 此方法细节太多，搞不清楚
//            } else if (last == 0) {
//                dp[1] = dp[0];
//            } else {
//                dp[1] = dp[0] + 1;
//            }
            last = current;

            for (int i = 2; i < s.length(); i++) {
                current = s.charAt(i) - '0';
//                if (last == 0) {
//                    if (current != 0) {
//                        dp[i] = dp[i - 1];
//                    } else {
//                        return 0;
//                    }
//                } else if (last == 1) {//例如 10
//                    if (current != 0) {
//                        dp[i] = dp[i - 1] + dp[i - 2];
//                    } else {
//                        dp[i] = dp[i - 2];
//                    }
//                } else if (last == 2) {//例如 20
//                    if (current >= 1 && current <= 6) {
//                        dp[i] = dp[i - 1] + dp[i - 2];
//                    } else if (current == 0) {
//                        dp[i] = dp[i - 2];
//                    } else {
//                        dp[i] = dp[i - 1];
//                    }
//                } else {//例如 30
//                    if (current != 0) {
//                        dp[i] = dp[i - 1];
//                    } else {
//                        return 0;
//                    }
//                }
                if (current == 0) {//current为0可行情况
                    if (last == 1 || last == 2) {
                        dp[i] = dp[i - 2];
                    } else {
                        return 0;
                    }
                } else if (last == 1 || (last == 2 && current >= 1 && current <= 6)) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];//01 34
                }

                last = current;
            }
            return dp[s.length() - 1];
        }


    }


}
