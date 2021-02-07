package com.myself.leetcode.part2020;

import java.util.*;

public class LadderLength {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        //预期5
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));

        String beginWord1 = "hit";
        String endWord1 = "cog";
        String[] wordList1 = {"hot", "dot", "dog", "lot", "log"};
        //预期0
        System.out.println(solution.ladderLength(beginWord1, endWord1, Arrays.asList(wordList1)));

        String beginWord2 = "a";
        String endWord2 = "c";
        String[] wordList2 = {"a", "b", "c"};
        //预期0
        System.out.println(solution.ladderLength(beginWord2, endWord2, Arrays.asList(wordList2)));

    }

    public static class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queueStart = new LinkedList<>();
            Set<String> setStart = new HashSet<>();
            queueStart.add(beginWord);
            setStart.add(beginWord);
            int step = 0;

            Queue<String> queueEnd = new LinkedList<>();
            Set<String> setEnd = new HashSet<>();
            queueEnd.add(endWord);
            setEnd.add(endWord);

            Set<String> allWordSet = new HashSet<>(wordList);
            if (!allWordSet.contains(endWord)) {
                return 0;
            }
//
            while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {

                if (queueEnd.size() < queueStart.size()) {
                    Queue<String> queue = queueStart;
                    queueStart = queueEnd;
                    queueEnd = queue;

                    Set<String> set = setStart;
                    setStart = setEnd;
                    setEnd = set;

                }
                int size = queueStart.size();
                step++;
                while (size > 0) {
                    size--;
                    String str = queueStart.poll();
                    char[] chars = str.toCharArray();

                    for (int i = 0; i < chars.length; i++) {
                        char c = chars[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            if (c == j) {
                                continue;
                            } else {
                                chars[i] = j;
                                String s = new String(chars);
                                if (setEnd.contains(s)) {
                                    return step + 1;
                                }
                                if (setStart.contains(s)) {
                                    continue;
                                }
                                if (allWordSet.contains(s)) {
                                    queueStart.add(s);
                                    setStart.add(s);
                                } else {
                                    continue;
                                }
                            }
                        }
                        chars[i] = c;
                    }
                }
            }
            return 0;
        }

    }
}
