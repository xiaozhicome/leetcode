package com.myself.leetcode.part2020.hard;

public class BinarySearchCloseClosePart {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {5, 7, 7, 8, 8, 10};
        System.out.println(sulotion.searchOnlyOne(a, 10));
        System.out.println(sulotion.searchOnlyOne(a, 2));
        System.out.println(sulotion.searchOnlyOne(a, 20));
        System.out.println(sulotion.searchOnlyOne(a, 9));
        System.out.println("--------");

        System.out.println(sulotion.searchFirst(a, 5));
        System.out.println(sulotion.searchFirst(a, 7));
        System.out.println(sulotion.searchFirst(a, 8));
        System.out.println(sulotion.searchFirst(a, 10));
        System.out.println(sulotion.searchFirst(a, 2));//输出0 判断不准确
        System.out.println(sulotion.searchFirst(a, 20));
        System.out.println(sulotion.searchFirst(a, 9));
        System.out.println("--------");

        System.out.println(sulotion.searchLast(a, 5));
        System.out.println(sulotion.searchLast(a, 7));
        System.out.println(sulotion.searchLast(a, 8));
        System.out.println(sulotion.searchLast(a, 10));
        System.out.println(sulotion.searchLast(a, 2));
        System.out.println(sulotion.searchLast(a, 20));//输出5 判断不准确
        System.out.println(sulotion.searchLast(a, 9));
        System.out.println("--------");

        System.out.println(sulotion.searchRange(a, 7));
        System.out.println(sulotion.searchRange(a, 8));
        System.out.println(sulotion.searchRange(a, 2));
        System.out.println(sulotion.searchRange(a, 20));
        System.out.println(sulotion.searchRange(a, 9));
        System.out.println("--------");

        System.out.println(sulotion.searchPrevNumberIndex(a, 5));
        System.out.println(sulotion.searchPrevNumberIndex(a, 7));
        System.out.println(sulotion.searchPrevNumberIndex(a, 8));
        System.out.println(sulotion.searchPrevNumberIndex(a, 10));
        System.out.println(sulotion.searchPrevNumberIndex(a, 2));
        System.out.println(sulotion.searchPrevNumberIndex(a, 20));
        System.out.println(sulotion.searchPrevNumberIndex(a, 9));
        System.out.println("--------");

        System.out.println(sulotion.searchPostNumberIndex(a, 5));
        System.out.println(sulotion.searchPostNumberIndex(a, 7));
        System.out.println(sulotion.searchPostNumberIndex(a, 8));
        System.out.println(sulotion.searchPostNumberIndex(a, 10));
        System.out.println(sulotion.searchPostNumberIndex(a, 2));
        System.out.println(sulotion.searchPostNumberIndex(a, 20));
        System.out.println(sulotion.searchPostNumberIndex(a, 9));
        System.out.println("--------");
    }

    public static class Sulotion {
        //查找唯一元素
        public int searchOnlyOne(int[] nums, int target) {
            int left = 0, right = nums.length - 1, middle;
            while (left <= right) {
                //>>容易写错 单目乘除与加减，与或逻辑再三目，左移右移比大小，赋值最后自赋值
//                middle = left +(right-left)>>1;
                middle = left + ((right - left) >> 1);
                if (nums[middle] == target) {
                    return middle;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return -1;
        }

        //查找元素第一个位置 单目乘除与加减，与或逻辑再三目，左移右移比大小，赋值最后自赋值
        public int searchFirst(int[] nums, int target) {
            int left = 0, right = nums.length - 1, middle;
            while (left <= right) {
                middle = left + ((right - left) >>> 1);
                if (nums[middle] == target) {
                    right = middle - 1;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
//            if (left <= nums.length - 1) {//仅判断left不够
            //nums[left]==target 可能元素不存在，left=right+1循环退出
            if (left <= nums.length - 1 && nums[left] == target) {
                return left;
            }
            return -1;
        }


        //查找元素最后一个位置 单目乘除与加减，与或逻辑再三目，左移右移比大小，赋值最后自赋值
        public int searchLast(int[] nums, int target) {
            int left = 0, right = nums.length - 1, middle = 0;
            while (left <= right) {//闭区间退出  while(left<right){...}开区间退出 nums.length
                middle = left + ((right - left) >>> 1);
                if (nums[middle] == target) {
                    left = middle + 1;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (right >= 0 && nums[right] == target) {
//            if (right < nums.length) {
                return right;
            }
            return -1;
        }

        //查找元素的长度
        public int searchRange(int[] nums, int target) {
            int left = searchFirst(nums, target);
            if (left == -1) {
                return 0;
            }
            int right = searchLast(nums, target);
            return right - left + 1;
        }

        //查找元素的前一个元素的索引
        public int searchPrevNumberIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int middle;
            while (left <= right) {
                middle = left + ((right - left) >> 1);
                if (nums[middle] == target) {
                    right = middle - 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            if (left < nums.length && nums[left] == target) {//target第一个元素索引left
                return right;
            }
            return -1;
        }

        //查找元素的后一个元素的索引
        public int searchPostNumberIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int middle;
            while (left <= right) {
                middle = left + (right - right) / 2;
                if (nums[middle] == target) {
                    left = middle + 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            if (right >= 0 && nums[right] == target && left < nums.length) {//target最后一个元素索引right
                return left;
            }
            return -1;
        }

    }


}
