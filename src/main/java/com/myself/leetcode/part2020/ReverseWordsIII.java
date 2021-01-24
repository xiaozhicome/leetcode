package com.myself.leetcode.part2020;

public class ReverseWordsIII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "Let's take LeetCode contest";
        System.out.println(sulotion.reverseWords(s1));//预期 "s'teL ekat edoCteeL tsetnoc"
    }

    public static class Sulotion {

        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = 0;
            boolean start = false, end = true;
            for (int i = 0; i < chars.length; i++) {
                if (!start && chars[i] != ' ') {
                    left = i;
                    start = true;
                } else if (start && chars[i] == ' ') {
                    right = i;
                    reverseString(chars, left, right);
                    start = false;
                }
                if (start && i == chars.length - 1) {
                    right = i;
                    reverseString(chars, left, chars.length);
                    start = false;
                }

            }
            return new String(chars);
        }

        public void reverseString(char[] chars, int start, int end) {
            for (int k = start; k <= (start + end - 1) / 2; k++) {
                char c = chars[k];
                chars[k] = chars[end - 1 - (k - start)];
                chars[end - 1 - (k - start)] = c;
            }
        }

    }


}
