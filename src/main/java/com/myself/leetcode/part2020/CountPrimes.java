package com.myself.leetcode.part2020;

public class CountPrimes {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        int n = 10;
        System.out.println(sulotion.countPrimes(n));//预期 4
        System.out.println(sulotion.countPrimes(100));//预期 4
        System.out.println(sulotion.countPrimes(499979));//预期 4
    }

    public static class Sulotion {

        public int countPrimes(int n) {
            int[] primes = new int[n];
            int count = 0;
            if (n < 1) {
                return 0;
            }
            for (int i = 2; i < n; i += 1) {//只检测奇数 需要列出所有素数
                if (primes[i] == 0) {
                    count++;
                }
                long t = (long)i * i;
                for (int j = i; t < n; j += 1, t = i * j) {//只检测奇数*奇数 需要列出所有素数
                    primes[(int)t] = 1;
                }
            }
            for(int i=2;i<n;i++){
                if(primes[i]==0){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            return count;
        }


    }


}
