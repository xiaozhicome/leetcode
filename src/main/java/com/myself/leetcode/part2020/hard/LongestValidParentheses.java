package com.myself.leetcode.part2020.hard;

import java.util.Stack;

/**
 * 边界条件巨多
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String a = "(()";
        String b = ")()())";
        String c = "()(()";
        String d = ")()())";
        System.out.println(sulotion.longestValidParentheses(a));
        System.out.println(sulotion.longestValidParentheses(b));
        System.out.println(sulotion.longestValidParentheses(c));
        System.out.println(sulotion.longestValidParentheses(d));//输出6 预期4
    }

    public static class Sulotion {

        public int longestValidParentheses(String s) {
            if (s.length() <= 1) {
                return 0;
            }
            int[] dp = new int[s.length()];//dp[i] 0:i 以s.charAt(i)结尾的有效长度
            dp[0] = 0;
            int maxLength = 0;
            for (int i = 1; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current == '(') {
                    dp[i] = 0;
                } else {// current==')'
                    if (s.charAt(i - 1) == '(') {
                        if (i - 2 < 0) {
                            dp[i] = 2;
                        } else {
                            dp[i] = dp[i - 2] + 2;
                        }
                    } else {//s.charAt(i-1)==')'
                        //dp[i - 1] 起始位置 i-1-dp[i - 1]+1=i-dp[i - 1]
                        if (dp[i - dp[i - 1] - 1] == ')') {
                            dp[i] = 0;
                        } else {//dp[i - dp[i - 1] - 1] == '('
                            if (i - dp[i - 1] - 2 < 0) {
                                dp[i] = dp[i - 1] + 2;
                            } else {
                                dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                            }
                        }

                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
            return maxLength;
        }


        public int longestValidParentheses1(String s) {
            if (s.length() <= 1) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int length = 0;
            int maxLength = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current == '(') {
//                    maxLength = Math.max(length, maxLength);
//                    length = 0;
                    stack.push(i);//TODO 只有右括号被入栈
                } else {// ')'
                    stack.pop();// )
                    if (stack.isEmpty()) {
                        stack.push(i);//记录下一段匹配的起始位置
                    } else {
                        maxLength = Math.max(i - stack.peek(), maxLength);
                    }
                }
            }
            return maxLength;
        }


    }


}
