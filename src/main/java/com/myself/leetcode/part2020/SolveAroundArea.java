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

        char[][] board2 = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        solution.solve(board2);
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2[0].length; j++) {
                System.out.print(board2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static class Solution {

        public void solve(char[][] board) {
            if (board.length == 0) {
                return;
            }
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
                            && board[i][j] == 'O') {
                        //从边界开始把所有O设置为char 0
                        dfs(i, j, board, dx, dy);
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        //把所有O设置为X
                        board[i][j] = 'X';
                    }else if(board[i][j] == 0){
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(int row,
                         int col,
                         char[][] board,
                         int[] dx,
                         int[] dy) {
            if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
                return;
            }
            char c = board[row][col];
            if (c == 'O') {
                board[row][col] = 0;
                for (int i = 0; i < dx.length; i++) {
                    dfs(row + dx[i], col + dy[i], board, dx, dy);
                }
            }
            return;
        }


        public void solveBad(char[][] board) {
            if (board.length == 0) {
                return;
            }
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j] == 'O') {
                        boolean noContactWithEdge = dfsBad(i, j, board, used, dx, dy);
                    }
                }
            }
        }

        private boolean dfsBad(int row,
                               int col,
                               char[][] board,
                               boolean[][] used,
                               int[] dx, int[] dy) {
            if (row < 0 || row == board.length || col < 0 || col == board[0].length) {
                return false;
            }
            if (board[row][col] == 'O'
                    && (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1)) {
                return false;
            }
            if (board[row][col] == 'O' && used[row][col]) {
                return false;
            }
            if (board[row][col] == 'X') {
                return true;
            }
            boolean noContactWithEdge = true;
            board[row][col] = 'X';
            used[row][col] = true;
            for (int i = 0; i < dx.length; i++) {
                boolean b = dfsBad(row + dx[i], col + dy[i], board, used, dx, dy);
                noContactWithEdge = (noContactWithEdge && b);
            }
            if (noContactWithEdge) {
                return true;
            }
            board[row][col] = 'O';
            return false;
        }
    }
}
