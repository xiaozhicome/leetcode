package com.myself.leetcode.part2020;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public static class Solution {

        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }


    }


}
