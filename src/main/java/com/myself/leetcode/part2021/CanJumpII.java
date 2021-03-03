package com.myself.leetcode.part2021;

public class CanJumpII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(sulotion.jump(a));//预期2
    }

    public static class Sulotion {

        public int jump(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; ) {
                int a = nums[i];
                if (i == nums.length - 1) {
                    return count;
                } else if (i + a >= nums.length - 1) {
                    return count + 1;
                }
                int max = i;
                int iTemp = i;
                for (int j = i; j <= iTemp + a; j++) {
                    int b = nums[j];
                    if (b + j > max) {
                        max = b + j;
                        i = j;
                    }
                }
                if (i == max) {
                    return -1;
                }
                count++;
            }
            return count;
        }

    }


}
