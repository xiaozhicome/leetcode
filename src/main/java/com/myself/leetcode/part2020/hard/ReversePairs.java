package com.myself.leetcode.part2020.hard;

public class ReversePairs {
    public static class Sulotion {

        public static void main(String[] args) {
            Sulotion sulotion = new Sulotion();
            System.out.println(sulotion.reversePairs(new int[]{1,3,2,3,1}));
            System.out.println(sulotion.reversePairs(new int[]{2, 4, 3, 5, 1}));
            System.out.println(sulotion.reversePairs(new int[]{-5,-5}));
            System.out.println(sulotion.reversePairs(new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647}));
        }

        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] temp = new int[nums.length];
            return sort(nums, 0, nums.length - 1, temp);
        }

        private int sort(int[] nums, int left, int right, int[] temp) {
            if (left == right) {
                return 0;
            }
            int count = 0;
            int middle = left + (right - left) / 2;
            count += sort(nums, left, middle, temp);
            count += sort(nums, middle + 1, right, temp);
            count += merge(nums, left, middle, right, temp);
            return count;
        }


        private int merge(int[] nums,
                          int left,
                          int middle,
                          int right,
                          int[] temp) {
            int i = left;
            int j = middle + 1;
            int t = left;
            int count = 0;
            //先计数，不然分散比较边界条件太复杂，但是提交超时，蛋疼
            for (int m = left; m <= middle; ) {
                int n = middle + 1;
                while (n <= right && (long) nums[m] > 2 * (long) nums[n]) {
                    n++;
                    count++;
                }
                m++;
            }
            while (t <= right) {
                while (i <= middle && j <= right) {
                    if (nums[i] <= nums[j]) {
                        temp[t++] = nums[i++];
                    } else {
                        temp[t++] = nums[j++];
                    }
                }
                while (i <= middle) {
                    temp[t++] = nums[i++];
                }
                while (j <= right) {
                    temp[t++] = nums[j++];
                }
            }
            System.arraycopy(temp, left, nums, left, right - left + 1);
            return count;
        }
    }


    private int merge1(int[] nums, int left, int middle, int right, int[] temp) {
        int i = left;
        int j = middle + 1;
        int t = left;
        int count = 0;
        while (t <= right) {
            while (i <= middle && j <= right) {

                if (nums[i] <= nums[j]) {//有负数[-5,-5]
                    if ((long) nums[i] > (long) 2 * nums[j]) {//必须在j++前获取
                        count++;
                    }
                    temp[t++] = nums[i++];
                } else {
                    for (int k = i; k <= middle; k++) {
                        if ((long) nums[k] > (long) 2 * nums[j]) {//必须在j++前获取
                            count++;
                        }
                    }
                    temp[t++] = nums[j++];
                }
            }
            while (i <= middle) {
                if (j == right && (long) nums[i] > (long) 2 * nums[j]) {//必须判断j是否已经>right
                    count++;
                }
                temp[t++] = nums[i++];
            }
            while (j <= right) {
                temp[t++] = nums[j++];
            }
        }
        System.arraycopy(temp, left, nums, left, right - left + 1);
        return count;
    }


}
