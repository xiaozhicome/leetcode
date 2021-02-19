package com.myself.leetcode.part2020;

public class MaxProduct {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] nums = {2, 3, -2, 4};
        System.out.println(sulotion.maxProduct(nums));
    }

    public static class Sulotion {

        public int maxProduct(int[] nums) {
            int[] max = new int[nums.length];
            int[] min = new int[nums.length];
            max[0] = nums[0];
            min[0] = nums[0];
            int maxTotal = max[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    max[i] = 0;
                    min[i] = 0;
                } else if (nums[i] > 0) {
                    max[i] = Math.max(1, max[i - 1]) * nums[i];
                    min[i] = Math.min(1, min[i - 1]) * nums[i];
                } else if (nums[i] < 0) {
                    max[i] = Math.min(1, min[i - 1]) * nums[i];
                    min[i] = Math.max(1, max[i - 1]) * nums[i];
                }
                if (max[i] > maxTotal) {
                    maxTotal = max[i];
                }
            }
            return maxTotal;
        }


    }


}
