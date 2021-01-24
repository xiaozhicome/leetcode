package com.myself.leetcode.part2020;

public class ToLowerCase {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s = "Hello";
        System.out.println(sulotion.toLowerCase(s));
    }

    public static class Sulotion {

        public String toLowerCase(String str) {
            int t = 'a' - 'A';
            char[] chars = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    chars[i] = (char) (ch + t);
                } else {
                    chars[i] = ch;
                }
            }
            return new String(chars);
        }


    }


}
