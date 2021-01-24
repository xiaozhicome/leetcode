package com.myself.leetcode.part2020;

public class ReverseString {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        char[] chars = {'h','e','l','l','o'};
        sulotion.reverseString(chars);
        System.out.println(chars);
    }

    public static class Sulotion {

        public void reverseString(char[] s) {
            int i=0;
            int j=s.length-1;
            while (i<j){
                char c= s[i];
                s[i++]=s[j];
                s[j--]=c;
            }
        }


    }


}
