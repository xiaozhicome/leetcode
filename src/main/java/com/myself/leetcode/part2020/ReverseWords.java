package com.myself.leetcode.part2020;

import java.util.LinkedList;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
        String s4 = "  Bob    Loves  Alice   ";
        String s5 = "Alice does not even like bob";
        String s6 = " asdasd df f";
        System.out.println(sulotion.reverseWords(s1));
        System.out.println(sulotion.reverseWords(s2));
        System.out.println(sulotion.reverseWords(s3));
        System.out.println(sulotion.reverseWords(s4));
        System.out.println(sulotion.reverseWords(s5));
        System.out.println(sulotion.reverseWords(s6));
    }

    public static class Sulotion {

        public String reverseWords(String s) {
            List<String> list = new LinkedList<>();
            int a = 0, b = 0;
            boolean start = false, end = false;
            for (int i = 0; i < s.length(); i++) {
                if (!start && s.charAt(i) != ' ') {
                    a = i;
                    start = true;
                } else if (start && s.charAt(i) == ' ') {
                    b = i;
                    list.add(s.substring(a, b));
                    start = false;
                }
                //TODO 注意不能else if
                if (start && i == s.length() - 1) {
                    b = i;
                    list.add(s.substring(a));
                    start = false;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int j = list.size() - 1; j >= 0; j--) {
                String str = list.get(j);
                if(j==0){
                    builder.append(str);
                    return builder.toString();
                }
                builder.append(str).append(" ");
            }
            return builder.toString();
        }

    }


}
