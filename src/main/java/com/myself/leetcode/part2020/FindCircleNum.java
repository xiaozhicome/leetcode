package com.myself.leetcode.part2020;

public class FindCircleNum {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(sulotion.findCircleNum(isConnected));
    }

    public static class Sulotion {

        int count;
        int[] parent;
        int[] size;

        public int findCircleNum(int[][] isConnected) {
            count = isConnected.length;
            parent = new int[count];
            size = new int[count];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        union(i,j);
                    }
                }
            }
            return count;
        }

        public int find(int num) {
            if (parent[num] == num) {
                return parent[num];
            }
            num = parent[num];
            parent[num] = find(num);
            return parent[num];
        }

        public void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA==parentB){
                return;
            }
            if(size[parentA]>size[parentB]){
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
                size[parentB] = 0;
            }else {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
                size[parentA] = 0;
            }
            count--;
        }

    }


}
