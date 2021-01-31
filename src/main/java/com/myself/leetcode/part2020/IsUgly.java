package com.myself.leetcode.part2020;

public class IsUgly {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.isUgly(6));
        System.out.println(sulotion.isUgly(8));
        System.out.println(sulotion.isUgly(14));
        System.out.println(sulotion.isUgly(1));
        System.out.println(sulotion.isUgly(0));
    }

    public static class Sulotion {

        public boolean isUgly(int num) {
            while(true){
                if(num==0){
                    return false;
                }else if(num ==1){
                    return true;
                }else if(num%2==0){
                    num = num>>1;
                }else if(num%3==0){
                    num = num/3;
                }else if(num%5==0){
                    num = num/5;
                }else {
                    return false;
                }
            }
        }


    }


}
