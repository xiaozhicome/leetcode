package com.myself.leetcode.part2020;

public class ReverseStringII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s = "abcdefg";
        int k = 2;
        System.out.println(sulotion.reverseStr(s, k));
    }

    public static class Sulotion {

        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 2 * k) {
                int end = i + k;
                if (end > chars.length) {
                    end = chars.length;
                }
                reverseString(chars, i, end);
            }
            return new String(chars);
        }

        //开闭区间
        public void reverseString(char[] chars, int start, int end) {
            for (int i = start; i <= (start + end - 1) / 2; i++) {
                char t = chars[i];
                chars[i] = chars[end - 1 - (i - start)];
                chars[end - 1 - (i - start)] = t;
            }
        }

    }


}
