package com.myself.leetcode.part2020.hard;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        char[][] a = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        char[][] b = {};
        char[][] c = {{0}};
        char[][] d = {{1}};
        System.out.println(sulotion.maximalRectangle(a));//预期6
        System.out.println(sulotion.maximalRectangle(b));//预期0
        System.out.println(sulotion.maximalRectangle(c));//预期0
        System.out.println(sulotion.maximalRectangle(d));//预期1
    }

    public static class Sulotion {

        public int maximalRectangle(char[][] matrix) {
            int[][] height = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0) {
                        height[i][j] = matrix[i][j] - '0';
                    } else {
                        if (matrix[i][j] - '0' == 0) {
                            height[i][j] = 0;
                        } else {
                            height[i][j] = 1 + height[i - 1][j];
                        }
                    }
                }
            }
            for (int i = 0; i < height.length; i++) {
                max = Math.max(max, maxAreaBetween(height[i]));
            }
            return max;
        }

        /**
         * 单调栈，未完成
         * @param height
         * @return
         */
        public int maxAreaBetween(int[] height) {
            Stack<Integer> stack = new Stack<>();
            //index -1 height=height[0]
            stack.push(0);
            int max = 0;
            for (int i = 1; i < height.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {// 不为空
                    int top = stack.pop();
                    if (height[i] > height[top]) {
                        stack.push(i);
                    } else {
                        while (height[i] < height[top]) {
                            int index = stack.isEmpty() ?
                                    -1 :
                                    stack.pop();
//                            max = Math.max(max, (i - top) * h);
                        }
                        stack.push(i);
                    }
                }
            }
            return 0;
        }


    }


}
