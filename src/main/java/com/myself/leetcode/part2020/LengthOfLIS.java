package com.myself.leetcode.part2020;

public class LengthOfLIS {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = {0, 1, 0, 3, 2, 3};
        int[] c = {7, 7, 7, 7, 7, 7, 7};
        int[] d = {4, 10, 4, 3, 8, 9};
        int[] e = {11, 12, 13, 14, 15, 6, 7, 8, 101, 18};
        int[] f = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(sulotion.lengthOfLIS(a));
        System.out.println(sulotion.lengthOfLIS(b));
        System.out.println(sulotion.lengthOfLIS(c));
        System.out.println(sulotion.lengthOfLIS(d));
        System.out.println(sulotion.lengthOfLIS(f));
    }

    public static class Sulotion {
        //方法1 动态规划
        //方法2 递推sub[i] 长度为i+1的子序列尾数最小值，形成的状态值！=最长递增子序列本身

        public int lengthOfLIS(int[] nums) {
            int[] tail = new int[nums.length];//用sub意义错误
            tail[0] = nums[0];
            int last = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > tail[last]) {
                    tail[++last] = nums[i];
                } else {//找各种长度下，尾数比nums[i]小的x,长度x+1的那个,尾数替换掉
                    int left = 0, right = last;
                    while (left <= right) {//TODO 循环终止条件
                        int middle = left + (right - left) / 2;
                        if (tail[middle] == nums[i]) {
                            right = middle - 1;
                        } else if (tail[middle] < nums[i]) {
                            left = middle + 1;//TODO 为啥
                        } else {
                            right = middle - 1;
                        }
                    }
                    tail[left] = nums[i];//TODO 为啥
                }
            }
            return last + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }


    }


}
