package com.myself.leetcode.part2020.hard;

import java.util.LinkedList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(sulotion.fullJustify(words1, maxWidth1));
        /**
         * 预期
         * [
         *    "This    is    an",
         *    "example  of text",
         *    "justification.  "
         * ]
         */
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println(sulotion.fullJustify(words2, maxWidth2));
        /**
         * 预期
         * [
         *   "What   must   be",
         *   "acknowledgment  ",
         *   "shall be        "
         * ]
         */
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println(sulotion.fullJustify(words3, maxWidth3));
        /**
         * 预期
         * [
         *   "Science  is  what we",
         *   "understand      well",
         *   "enough to explain to",
         *   "a  computer.  Art is",
         *   "everything  else  we",
         *   "do                  "
         * ]
         */

    }

    public static class Sulotion {

        /**
         * 一个单词左对齐
         * 最后一行左对齐
         */
        public List<String> fullJustify(String[] words, int maxWidth) {
            LinkedList<String> list = new LinkedList<>();
            int oneLineSum = 0;
            int wordSum = 0;
            int oneLineStart = 0;
            int oneLineEnd = 0;
            for (int i = 0; i < words.length; ) {
                while (true) {
                    if (oneLineSum > 0) {
                        oneLineSum += 1;
                    }
                    oneLineSum += words[i].length();
                    wordSum += words[i].length();
                    if (i >= words.length - 1 || oneLineSum + 1 + words[i + 1].length() > maxWidth) {//TODO 当前退出
                        break;
                    }
                    i++;
                }
                oneLineEnd = i;
                int gapNum = oneLineEnd - oneLineStart;
                int blankAverage = 0;
                int blankLeft = 0;
                if (oneLineEnd == words.length - 1) {//TODO 最后一行
                    blankAverage = 1;
                    blankLeft = 0;
                } else if (gapNum == 0) {//TODO 单行只有一个单词
                    blankAverage = maxWidth - wordSum;
                    blankLeft = 0;
                } else {
                    blankAverage = (maxWidth - wordSum) / gapNum;
                    blankLeft = (maxWidth - wordSum) % gapNum;
                }
                StringBuilder builder = new StringBuilder();
                for (int j = oneLineStart; j <= oneLineEnd; j++) {
                    builder.append(words[j]);
                    if (j == words.length - 1) {//TODO 最后一行特殊处理
                        int last = maxWidth - wordSum - blankAverage * gapNum;
                        for (int k = 0; k < last; k++) {
                            builder.append(" ");
                        }
                        break;
                    }
                    if (gapNum != 0 && j == oneLineEnd) {//TODO 每行多个单词时，最后一个单词
                        break;
                    }
//                    for (int k = 0; k < blankAverage + blankLeft; k++) {//TODO 平均空格数
                    for (int k = 0; k < blankAverage; k++) {
                        builder.append(" ");
                    }
                    if (blankLeft > 0) {
//                        blankLeft--;//TODO 不平均空格数
                        builder.append(" ");
                        blankLeft--;
                    }
                }
                System.out.println(builder.toString());
                System.out.println(builder.toString().length());
                list.add(builder.toString());
                i++;
                oneLineStart = i;
                oneLineSum = 0;
                wordSum = 0;
            }
            return list;
        }


    }


}
