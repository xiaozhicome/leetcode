package com.myself.leetcode.part2020;

import com.myself.leetcode.map.HashMap;

import java.util.PriorityQueue;

public class LFUCache {
    private int capacity;
    private int size;
    private int index;
    private HashMap<Integer, Node> cache;
    private PriorityQueue<Node> queue;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.size = 0;
        this.cache = new HashMap<>(capacity);
        if (capacity > 0) {
            this.queue = new PriorityQueue<>(capacity);
        }
    }

    public int get(int key) {
        //get from cache
        //null, return -1
        //not null,return value,times++,remove from old list,add to new list
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        queue.remove(node);
        node.times++;
        node.index = ++index;
        queue.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.capacity<=0){
            return;
        }
        //get from cache
        //null, new Node, offer to queue,
        //not null,return value,times++,remove from old list,add to new list
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value, index);
            //移除多余数据
            if(size>=capacity){
                Node poll = queue.poll();
                cache.remove(poll.key);
                size--;
            }
            queue.add(node);
            cache.put(key,node);
            size++;
        }else{
            queue.remove(node);
            node.times++;
            node.index = ++index;
            node.value=value;
            queue.add(node);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public class Node implements Comparable<Node> {
        private int key;
        private int value;
        private int times;
        private int index;

        public Node(int key, int value, int index) {
            this.key = key;
            this.value = value;
            this.times = 1;
            this.index = index;
        }


        @Override
        public int compareTo(Node node) {
            int diff = this.times - node.times;
            return diff == 0 ? this.index - node.index : diff;
        }

    }

}
