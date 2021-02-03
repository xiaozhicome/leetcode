package com.myself.leetcode.part2020;

public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(43261596));//预期964176192
        System.out.println(solution.reverseBits(-3));//预期-1073741825
    }

    public static class Solution {

        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int a = n & 1;
                result = (result << 1) + a;
                n = n >> 1;
            }
            return result;
        }


    }


}
