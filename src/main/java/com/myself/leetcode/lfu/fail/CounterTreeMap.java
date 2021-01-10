package com.myself.leetcode.lfu.fail;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.TreeMap;

public class CounterTreeMap<T,V> extends TreeMap<T,V> {

    public CounterTreeMap() {
        super();
    }

    @Override
    public Comparator comparator() {
        Comparator comparator= new Comparator<V>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable<? super V>)o1).compareTo((V)o2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        return comparator;
    }
}
