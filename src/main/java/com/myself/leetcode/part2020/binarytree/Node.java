package com.myself.leetcode.part2020.binarytree;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
