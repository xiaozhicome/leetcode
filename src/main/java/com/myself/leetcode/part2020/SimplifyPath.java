package com.myself.leetcode.part2020;

import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        Sulotion sulotion = new Sulotion();
        System.out.println(sulotion.simplifyPath("/home/"));//预期"/home"
        System.out.println(sulotion.simplifyPath("/../"));//预期"/"
        System.out.println(sulotion.simplifyPath("/home//foo/"));//预期"/home/foo"
        System.out.println(sulotion.simplifyPath("/a/./b/../../c/"));//预期"/c"
        System.out.println(sulotion.simplifyPath("/a/../../b/../c//.//"));//预期"/c"
        System.out.println(sulotion.simplifyPath("/a//b////c/d//././/.."));//预期"/a/b/c"
    }

    public static class Sulotion {

        public String simplifyPath(String path) {
            LinkedList<String> list = new LinkedList<>();
            int last = 0;
            boolean start = false;
            for (int i = 1; i < path.length(); i++) {
                char c = path.charAt(i);
                if (!start && c != '/') {
                    last = i;
                    start = true;
//                } else if (start && (c == '/' || i == path.length() - 1)) {//TODO
                } else if (start && c == '/') {
                    String s = path.substring(last, i);
                    start = false;
                    if (s.equals(".")) {
                        continue;
                    } else if (s.equals("..")) {
                        if (list.size() > 0) {
                            list.removeLast();
                        } else {
                            continue;
                        }
                    } else {
                        list.add(s);
                    }
                }
                if (start && i == path.length() - 1) {//TODO
                    String s = path.substring(last);
                    start = false;
                    if (s.equals(".")) {
                        continue;
                    } else if (s.equals("..")) {
                        if (list.size() > 0) {
                            list.removeLast();
                        } else {
                            continue;
                        }
                    } else {
                        list.add(s);
                    }
                }
            }
            if (list.size() == 0) {//TODO
                return "/";
            }
            StringBuilder builder = new StringBuilder();
            list.forEach(s -> builder.append("/").append(s));
            return builder.toString();
        }


    }


}
