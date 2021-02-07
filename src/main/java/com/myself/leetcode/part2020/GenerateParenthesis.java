package com.myself.leetcode.part2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.generateParenthesis(3).toArray()));
    }

    public static class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> list = new LinkedList<>();
            char[] chars = new char[n * 2];
            generate(n, 0, 0, chars, list);
            return list;
        }

        private void generate(int n, int a, int b, char[] chars, List<String> list) {
            if (a == n && b == n) {
                String s = new String(chars);
                list.add(s);
                return;
            }
            if (a < b || a > n || b > n) {
                return;
            }
            chars[a + b] = '(';
            generate(n, a + 1, b, chars, list);
            chars[a + b] = 0;

            chars[a + b] = ')';
            generate(n, a, b + 1, chars, list);
            chars[a + b] = 0;
        }

    }


}
