package com.myself.leetcode.part2020;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)));//预期
        System.out.println(Arrays.toString(solution.countBits(5)));//预期
    }

    public static class Solution {

        public int[] countBits(int num) {
            int[] array = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                array[i] = array[i >> 1] + (i & 1);
            }
            return array;
        }

        public int[] countBits1(int num) {
            int[] array = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                array[i] = getCount(i);
            }
            return array;
        }

        public int getCount(int n) {
            if (n == 0) {
                return 0;
            }
            int r = 0;
            while (n != 0) {
                n = n & (n - 1);
                r++;
            }
            return r;
        }


    }


}
