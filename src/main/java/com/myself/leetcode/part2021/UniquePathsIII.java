package com.myself.leetcode.part2021;

public class UniquePathsIII {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][] b = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int[][] c = {{0, 1}, {2, 0}};
        System.out.println(sulotion.uniquePathsIII(a));//预期2
        System.out.println(sulotion.uniquePathsIII(b));//预期4
        System.out.println(sulotion.uniquePathsIII(c));//预期0
    }

    public static class Sulotion {

        public int uniquePathsIII(int[][] grid) {
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] used = new boolean[m][n];
            int c = 0;
            int mStart = 0;
            int nStart = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        c++;
                    } else if (grid[i][j] == 1) {
                        mStart = i;
                        nStart = j;
                    }
                }
            }
            //TODO dfs，不是bfs
            int total = dfs(grid, mStart, nStart, dx, dy, c, used);
            return total;
        }

        private int dfs(int[][] grid,
                        int m,
                        int n,
                        int[] dx, int[] dy,
                        int c,
                        boolean[][] used) {
            if (m < 0 || m > grid.length - 1 || n < 0 || n > grid[0].length - 1 || used[m][n]) {
                return 0;
            }
            int a = grid[m][n];
            if (a == -1) {
                return 0;
            }
            if (a == 2) {
                if (c == 0) {
                    return 1;
                } else {
                    int sum = 0;
                    used[m][n] = true;
                    for (int i = 0; i < dx.length; i++) {
                        sum += dfs(grid, m + dx[i], n + dy[i], dx, dy, c, used);
                    }
                    used[m][n] = false;
                    return sum;
                }
            }
            if (a == 1) {
                int sum = 0;
                used[m][n] = true;
                for (int i = 0; i < dx.length; i++) {
                    sum += dfs(grid, m + dx[i], n + dy[i], dx, dy, c, used);
                }
                used[m][n] = false;
                return sum;
            }
            if (a == 0) {
                int sum = 0;
                used[m][n] = true;
                for (int i = 0; i < dx.length; i++) {
                    sum += dfs(grid, m + dx[i], n + dy[i], dx, dy, c - 1, used);
                }
                used[m][n] = false;
                return sum;
            }
            return 0;
        }

    }


}
