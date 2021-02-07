package com.myself.leetcode.part2020;

public class SolveSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public static class Solution {

        public void solveSudoku(char[][] board) {
            int n = board.length;
            boolean[][] rowNums = new boolean[n][10];
            boolean[][] columnNums = new boolean[n][10];
            boolean[][] boxNums = new boolean[n][10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int num = c - '0';
                        rowNums[i][num] = true;
                        columnNums[j][num] = true;
                        boxNums[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            solve(0, 0, n, board, rowNums, columnNums, boxNums);
        }

        private boolean solve(int row,
                              int column,
                              int n,
                              char[][] board,
                              boolean[][] rowNums,
                              boolean[][] columnNums,
                              boolean[][] boxNums) {
            if (column == n) {
                column = 0;
                row++;
                if (row == n) {
                    return true;
                }
            }
            char c = board[row][column];
            if (c == '.') {
                for (int i = 1; i <= 9; i++) {
                    if (rowNums[row][i]
                            || columnNums[column][i]
                            || boxNums[row / 3 * 3 + column / 3][i]) {
                        continue;
                    } else {
                        board[row][column] = (char) ('0' + i);
                        rowNums[row][i] = true;
                        columnNums[column][i] = true;
                        boxNums[row / 3 * 3 + column / 3][i] = true;
                        if (solve(row, column + 1, n, board, rowNums, columnNums, boxNums)) {
                            return true;
                        }
                        board[row][column] = '.';
                        rowNums[row][i] = false;
                        columnNums[column][i] = false;
                        boxNums[row / 3 * 3 + column / 3][i] = false;
                    }
                }
                return false;
            } else {
                return solve(row, column + 1, n, board, rowNums, columnNums, boxNums);
            }
        }
    }
}
