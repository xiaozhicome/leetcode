package com.myself.leetcode.part2020;

public class CountSort {
    public static class Sulotion{
        /**
         * arr2 中的元素各不相同
         * arr2 中的每个元素都出现在 arr1 中
         * @param arr1
         * @param arr2
         * @return
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] count = new int[1001];
            for(int i=0;i<arr1.length;i++){//循环大数组arr1
                count[arr1[i]]+=1;
            }
            int j=0;
            for(int i=0;i<arr2.length;i++){//循环基准数组arr2
                while (count[arr2[i]]>0){
                    arr1[j++]=arr2[i];
                    count[arr2[i]]-=1;
                }
            }
            /*for(int i=0;i<arr1.length;i++){//错误，这个地方arr1数据已经重写
                while (count[arr1[i]]>0){
                    arr1[j++]=arr1[i];
                    count[arr1[i]]-=1;
                }
            }*/
            for(int i=0;i<count.length;i++){
                while (count[i]>0){
                    arr1[j++]=i;
                    count[i]-=1;
                }
            }
            return arr1;
        }
    }

    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
    }
}
