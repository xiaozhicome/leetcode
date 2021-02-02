package com.myself.leetcode.part2020.binarytree;

import com.myself.leetcode.part2020.sort.SortUtil;

import java.util.Random;

public class NodeUtil {
    public static final int N = 10;
    public static final int LIMIT = 100;

    public static Node getRandomTree() {
        int[] baseArray = new int[LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            baseArray[i] = i;
        }
        Random random = new Random();
        int num = random.nextInt(LIMIT - 1) + 1;
        Node root = new Node(baseArray[num]);
        SortUtil.swap(baseArray, num, LIMIT-1);
        for (int i = 1; i < N; i++) {
            num = random.nextInt(LIMIT - 1 - i) + 1;
            Node node = new Node(baseArray[num]);
            SortUtil.swap(baseArray, num, LIMIT - 1 - i);
            addNode(root, node);
        }
        return root;
    }

    private static void addNode(Node root, Node node) {
        if (root == null) {
            return;
        }
        Node n = root;
        while (true)
            if (node.value < n.value) {
                if (n.left == null) {
                    n.left = node;
                    return;
                } else {
                    n = n.left;
                }
            } else {
                if (n.right == null) {
                    n.right = node;
                    return;
                } else {
                    n = n.right;
                }
            }
    }

}
