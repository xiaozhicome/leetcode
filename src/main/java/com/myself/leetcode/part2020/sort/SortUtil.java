package com.myself.leetcode.part2020.sort;

import java.util.Arrays;
import java.util.Random;

public class SortUtil {
    private static int N = 10;
    private static int LIMIT = 100;

    public static int[] getNumbers() {
        int[] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(LIMIT);
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static boolean isSorted(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length <= 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
