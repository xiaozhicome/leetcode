package com.myself.leetcode.part2019;

import com.myself.leetcode.map.HashMap;

import java.util.*;

public class Middle {
    public static void main(String[] args) {
        Middle middle = new Middle();
        System.out.println(middle.longestPalindromeCenter("abaab"));
        Map<String, String> map = new HashMap<>();
        map.containsKey("");
        HashSet<String> set = new HashSet<>();
        set.contains("");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        if(len<3)return null;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            if(nums[i]>0)break;
            int left=i+1;
            int right=len-1;
//            while
        }
        return null;
    }


    public int maxArea(int[] height) {
        if(height.length<2)return 0;
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        int min=0;
        while(left<right){
            min=Math.min(height[left],height[right]);
            int temp=min *(right-left);
            if(temp>maxArea)maxArea=temp;
            if(min==height[left]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public String longestPalindromeCenter(String s) {
        if(s.length()<2)return s;
        int length=s.length();
        char[] chars = s.toCharArray();

        int start=0;
        int maxLength=1;

        for(int i=0;i<length-1;i++){
            int odd = getMaxLengthFromCenter(chars,i,i);
            int even = getMaxLengthFromCenter(chars,i,i+1);
            int tempMax=Math.max(odd,even);
            if(tempMax>=maxLength){
                maxLength=tempMax;
                start=i-(maxLength-1)/2;
            }
            i=i;
        }
        return s.substring(start,start+maxLength);
    }

    private int getMaxLengthFromCenter(char[] chars, int l, int r) {
        int maxLength=0;
        for(;l>=0&&r<chars.length;l--,r++){
            if(chars[l]!=chars[r]){
                return maxLength;
            }else{
                maxLength=r-l+1;
            }
        }
        return maxLength;
    }

    public String longestPalindromeDynamic(String s) {
        if(s.length()<=1)return s;
       //动态规划
        int length = s.length();
        char[] chars = s.toCharArray();
        int start=0;
        int maxLength=1;//至少第一个字符回文，dp[0][0]=true
        boolean[][] dp=new boolean[length][length];
        for(int i=0;i<length-1;i++){
            dp[i][i]=true;
        }
        //dp[i][j]=dp[i+1][j-1] && chars[i]==chars[j]
        // i 行 j 列 先计算行，会用到未知值，所以要先计算列
        for(int j=1;j<=length-1;j++){
            for(int i=0;i<length-1;i++){
                if(i==j){
                    dp[i][j]=true;
                } else if(i==j-1){
                    dp[i][j] = (chars[i]==chars[j]);
                }else{
                    dp[i][j] = dp[i+1][j-1] && (chars[i]==chars[j]);
                }
                if(dp[i][j]&& j-i+1>maxLength){
                    start=i;
                    maxLength=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        //暴力解法
        char[] chars = s.toCharArray();
        int lenth=chars.length;
        int start=0;
        int maxLenth=0;
        for(int i=0;i<lenth-1;i++){
            for(int j=i+1;j<lenth;j++){
                if(isPalindrome(chars,i,j)&&(j-i+1>maxLenth)){
                    start=i;
                    maxLenth=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxLenth);
    }

    public boolean isPalindrome(char[] chars,int start,int end){
        if(start==end)return true;
        while(start<=end){
            if(chars[start]!=chars[end]){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }


    public int lengthOfLongestSubstring(String s) {
        if(s==null)return 0;
        char[] chars = s.toCharArray();
        int[] arrays= new int[127];
        int length=0,maxLength=0,j=0;
        for(int i=1;i<=chars.length;i++){
            char c=chars[i-1];
            if(arrays[c]==0){
                length++;
                arrays[c]=i;
                maxLength=length>maxLength?length:maxLength;
            }else{
                j=arrays[c]>j?arrays[c]:j;
                length=i-j;
                arrays[c]=i;
                maxLength=length>maxLength?length:maxLength;
            }
        }
        return maxLength;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a,b,sum=0,mod=0;
        ListNode head=null,current=null,listNode=null;
        while(true){
            if(l1==null&&l2==null){
                if(sum==0){
                    break;
                }
                else{
                    current.next=new ListNode(sum);
                    break;
                }
            } else if(l1==null){
                listNode=l2;
                a=0;
                b=l2.val;
                l2=l2.next;
            }else if(l2==null){
                listNode=l1;
                a=l1.val;
                b=0;
                l1=l1.next;
            }else{
                listNode=l1;
                a=l1.val;
                b=l2.val;
                l1=l1.next;
                l2=l2.next;
            }

            sum=(sum+a+b)/10;
            mod=(sum+a+b)%10;
            listNode.val=mod;
            if(head==null){
                head=listNode;
                current=listNode;
            }else{
                current.next=listNode;
                current=listNode;
            }
        }
        return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
