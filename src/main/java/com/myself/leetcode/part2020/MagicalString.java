package com.myself.leetcode.part2020;

public class MagicalString {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.magicalString(6));// 预期 3
        System.out.println(sulotion.magicalString(4));// 预期 2
    }

    public static class Sulotion {

        //位数1 2 3 4 5 6 ...
        //基数1 2 1 2 1 2
        //已知1 2 2 1 1 2
        //实际1 2 2 1 1 2 1 2 2 ...
        public int magicalString(int n) {
            if(n==0){
                return 0;
            }else if(n<=3){
                return 1;
            }
            int[] nums = new int[2 * n];
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 2;
            int count = 1;
            for (int i = 2, j = 3; i < nums.length; i++) {
                int a = i % 2 + 1;
                int b = nums[i];
                while (b > 0) {
                    nums[j++] = a;
                    b--;
                    if (a == 1) {
                        count++;
                    }
                    if (j > n-1) {//TODO 下标
                        return count;
                    }
                }
            }
            return count;
        }


    }


}
