package com.myself.leetcode.part2020;

public class AddBinary {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String a1 = "11", b1 = "1";
        String a2 = "1010", b2 = "1011";
        System.out.println(sulotion.addBinary(a1, b1));
        System.out.println(sulotion.addBinary(a2, b2));
    }

    public static class Sulotion {

        public String addBinary(String a, String b) {
            if(a.length()==0){
                return b;
            }
            if(b.length()==0){
                return a;
            }
            int i = a.length()-1;
            int j = b.length()-1;
            char[] chars = new char[Math.max(i,j)+1];
            int highByte = 0;
            int k = chars.length-1;
            while(k>=0){
                int ai = 0;
                int bj = 0;
                if(i>=0){
                    ai = a.charAt(i)-'0';
                }
                if(j>=0){
                    bj = b.charAt(j)-'0';
                }
                if(highByte+ai+bj>=2){
                    chars[k]=(char)('0'+(highByte+ai+bj)%2);
                    highByte=(highByte+ai+bj)/2;
                }else{
                    chars[k]=(char)('0'+highByte+ai+bj);
                    highByte = 0;
                }
                i--;
                j--;
                k--;
            }
            String result = new String(chars);
            if(highByte>=1){
                return "1"+result;
            }
            return result;
        }


    }


}
