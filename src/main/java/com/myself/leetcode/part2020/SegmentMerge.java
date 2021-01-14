package com.myself.leetcode.part2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class SegmentMerge {
    public static class Sulotion{
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            LinkedList<int[]> list = new LinkedList<>();
            int[] last=intervals[0];
            list.add(intervals[0]);
            for(int i=1;i<intervals.length;i++){

                if(last[1]>=intervals[i][0]){
                    last[1]=Math.max(last[1],intervals[i][1]);
                }else {
                    list.add(intervals[i]);
                    last = intervals[i];
                }
            }
            int[][] result = new int[list.size()][2];
            return list.toArray(result);
        }
    }

    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
    }
}
