package com.myself.leetcode.part2020.binarytree;

import java.util.LinkedList;
import java.util.Stack;

public class SearchNode {
    public static void main(String[] args) {
        SearchNode searchNode = new SearchNode();
        Node root = NodeUtil.getRandomTree();
        System.out.print("pre  order recursive: ");
        searchNode.preOrderRecursive(root);
        System.out.println();
        System.out.print("pre  order stack    : ");
        searchNode.preOrderStack(root);
        System.out.println();

        System.out.print("in   order recursive: ");
        searchNode.inOrderRecursive(root);
        System.out.println();
        System.out.print("in   order stack    : ");
        searchNode.inOrderStatck(root);
        System.out.println();

        System.out.print("post order recursive: ");
        searchNode.postOrderRecursive(root);
        System.out.println();
        System.out.print("post order stack    : ");
        searchNode.postOrderStack(root);
        System.out.println();

        System.out.print("dfs        recursive: ");
        searchNode.dfsRecursive(root);
        System.out.println();
        System.out.print("dfs        stack    : ");
        searchNode.dfsStack(root);
        System.out.println();

        System.out.print("bfs        queue    : ");
        searchNode.bfsQueue(root);
        System.out.println();
    }

    public void preOrderRecursive(Node root) {
        Node n = root;
        if (root == null) {
            return;
        }
        System.out.print(n.value + " ");
        preOrderRecursive(n.left);
        preOrderRecursive(n.right);
    }

    public void inOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.value + " ");
        inOrderRecursive(root.right);
    }

    public void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.value + " ");
    }

    public void preOrderStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
//        stack.push(node);//TODO 这一句千万不能要
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + " ");
                stack.push(node);
                node = node.left;
            }
//            while (!stack.isEmpty()){
            if (!stack.isEmpty()) {
                Node top = stack.pop();
                node = top.right;
            }
        }
    }

    public void inOrderStatck(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node top = stack.pop();
                System.out.print(top.value + " ");
                node = top.right;
            }
        }
    }

    public void postOrderStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node top = stack.peek();
                if (top.right == null || top.right == last) {
                    System.out.print(top.value + " ");
                    stack.pop();
                    last = top;
                    node = null;
                } else {
                    node = top.right;
                }
            }
        }
    }

    public void dfsRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        dfsRecursive(root.left);
        dfsRecursive(root.right);
    }

    public void dfsStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                System.out.print(node.value + " ");
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node top = stack.pop();
                node = top.right;
            }
        }
    }

    public void bfsQueue(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node node = list.removeFirst();
            System.out.print(node.value + " ");
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }
}
