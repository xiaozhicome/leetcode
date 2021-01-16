package com.myself.leetcode.part2020;

public class MinDistance {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String a1 = "horse", a2 = "ros";
        String b1 = "intention", b2 = "execution";
        System.out.println(sulotion.minDistance(a1,a2));
        System.out.println(sulotion.minDistance(b1,b2));
    }

    public static class Sulotion{

        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()+1][word2.length()+1];
            for(int i=1;i<word1.length()+1;i++){
                dp[i][0]=i;
            }
            for(int j=1;j<word2.length()+1;j++){
                dp[0][j]=j;
            }
            for(int i=1;i<word1.length()+1;i++){
                for(int j=1;j<word2.length()+1;j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }

    }


}
