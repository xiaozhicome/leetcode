package com.myself.leetcode.part2020.sort;

public class NumsArraySort {
    public static void main(String[] args) {
        NumsArraySort numsArraySort = new NumsArraySort();
        int[] numbers = SortUtil.getNumbers();
        numsArraySort.quickSort(numbers);
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

    public void shellSort(int[] nums) {
        int k = nums.length / 2;
//        while (3 * k < nums.length) {
//            k *= 3;
//        }
        while (k >= 1) {
            for (int i = k; i < nums.length; i += k) {
                int j = i;
                while (j > 0 && nums[j - k] > nums[j]) {
                    SortUtil.swap(nums, j - k, j);
                    j -= k;
                }
            }
            k /= 2;
        }
    }

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] array = new int[nums.length];
        int m = left, n = middle + 1;
        for (int i = left; i <= right; ) {
            while (m <= middle && n <= right) {
                if (nums[m] <= nums[n]) {
                    array[i++] = nums[m++];
                } else {
                    array[i++] = nums[n++];
                }
            }
            while (m <= middle) {
                array[i++] = nums[m++];
            }
            while (n <= right) {
                array[i++] = nums[n++];
            }
        }
        System.arraycopy(array, left, nums, left, right - left + 1);
    }

    public void heapSort(int[] nums) {
        int[] heap = buildHeap(nums);
        for (int i = heap.length - 1; i >= 2; i--) {
            SortUtil.swap(heap, 1, i);
            sink(heap, 1, i - 1);
        }
        System.arraycopy(heap, 1, nums, 0, nums.length);
    }

    private int[] buildHeap(int[] nums) {
        int[] heap = new int[nums.length + 1];
        System.arraycopy(nums, 0, heap, 1, nums.length);
        for (int i = heap.length - 1 - nums.length / 2; i >= 1; i--) {
            sink(heap, i, heap.length - 1);
        }
        return heap;
    }

    private void sink(int[] heap, int index, int limit) {
        if (index == limit) {
            return;
        }
        int left = index * 2;
        if (left > limit) {
            return;
        }
        int max = left;
        int right = left + 1;
        if (right <= limit && heap[right] > heap[left]) {
            max = right;
        }
        if (heap[max] > heap[index]) {//TODO 注意求出max之后仍然需要比较
            SortUtil.swap(heap, index, max);
            sink(heap, max, limit);
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int part = partition(nums, left, right);
        quickSort(nums, left, part);
        if(part+1<right){
            quickSort(nums, part + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        if(left==right){
            return left;
        }
        int part = left;
        int i = left, j = right;
        while (true) {
            while (j > left && nums[j] >= nums[part]) {//TODO 保证j最后落到小于part的位置
                j--;
            }
            while (i < j && nums[i] < nums[part]) {
                i++;
            }
            if (i < j) {
                SortUtil.swap(nums, i++, j--);
            } else {
                break;
            }
        }
        SortUtil.swap(nums, part, j);
        return j;
    }
}
