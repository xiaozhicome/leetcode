package com.myself.leetcode.part2020;

public class LongestPalindrome {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";
        System.out.println(sulotion.longestPalindrome(s1));//期望 bab
        System.out.println(sulotion.longestPalindrome(s2));//期望 bb
        System.out.println(sulotion.longestPalindrome(s3));//期望 a
        System.out.println(sulotion.longestPalindrome(s4));//期望 a
    }

    public static class Sulotion {

        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            int maxStart = 0;
            int maxLength = 1;
            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    if(i==j){
                        dp[i][j] = true;
                    }else if(i==j-1){
                        dp[i][j] = s.charAt(i)==s.charAt(j);
                    }else{
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }
                    if (dp[i][j] && j - i + 1 > maxLength) {
                        maxStart = i;
                        maxLength = j - i + 1;
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLength);
        }

        public String longestPalindromeCenter(String s) {
            char[] chars = s.toCharArray();
            int maxStart = 0;
            int maxLength = 1;
            for (int i = 0; i < chars.length - 1; i++) {
                int odd = getPalindromeMaxLength(chars, i, i);//奇数
                int even = getPalindromeMaxLength(chars, i, i + 1);//偶数
                int max = Math.max(odd, even);
                if (max > maxLength) {
                    maxLength = max;
                    maxStart = i - (max - 1) / 2;
                }
            }
            return s.substring(maxStart, maxStart + maxLength);
        }

        private int getPalindromeMaxLength(char[] chars, int i, int j) {
            while (i >= 0 && j <= chars.length - 1) {
                if (chars[i] == chars[j]) {
                    i--;
                    j++;
                } else {
                    return j - i - 1;//TODO 不是j - i + 1，这里出界时是全开区间
                }
            }
            return j - i - 1;
        }


        public String longestPalindromeForce(String s) {
            char[] chars = s.toCharArray();
            int maxStart = 0;
            int maxLength = 1;
            for (int i = 0; i <= s.length() - 1; i++) {
                for (int j = i + 1; j <= s.length() - 1; j++) {
                    if (isPalindrome(chars, i, j) && j - i + 1 > maxLength) {
                        maxStart = i;
                        maxLength = j - i + 1;
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLength);
        }

        public boolean isPalindrome(char[] chars, int i, int j) {
            while (i < j) {
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }


}
