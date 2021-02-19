package com.myself.leetcode.part2020;

public class MakeConnected {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int n1 = 6;
        int[][] connections1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(sulotion.makeConnected(n1, connections1));
    }

    public static class Sulotion {
        int n;
        int[] parent;
        int[] size;

        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            //合并
            for (int i = 0; i < connections.length; i++) {
                int[] ints = connections[i];
                union(ints[0], ints[1]);
            }
            return this.n - 1;
        }

        public int find(int num) {
            //路径压缩，只有两层+按size合并
            if (parent[num] == num) {
                return num;
            }
            num = parent[num];
            parent[num] = find(num);
            return parent[num];
        }

        public void union(int a, int b) {
            //按秩合并，树的高度，不如使用路径压缩，所以没有使用
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return;
            }
            if (size[parentA] < size[parentB]) {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
                size[parentA]=0;
            } else {
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
                size[parentB]=0;
            }
            n--;
        }
    }


}
