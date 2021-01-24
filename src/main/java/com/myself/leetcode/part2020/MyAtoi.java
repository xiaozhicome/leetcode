package com.myself.leetcode.part2020;

import com.myself.leetcode.map.HashMap;

public class MyAtoi {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "3.14159";
        String s7 = "00000-42a1234";
        String s8 = "2147483646";
        System.out.println(sulotion.myAtoi(s1));//预期42
        System.out.println(sulotion.myAtoi(s2));//预期-42
        System.out.println(sulotion.myAtoi(s3));//预期4193
        System.out.println(sulotion.myAtoi(s4));//预期0
        System.out.println(sulotion.myAtoi(s5));//预期-2147483648
        System.out.println(sulotion.myAtoi(s6));//预期3
        System.out.println(sulotion.myAtoi(s7));//预期0
        System.out.println(sulotion.myAtoi(s8));//预期2147483646
    }

    public static class Sulotion {

        public int myAtoi(String s) {
            HashMap<Character, Integer> signal = new HashMap<>(4);
            signal.put('-', -1);
            signal.put('+', 1);
            HashMap<Character, Integer> number = new HashMap<>(16);
            for (char i = '0'; i <= '9'; i++) {
                number.put(i, i - '0');
            }
            int ans = 0, sig = 1, p = 0;
            boolean ansInit = false, sigInit = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    if (ansInit) {
                        break;
                    } else {
                        continue;
                    }
                } else if (null != number.get(c)) {
                    if (!ansInit) {
                        ansInit = true;
                        sigInit = true;
                    }
                    int n = c - '0';
                    if (p >= 9) {
//                        if (sig == 1 && ans >= (Integer.MAX_VALUE - n) / 10) {
//                            return Integer.MAX_VALUE;
//                        } else if (sig == -1 && (-1 * ans) <= (Integer.MIN_VALUE + n) / 10) {
//                            return Integer.MIN_VALUE;
//                        }
                        if (sig == 1 && ans >= Integer.MAX_VALUE / 10 && n >= 7) {
                            return Integer.MAX_VALUE;
                        } else if (sig == -1 && ans >= Integer.MAX_VALUE / 10 && n >= 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    ans = ans * 10 + n;
                    p++;
                } else if (null != signal.get(c)) {
                    if (!sigInit && !ansInit) {
                        sigInit = true;
                        sig = signal.get(c);
                    } else {
                        return 0;
                    }
                } else if (c == '.') {
                    if (ansInit) {
                        break;
                    } else {
                        return 0;
                    }
                } else {//字母 空格
                    if (ansInit) {
                        break;
                    } else {
                        return 0;
                    }
                }
            }
            return sig * ans;
        }

    }


}
