package com.myself.leetcode.part2020;

import java.util.LinkedList;

public class ConvertToBase7 {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.convertToBase7(100));// 期望 202
        System.out.println(sulotion.convertToBase7(-7));// 期望 -10
    }

    public static class Sulotion {

        public String convertToBase7(int num) {
            String s = "";
            boolean isNagative = false;
            if (num == 0) {
                return "0";
            } else if (num < 0) {
                isNagative = true;
                num *= -1;
            }
            while (num > 0) {
                s = String.valueOf((char)('0' + num % 7)) + s;
                num /= 7;
            }
            return isNagative ? "-" + s : s;
        }

        public String convertToBase71(int num) {
            LinkedList<Character> list = new LinkedList();
            boolean isNagative = false;
            if (num == 0) {
                return "0";
            } else if (num < 0) {
                isNagative = true;
                num *= -1;
            }
            while (num > 0) {
                list.addFirst((char) ('0' + num % 7));
                num /= 7;
            }
            StringBuilder builder = new StringBuilder();
            list.forEach(c -> builder.append(c));
            String s = builder.toString();
            return isNagative ? "-" + s : s;
        }


    }


}
