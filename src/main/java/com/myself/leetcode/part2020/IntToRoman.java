package com.myself.leetcode.part2020;

public class IntToRoman {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.intToRoman(3));//预期III
        System.out.println(sulotion.intToRoman(4));//预期IV
        System.out.println(sulotion.intToRoman(9));//预期IX
        System.out.println(sulotion.intToRoman(58));//预期LVIII
        System.out.println(sulotion.intToRoman(1994));//预期MCMXCIV
    }

    public static class Sulotion {

        public String intToRoman(int num) {
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < nums.length; ) {
                int j = num / nums[i];
                num -= nums[i] * j;//TODO 顺序，需要先减去，后处理，不然j的值会变
                while (j-- > 0) {
                    builder.append(strings[i]);
                }
                i++;
            }
            return builder.toString();
        }
    }

}
