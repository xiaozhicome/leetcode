package com.myself.leetcode.part2020;

public class IsValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public static class Solution {

        public boolean isValidSudoku(char[][] board) {
            int n = board.length;
            boolean[][] rowNums = new boolean[n][10];
            boolean[][] columnNums = new boolean[n][10];
            boolean[][] boxNums = new boolean[n][10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int num = c - '0';
                        if (rowNums[i][num] || columnNums[j][num] || boxNums[i / 3 * 3 + j / 3][num]) {
                            return false;
                        } else {
                            rowNums[i][num] = true;
                            columnNums[j][num] = true;
                            boxNums[i / 3 * 3 + j / 3][num] = true;
                        }
                    }
                }
            }
            return true;
        }


    }
}
