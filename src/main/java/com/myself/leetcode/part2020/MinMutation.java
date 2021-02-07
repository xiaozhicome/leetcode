package com.myself.leetcode.part2020;

public class MinMutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        //预期2
        System.out.println(solution.minMutation(start, end, bank));

        String start2 = "AAAAACCC";
        String end2 = "AACCCCCC";
        String[] bank2 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        //预期3
        System.out.println(solution.minMutation(start2, end2, bank2));

    }

    public static class Solution {

        public int minMutation(String start, String end, String[] bank) {
            return 0;
        }

    }
}
