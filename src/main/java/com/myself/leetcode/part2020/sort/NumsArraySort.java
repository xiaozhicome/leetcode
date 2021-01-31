package com.myself.leetcode.part2020.sort;

public class NumsArraySort {
    public static void main(String[] args) {
        NumsArraySort numsArraySort = new NumsArraySort();
        int[] numbers = SortUtil.getNumbers();
        numsArraySort.insertSort(numbers);
        System.out.println(SortUtil.isSorted(numbers));
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    SortUtil.swap(nums, j - 1, j);
                }
            }
        }
    }

    public void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int p = 0;
            for (int j = 1; j < n - i; j++) {
                if (nums[j] > nums[p]) {
                    p = j;
                }
            }
            SortUtil.swap(nums, p, n - i - 1);
        }
    }

    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j >= 1 && nums[j - 1] > nums[j]) {
                SortUtil.swap(nums, j - 1, j);
                j--;
            }
        }
    }

    public void shellSort(int[] nums){

    }
}
