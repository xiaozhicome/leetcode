package com.myself.leetcode.part2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class UniquePaths {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.uniquePaths1(3,7));
    }

    public static class Sulotion{
        public int uniquePaths(int m, int n) {
            int[] x={1,0}; //向下
            int[] y={0,1}; //向右
            int[][] dp =new int[m][n];//不要写m+1 n+1
            for(int i=0;i<m;i++){
                dp[i][0]=1;
            }
            for(int j=0;j<n;j++){
                dp[0][j]=1;
            }
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    dp[i][j] = dp[i-x[0]][j-y[0]] + dp[i-x[1]][j-y[1]];
                }
            }
            return dp[m-1][n-1];
        }

        public int uniquePaths1(int m, int n) {
            int[] x={1,0}; //向下
            int[] y={0,1}; //向右
            int[][] dp =new int[m+1][n+1];//不要写m+1 n+1
            for(int i=0;i<m+1;i++){
                dp[i][1]=1;
            }
            for(int j=0;j<n+1;j++){
                dp[1][j]=1;
            }
            for(int i=2;i<m+1;i++){
                for(int j=2;j<n+1;j++){
                    dp[i][j] = dp[i-x[0]][j-y[0]] + dp[i-x[1]][j-y[1]];
                }
            }
            return dp[m][n];
        }
    }


}
