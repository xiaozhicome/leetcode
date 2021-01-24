package com.myself.leetcode.part2020;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "Test1ng-Leet=code-Q!";
        System.out.println(sulotion.reverseOnlyLetters(s1));//预期 "Qedo1ct-eeLg=ntse-T!"
    }

    public static class Sulotion {

        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();
            int i = 0, j = chars.length - 1;
            while (i < j) {
                while (i < j && !isLetter(chars[i])) {
                    i++;
                }
                while (j > i && !isLetter(chars[j])) {
                    j--;
                }
                reverseLetter(chars, i++, j--);
            }
            return new String(chars);
        }

        public boolean isLetter(char c) {
            return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
        }

        public void reverseLetter(char[] chars, int i, int j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }

    }


}
