package com.myself.leetcode.part2020;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
    }

    public static class Sulotion {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.size() == 1) {
                return triangle.get(0).get(0);
            }
            ArrayList<Integer> last = new ArrayList<>(triangle.get(0).size());
            last.add(triangle.get(0).get(0));
            int minSum = last.get(0);
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> list = triangle.get(i);
                ArrayList<Integer> current = new ArrayList<>(list.size());
                minSum = last.get(0) + list.get(0);
                current.add(minSum);
                for (int j = 1; j < list.size(); j++) {
                    Integer integer = list.get(j);
                    Integer pre = 0;
                    if (j == 0) {
                        pre = last.get(j);
                    } else if (j == list.size() - 1) {
                        pre = last.get(j - 1);
                    } else {
                        pre = Math.min(last.get(j - 1), last.get(j));
                    }
                    int min = integer + pre;
                    current.add(min);
                    if (min < minSum) {
                        minSum = min;
                    }
                }
                last = current;
            }
            return minSum;
        }


    }


}
