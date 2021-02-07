package com.myself.leetcode.part2020;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }


    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (node.contain(c)) {
                node = node.get(c);
            } else {
                node = node.put(c);
            }
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (node.contain(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (node.contain(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static class Node {

        private static final int N = 26;

        private Node[] array;

        private boolean isEnd;

        public Node() {
            array = new Node[26];
        }

        public Node put(char c) {
            Node node = new Node();
            array[c - 'a'] = node;
            return node;
        }

        public Node get(char c) {
            return array[c - 'a'];
        }

        public boolean contain(char c) {
            return array[c - 'a'] != null;
        }

        public void setEnd(boolean b) {
            isEnd = b;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }

}
