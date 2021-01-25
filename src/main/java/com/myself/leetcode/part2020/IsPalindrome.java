package com.myself.leetcode.part2020;

public class IsPalindrome {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "0P";
        String s4 = ".,";
        String s5 = "1b1";
        System.out.println(sulotion.isPalindrome(s1));//期望 true
        System.out.println(sulotion.isPalindrome(s2));//期望 false
        System.out.println(sulotion.isPalindrome(s3));//期望 false
        System.out.println(sulotion.isPalindrome(s4));//期望 true
        System.out.println(sulotion.isPalindrome(s5));//期望 true
    }

    public static class Sulotion {

        public boolean isPalindrome(String s) {
            if (s.length() <= 1) {
                return true;
            }
            int t = 'a' - 'A';
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < s.length() - 1 && isOther(s.charAt(i))) {
                    i++;
                }
                while (j >= i && isOther(s.charAt(j))) {//TODO 必须要可以向等
                    j--;
                }
                if (i >= j) {
                    return true;
                } else if (isLetter(s.charAt(i)) && (s.charAt(i) == s.charAt(j) || Math.abs(s.charAt(i) - s.charAt(j)) == t)
                        || isNumber(s.charAt(i)) && s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean isLetter(char c) {
            return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
        }

        public boolean isNumber(char c) {
            return c >= '0' && c <= '9';
        }

        public boolean isOther(char c) {
            return !isLetter(c) && !isNumber(c);
        }

    }


}
