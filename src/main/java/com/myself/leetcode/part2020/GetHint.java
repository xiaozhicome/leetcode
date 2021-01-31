package com.myself.leetcode.part2020;

public class GetHint {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String secret1 = "1807", guess1 = "7810";
        String secret2 = "1123", guess2 = "0111";
        System.out.println(sulotion.getHint(secret1, guess1));
        System.out.println(sulotion.getHint(secret2, guess2));
    }

    public static class Sulotion {

        public String getHint(String secret, String guess) {
            int[] s1 = new int[10];
            int[] g1 = new int[10];
            int count = 0;
            for (int i = 0; i < secret.length(); i++) {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                s1[s] += 1;
                g1[g] += 1;
                if (s == g) {
                    count++;
                }
            }
            int sum = 0;
            for (int j = 0; j < s1.length; j++) {
                sum += Math.min(s1[j], g1[j]);
            }
            return ""+count+"A"+(sum-count)+"B";
        }


    }


}
