package com.myself.leetcode;

import com.myself.leetcode.lfu.fail.ProductCacheListener;
import com.myself.leetcode.lfu.fail.ProductCacheManagerImpl;
import com.myself.leetcode.lfu.fail.ProductCacheRefresher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCacheTests {

    Logger logger = Logger.getLogger("cacheLog");
    /**
     * 测试缓存和缓存失效
     */
    @Test
    public void testCacheManager() {
        ProductCacheManagerImpl cacheManagerImpl = new ProductCacheManagerImpl();

        ProductCacheListener listener = new ProductCacheListener(cacheManagerImpl);
        listener.startListen();
        ProductCacheRefresher refresher = new ProductCacheRefresher(cacheManagerImpl);
        refresher.refresher();
        refresher.copy();
        logger.info("1:" + cacheManagerImpl.getCacheByKey(1L).getDatas());
        logger.info("2:" + cacheManagerImpl.getCacheByKey(2L).getDatas());
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("1:" + cacheManagerImpl.getCacheByKey(1L).getDatas());
        logger.info("2:" + cacheManagerImpl.getCacheByKey(2L).getDatas());
    }

    /**
     * 测试线程安全
     */
    @Test
    public void testThredSafe() {
        final Long key = 1L;
        final ProductCacheManagerImpl cacheManagerImpl = new ProductCacheManagerImpl();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
        }


    }

    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            int[] r=new int[nums.length];
            HashMap<Integer, Integer> valueToIndex = new HashMap<>();
            for(int i=0;i<nums.length-1;i++){
                r[i]=target-nums[i];
                valueToIndex.put(nums[i],i);
                if(valueToIndex.keySet().contains(r[i])){
                    return new int[]{valueToIndex.get(r[i]),i};
                }
            }
            return null;
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Character peek='c';
            for(int i=0; i<s.length();i++){
                Character charAt = s.charAt(i);
                peek='c';
                if (!stack.empty()){
                    peek = stack.peek();
                }
                if((peek.equals('(')&&charAt.equals(')'))||
                        (peek.equals('[')&&charAt.equals(']'))||
                        (peek.equals('{')&&charAt.equals('}'))){
                    stack.pop();
                } else {
                    stack.push(charAt);
                }
            }
            return stack.empty();
        }

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode listNode1=l1;
            ListNode listNode2=l2;
            ListNode listNode3First=l2.val>l1.val?new ListNode(l2.val):new ListNode((l1.val));
            ListNode listNode3=listNode3First;
            while(true){

                if(listNode1==null&&listNode2==null){
                    break;
                }else if(listNode1==null&&listNode2!=null){
                    listNode3.next=new ListNode(listNode2.val);
                    listNode3=listNode3.next;

                    listNode2=listNode2.next;
                }else if(listNode1!=null&&listNode2==null){
                    listNode3.next=new ListNode(listNode1.val);
                    listNode3=listNode3.next;

                    listNode1=listNode1.next;
                }else{
                    int val1 = listNode1.val;
                    int val2 = listNode2.val;

                    if(val2>val1){
                        listNode3.next=new ListNode(val2);
                        listNode3=listNode3.next;

                        listNode2=listNode2.next;
                    }else{
                        listNode3.next=new ListNode(val1);
                        listNode3=listNode3.next;

                        listNode1=listNode1.next;
                    }
                }
            }

            return listNode3First;
        }

        public int maxSubArray(int[] nums) {
            int res=nums[0];
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(sum>0){
                    sum+=nums[i];
                }else{
                    sum=nums[i];
                }
                res=sum>res?sum:res;
            }
            return res;
        }


        public int climbStairs(int n) {
            if(n==0)return 0;
            else if(n==1)return 1;
            else if (n==2)return 2;

            int [] way=new int[n];
            way[0]=0;
            way[1]=1;
            way[2]=2;
            for(int i=3;i<n;i++){
                way[i]=way[i-2]+way[i-1];
            }
            return way[n-2]+way[n-1];
        }

        public int minCostClimbingStairs(int[] cost) {
            int n=cost.length;
            int [] way=new int[n];
            if(n==1)return cost[0];
            if(n==2)return cost[1];
            way[0]=cost[0];
            way[1]=cost[1];
            int sum=0;
            for(int i=2;i<n;i++){
                way[i]=cost[i]+(way[i-2]<way[i-1]?way[i-2]:way[i-1]);
                System.out.println(i+" : "+way[i]);
            }

            return way[n-2]<way[n-1]?way[n-2]:way[n-1];
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public boolean isSymmetric(TreeNode root) {
            if(root==null)return true;
            return isSymmetric(root.left,root.right);
        }

        public boolean isSymmetric(TreeNode a,TreeNode b) {
            if(a==null&&b==null)return  true;
            else if(a!=null&&b!=null){
                return a.val==b.val&&isSymmetric(a.left,b.right)&&isSymmetric(a.right,b.left);
            }else return false;
        }

        public int maxDepth(TreeNode root) {
            if(root==null)return 0;
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }

        public int maxProfit(int[] prices) {
            if(prices.length==0)return 0;
            int min=prices[0];
            int diff=0;
            for(int i=0;i<prices.length;i++){
                if(prices[i]-min>diff){
                    diff=prices[i]-min;
                }

                if(prices[i]<min){
                    min=prices[i];
                }
            }
            return diff;
        }

        public int singleNumber(int[] nums) {
            int res=nums[0];
            for(int i=0;i<nums.length;i++){
                res=res^nums[i];
            }
            return res;
        }

        public boolean hasCycle(ListNode head) {
            int index=0;
            ListNode p;
            Set<String> set = new HashSet<>();
            if(head==null)return false;
            while(head.next!=null){
                boolean exist=set.add(head.toString());
                if(exist==false)return true;
                head=head.next;
            }
            return false;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] prices={7,1,5,3,6,4};
            System.out.println(solution.maxProfit(prices));
        }
    }
}
