package com.myself.leetcode.part2020;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s = "Hello World";
        System.out.println(sulotion.lengthOfLastWord(s));
    }

    public static class Sulotion {

        public int lengthOfLastWord(String s) {
            int start = -1, end = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (end == -1 && isLetter(s.charAt(i))) {
                    end = i;
                }
                if (end != -1 && start == -1 && s.charAt(i) == ' ') {
                    start = i;
                    break;
                }
            }
            return end-start;
        }

        private boolean isLetter(char c) {
            return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
        }


    }


}
