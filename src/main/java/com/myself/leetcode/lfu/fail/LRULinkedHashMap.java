package com.myself.leetcode.lfu.fail;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap extends LinkedHashMap {

    private int size;

    public LRULinkedHashMap(int originalSize){
        super(originalSize,0.75f,true);
        this.size=originalSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if(super.size()>size)return true;
        return false;
    }
}
