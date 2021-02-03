package com.myself.leetcode.part2020;

public class HammingWeightString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 ="00000000000000000000000000001011";
        System.out.println(solution.hammingWeight(Integer.parseInt(s1, 2)));// 预期3
        String s2 ="00000000000000000000000010000000";
        System.out.println(solution.hammingWeight(Integer.parseInt(s2, 2)));// 预期1
        String s3 ="11111111111111111111111111111101";
        System.out.println(solution.hammingWeight(Integer.parseInt(s3, 2)));// 预期31
    }

    public static class Solution {

        public int hammingWeight(int n) {
            if(n==0){
                return 0;
            }
            int count = 0;
            while (n!=0){
                n = n&(n-1);
                count++;
            }
            return count;
        }


    }


}
