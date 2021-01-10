package com.myself.leetcode.part2020;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "ababababca";
        String needle = "abababca";
//        String haystack = "aaaaa";
//        String needle = "bba";
//        String haystack = "aabaaabaaac";
//        String needle = "aabaaac";
        System.out.println(solution.strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        //KMP
        //1 分析pattern找出PMT
        int[] pmt = getPartialMatchTable03(needle);
        System.out.println(Arrays.toString(pmt));
        //2 根据PMT找出next数组
        int[] next = getNextTable(pmt);
        System.out.println(Arrays.toString(next));
        //3 根据next数据挨个匹配text
        int i=0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                j= next[j];
            }
        }
        if(j==needle.length()){
            return i-j;
        }
        return -1;
    }

    private int[] getNextTable(int[] pmt) {
        for(int i=pmt.length-1;i>0;i--){
            pmt[i]=pmt[i-1];
        }
        pmt[0]=-1;
        return pmt;
    }


    public int[] getPartialMatchTable01(String pattern) {
        int[] pmt = new int[pattern.length()];
        int i = 1;//顺序访问pattern
        pmt[0] = 0;
        int j = pmt[0];//pmt[i-1]
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pmt[i]=j+1;
                j=pmt[i];//pmt[i-1]
                i++;
            }else{
                if(j==0){//j==0时直接赋值0 死循环
                    pmt[i]=0;
                    j=pmt[i];//pmt[i-1]
                    i++;
                }else{
                    j=pmt[j];
                }
            }
        }
        return pmt;
    }

    public int[] getPartialMatchTable02(String pattern) {
        int[] pmt = new int[pattern.length()];
        int i = 1;//顺序访问pattern
        pmt[0] = 0;
        int j = pmt[0];//pmt[i-1]
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pmt[i]=j+1;
                j=pmt[i];//pmt[i-1]
                i++;
            }else{
                if(pmt[j]<j){//将j向更小方向变换 错误
                    j=pmt[j];//bba  0 1 0
                }else{
                    pmt[i]=0;
                    j=pmt[i];//pmt[i-1]
                    i++;
                }
            }
        }
        return pmt;
    }

    public int[] getPartialMatchTable03(String pattern) {
        int[] pmt = new int[pattern.length()];
        int i = 1;//顺序访问pattern，后缀最后位置
        pmt[0] = 0;
        int j = pmt[0];//指针记录pmt[i-1]的值，表示前一次最大匹配前缀个数
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pmt[i]=j+1;
                j=pmt[i];//pmt[i-1]
                i++;
            }else{
                if(j-1>=0){
                    j=pmt[j-1];//bba  0 1 0
                }else{
                    pmt[i]=0;
                    j=pmt[i];//pmt[i-1]
                    i++;
                }
            }
        }
        return pmt;
    }

}