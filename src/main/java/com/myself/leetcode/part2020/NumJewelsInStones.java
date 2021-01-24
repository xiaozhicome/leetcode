package com.myself.leetcode.part2020;

public class NumJewelsInStones {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String j1 = "aA", s1 = "aAAbbbb";
        String j2 = "z", s2 = "ZZ";
        System.out.println(sulotion.numJewelsInStones(j1, s1));//预期3
        System.out.println(sulotion.numJewelsInStones(j2, s2));//预期0
    }

    public static class Sulotion {

        public int numJewelsInStones(String jewels, String stones) {
            int[] letter = new int['z' + 1];
            for (int i = 0; i < stones.length(); i++) {
                letter[stones.charAt(i)] += 1;
            }
            int sum = 0;
            for (int j = 0; j < jewels.length(); j++) {
                sum += letter[jewels.charAt(j)];
            }
            return sum;
        }

    }


}
