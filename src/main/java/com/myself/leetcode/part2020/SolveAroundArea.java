package com.myself.leetcode.part2020;

public class SolveAroundArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static class Solution {

        public void solve(char[][] board) {

        }
    }
}
