package com.myself.leetcode.part2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * [
         * [".Q..","...Q","Q...","..Q."],
         * ["..Q.","Q...","...Q",".Q.."]
         * ]
         */
        solution.print(solution.solveNQueens(4));//预期
    }

    public static class Solution {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> list = new LinkedList<>();
            if (n <= 0) {
                return list;
            } else if (n == 1) {
                List<String> oneList = new LinkedList<>();
                oneList.add("Q");
                list.add(oneList);
                return list;
            }
            int[][] r = new int[n][n];
            setQueue(0, n, 0, 0, 0, r, list);
            return list;
        }

        public void setQueue(int row, int maxRow,
                             int yBits, int xAddYBits, int ySubtractXBits,
                             int[][] r, List<List<String>> list) {
            if (row == maxRow) {
                //记录结果，返回
                List<String> oneList = getList(r);
                list.add(oneList);
                return;
            }
            for (int i = 0; i < r[0].length; i++) {
                r[row][i] = 1;
                int yBitsTemp = yBits;
                int xAddYBitsTemp = xAddYBits;
                int ySubtractXBitsTemp = ySubtractXBits;
                int rowBit = 1 << i;
                boolean yAvailable = (rowBit & yBits) == 0;
                boolean xAddYAvailable = (rowBit & xAddYBits) == 0;
                boolean ySubtractXAvailable = (rowBit & ySubtractXBits) == 0;
                if (yAvailable && xAddYAvailable && ySubtractXAvailable) {
                    yBits |= rowBit;
                    xAddYBits |= rowBit;
                    xAddYBits = xAddYBits << 1;
                    ySubtractXBits |= rowBit;
                    ySubtractXBits = ySubtractXBits >> 1;
                    setQueue(row + 1, maxRow, yBits, xAddYBits, ySubtractXBits, r, list);
                } 
                r[row][i] = 0;
                yBits = yBitsTemp;
                xAddYBits = xAddYBitsTemp;
                ySubtractXBits = ySubtractXBitsTemp;
            }
            return;
        }

        private List<String> getList(int[][] r) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < r.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < r[0].length; j++) {
                    if (r[i][j] == 1) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            return list;
        }


        public void print(List<List<String>> listList) {
            listList.stream().forEach(list -> System.out.println(Arrays.toString(list.toArray())));
        }

    }


}
