package com.myself.leetcode.fail.lfu;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public interface ProductCacheManager {
    
    void putCache(Long key, ProductCache cache);

    
    void putCache(Long key, Product datas);


    ProductCache getCacheByKey(Long key);

   
    Product getCacheDataByKey(Long key);

   
    Map<Long, ProductCache> getCacheAll();

   
    boolean isContains(Long key);

    
    void clearAll();

   
    void clearByKey(Long key);

   
    boolean isTimeOut(Long key);

   
    Set<Long> getAllKeys();

}
