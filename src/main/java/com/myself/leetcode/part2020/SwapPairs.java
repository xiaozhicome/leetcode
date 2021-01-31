package com.myself.leetcode.part2020;

public class SwapPairs {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode node = listNode;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

        node = sulotion.swapPairs(listNode);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static class Sulotion {

        public ListNode swapPairs(ListNode head) {
            ListNode newHead = null;
            if (head != null && head.next != null) {
                newHead = head.next;
            } else {
                return head;
            }
            ListNode last = new ListNode(-1);//新建虚拟节点
            ListNode now = head;
            ListNode next = null;
            while (now != null && now.next != null) {//少一个
                next = now.next;

                last.next = next;
                ListNode temp = next.next;
                next.next = now;
                now.next = temp;

                last = now;
                now = temp;
            }

            return newHead;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
