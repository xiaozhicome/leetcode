package com.myself.leetcode.part2020;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String[] s1 = {"flower", "flow", "flight"};
        String[] s2 = {"dog", "racecar", "car"};
        String[] s3 = {"ab", "a"};
        System.out.println(sulotion.longestCommonPrefix(s1));//期望fl
        System.out.println(sulotion.longestCommonPrefix(s2));//期望''
        System.out.println(sulotion.longestCommonPrefix(s3));//期望a
    }

    public static class Sulotion {

        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            }
            char[] pre = new char[strs[0].length()];
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
//                for (int j = 1; j < strs.length; j++) {
//                    if (strs[j].charAt(i) == c) {
//                        pre[i]=c;
//                    }else{
//                        return new String(pre).trim();
//                    }
//                }
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return new String(pre).trim();
                    }
                }
                pre[i] = c;
            }
            return strs[0];
        }


    }


}
