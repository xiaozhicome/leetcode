package com.myself.leetcode.part2020;

public class ValidPalindrome {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "aba";
        String s2 = "abca";
        System.out.println(sulotion.validPalindrome(s1));//期望 true
        System.out.println(sulotion.validPalindrome(s2));//期望 true
    }

    public static class Sulotion {

        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    if (i + 1 < s.length() && isPalindrome(chars, i + 1, j) ||
                            j - 1 > 0 && isPalindrome(chars, i, j - 1)){
                        return true;
                    }
                    return false;
                }
            }
            return true;
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
