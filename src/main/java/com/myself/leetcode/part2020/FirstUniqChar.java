package com.myself.leetcode.part2020;

import com.myself.leetcode.map.HashMap;

import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        System.out.println(sulotion.firstUniqChar(s1));//预期0
        System.out.println(sulotion.firstUniqChar(s2));//预期2
    }

    public static class Sulotion {

        public int firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>(s.length());
            for(int i=0;i<s.length();i++){
                Character c = s.charAt(i);
                map.put(c, map.getOrDefault(c,0)+1);
            }
            for(int i=0;i<s.length();i++){
                if(map.get(s.charAt(i))==1){
                    return i;
                }
            }
            return -1;
        }

    }


}
