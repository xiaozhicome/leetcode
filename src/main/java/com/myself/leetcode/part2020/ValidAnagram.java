package com.myself.leetcode.part2020;

public class ValidAnagram {
    public static class Sulotion{
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()){
                return false;
            }
            int[] count = new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']+=1;
            }
            for(int i=0;i<t.length();i++){
                count[t.charAt(i)-'a']-=1;
            }
            for(int i=0;i<count.length;i++){
                if(count[i]!=0){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
    }
}
