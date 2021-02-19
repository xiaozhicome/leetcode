package com.myself.leetcode.part2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> list = solution.findWords(board, words);
        System.out.println(Arrays.toString(list.toArray()));//期望["eat","oath"]

        char[][] board2 = {{'a', 'b'}};
        String[] words2 = {"ba"};
        List<String> list2 = solution.findWords(board2, words2);
        System.out.println(Arrays.toString(list2.toArray()));//期望["ba"]

        char[][] board3 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words3 = {"oath", "pea", "eat", "rain", "hklf", "hf"};
        List<String> list3 = solution.findWords(board3, words3);
        System.out.println(Arrays.toString(list3.toArray()));//期望["oath","eat","hklf","hf"]

    }

    public static class Solution {

        public List<String> findWords(char[][] board, String[] words) {
            Trie root = new Trie();
            for (int i = 0; i < words.length; i++) {
                root.insert(words[i]);
            }
            boolean[][] used = new boolean[board.length][board[0].length];
            List<String> list = new LinkedList<>();
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    StringBuilder builder = new StringBuilder();
                    addStartValidWord(i, j, board, used, x, y, builder, root.root, list);
                }
            }
            list = list.stream().distinct().sorted().collect(Collectors.toList());
            return list;
        }

        private void addStartValidWord(int row,
                                       int column,
                                       char[][] board,
                                       boolean[][] used,
                                       int[] x, int[] y,
                                       StringBuilder builder,
                                       Node node,
                                       List<String> list) {
            if (row < 0 || row == board.length || column < 0 || column == board[0].length || used[row][column]) {
                return;
            }
            char c = board[row][column];
            int lastLength = builder.length();
            builder.append(c);
            used[row][column] = true;
            String s = builder.toString();
            if (node.get(c) != null) {
                if (node.get(c).isEnd) {
                    list.add(s);
                }
                for (int i = 0; i < x.length; i++) {
                    addStartValidWord(row + x[i], column + y[i], board, used, x, y, builder, node.get(c), list);
                }
            }
            builder.deleteCharAt(lastLength);
            used[row][column] = false;
            return;
        }

        private void addStartValidWordBad(int row,
                                          int column,
                                          char[][] board,
                                          boolean[][] used,
                                          int[] x, int[] y,
                                          StringBuilder builder,
                                          Trie root,
                                          List<String> list) {
            if (row < 0 || row == board.length || column < 0 || column == board[0].length || used[row][column]) {
                return;
            }
            char c = board[row][column];
            int lastLength = builder.length();
            builder.append(c);
            used[row][column] = true;
            String s = builder.toString();
            if (root.startsWith(s)) {
                if (root.search(s)) {
                    //当前字符串匹配，继续向后
                    list.add(s);
                    for (int i = 0; i < x.length; i++) {
                        addStartValidWordBad(row + x[i], column + y[i], board, used, x, y, builder, root, list);
                    }
                    builder.deleteCharAt(lastLength);
                    used[row][column] = false;
                    return;
                } else {
//                    builder.deleteCharAt(lastLength);
//                    used[row][column] = false;
                    //当前字符串不匹配，继续向后
                    for (int i = 0; i < x.length; i++) {
                        addStartValidWordBad(row + x[i], column + y[i], board, used, x, y, builder, root, list);
                    }
                    builder.deleteCharAt(lastLength);//TODO 回溯，总是忘记
                    used[row][column] = false;
                    return;
                }
            } else {
                builder.deleteCharAt(lastLength);
                used[row][column] = false;
                return;
            }
        }
    }


    public static class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

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
