package com.myself.leetcode.part2020;

import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "cbaebabacd", p1 = "abc";
        String s2 = "abab", p2 = "ab";
        System.out.println(sulotion.findAnagrams(s1, p1));// 预期 [0, 6]
        System.out.println(sulotion.findAnagrams(s2, p2));// 预期 [0, 1, 2]
    }

    public static class Sulotion {

        public List<Integer> findAnagrams(String s, String p) {//子串，不是子序列
            Map<Character, Integer> originMap = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                originMap.put(p.charAt(i), originMap.getOrDefault(p.charAt(i), 0) + 1);
            }
            List<Integer> list = new LinkedList<>();
            if (s.length() < p.length()) {
                return list;
            }
            int i = 0, j = i + p.length();
            while (j <= s.length()) {
                String substring = s.substring(i, j);
                if (isAnagrams(substring, originMap)) {
                    list.add(i);
                }
                i++;
                j++;
            }
            return list;
        }

        private boolean isAnagrams(String str1, Map<Character, Integer> originMap) {
            Map<Character, Integer> checkMap = new HashMap<>(originMap);
            Set<Character> keySet = checkMap.keySet();
            for (int i = 0; i < str1.length(); i++) {
                if (!keySet.contains(str1.charAt(i))) {
                    return false;
                }
                checkMap.put(str1.charAt(i), checkMap.get(str1.charAt(i)) - 1);
            }
            for (Map.Entry<Character, Integer> entry : checkMap.entrySet()) {
                if (entry.getValue() != 0) {
                    return false;
                }
            }
            return true;
        }


        public List<Integer> findAnagrams1(String s, String p) {//子串，不是子序列
            int[] originArray = new int[26];
            for (int i = 0; i < p.length(); i++) {
                originArray[p.charAt(i) - 'a'] += 1;
            }
            List<Integer> list = new LinkedList<>();
            if (s.length() < p.length()) {
                return list;
            }
            int i = 0, j = i + p.length();
            while (j <= s.length()) {
                String substring = s.substring(i, j);
                if (isAnagrams1(substring, originArray)) {
                    list.add(i);
                }
                i++;
                j++;
            }
            return list;
        }

        private boolean isAnagrams1(String str1, int[] originArray) {
            int[] chars = new int[26];
            for (int i = 0; i < str1.length(); i++) {
                chars[str1.charAt(i) - 'a'] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (chars[i] != originArray[i]) {
                    return false;
                }
            }
            return true;
        }


    }


}
