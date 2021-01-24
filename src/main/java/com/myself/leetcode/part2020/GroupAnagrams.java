package com.myself.leetcode.part2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sulotion.groupAnagrams(s));
        /**
         * 预期
         * [
         *   ["ate","eat","tea"],
         *   ["nat","tan"],
         *   ["bat"]
         * ]
         */
    }

    public static class Sulotion {

        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> group = new LinkedList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            if (strs.length == 0) {
                return group;
            }
            for (int i = 0; i < strs.length; i++) {
                String key = getKey(strs[i]);
                List<String> list = map.getOrDefault(key, new LinkedList<String>());
                list.add(strs[i]);
                map.put(key, list);
            }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                group.add(entry.getValue());
            }
            return group;
        }

        private String getKey(String str) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a'] += 1;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    builder.append((char) (i + 'a')).append(chars[i]);
                }

            }
            return builder.toString();
        }


    }


}
