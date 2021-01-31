package com.myself.leetcode.part2020;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] m2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(sulotion.spiralOrder(m1));
        System.out.println(sulotion.spiralOrder(m2));
    }

    public static class Sulotion {

        public List<Integer> spiralOrder(int[][] matrix) {
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] visited = new boolean[m][n];
            List<Integer> list = new ArrayList<>(m * n);
            int i = 0, j = 0, k = m * n, index = 0;
            while (true) {
                if (!visited[i][j]) {
                    list.add(matrix[i][j]);
                    visited[i][j] = true;
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
                int times = index;
                while (i + x[index] > m-1
                        || i + x[index] < 0
                        || j + y[index] > n-1
                        || j + y[index] < 0
                        || visited[i + x[index]][j + y[index]]) {
                    index = (index + 1) % 4;
                }
                i = i + x[index];
                j = j + y[index];

            }
            return list;
        }


    }


}
