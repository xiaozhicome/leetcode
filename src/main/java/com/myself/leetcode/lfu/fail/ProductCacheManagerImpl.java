package com.myself.leetcode.lfu.fail;

import com.myself.leetcode.map.HashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class ProductCacheManagerImpl implements  ProductCacheManager{
    Logger logger = Logger.getLogger("ProductCacheManagerImpl");

    private transient static Map<Long, ProductCache> writeCaches =
            new LRULinkedHashMap(4);

    private transient static Map<Long, ProductCache> readCaches =
            new ConcurrentHashMap<>();


    private transient static TreeMap<Long, Long> counter =
            new CounterTreeMap<>();


    private static Map<Long, Product>  dbData=
            new HashMap<>();

    static {
        dbData.put(1L, new Product(1L,"1t","1d"));
        dbData.put(2L, new Product(2L,"2t","2d"));
        dbData.put(3L, new Product(3L,"3t","3d"));
        dbData.put(4L, new Product(4L,"4t","4d"));
        dbData.put(5L, new Product(5L,"5t","5d"));
        dbData.put(6L, new Product(6L,"6t","6d"));
        dbData.put(7L, new Product(7L,"7t","7d"));
        dbData.put(8L, new Product(8L,"8t","8d"));
        dbData.put(9L, new Product(9L,"9t","9d"));
        dbData.put(10L, new Product(10L,"10t","10d"));
    }
    /**
     * 存入缓存
     */
    public void putCache(Long key, ProductCache cache) {
        writeCaches.put(key,cache);
    }

    /**
     * 获取热点4个
     */
    public List<Long> getTopTen(){
        List cachesKey=new ArrayList<Long>(10);
        Set<Map.Entry<Long, Long>> entries = counter.entrySet();
        Iterator<Map.Entry<Long, Long>> iterator = entries.iterator();
        for(int i=0;i<4&&iterator.hasNext();i++){
            Map.Entry<Long, Long> next = iterator.next();
            cachesKey.add(next.getKey());
        }
        return cachesKey;
    }

    /**
     * 存入缓存
     */
    public void putCache(Long key, Product datas) {
        putCache(key, new ProductCache(datas,System.currentTimeMillis()));
    }

    /**
     * 获取对应缓存
     */
    public ProductCache getCacheByKey(Long key) {
        if(counter.containsKey(key)){
            counter.put(key,counter.get(key)+1);
        }else{
            counter.put(key,1L);
        }
        logger.info("count "+readCaches.toString());

        if (readCaches.containsKey(key)) {
            logger.info("get "+key+" from readCaches "+readCaches.toString());
            return readCaches.get(key);
        }
        logger.info("get "+key+" from dbData");
        return getFromDB(key);
    }

    /**
     * 从数据库读取数据
     */
    public ProductCache getFromDB(Long key) {
        ProductCache productCache = new ProductCache(dbData.get(key),System.currentTimeMillis());
        return productCache;
    }

    /**
     * 获取对应缓存
     */
    public Product getCacheDataByKey(Long key) {
        return getCacheByKey(key).getDatas();
    }

    /**
     * 获取所有缓存
     */
    public Map<Long, ProductCache> getCacheAll() {
        return writeCaches;
    }

    /**
     * 判断是否在缓存中
     */
    public boolean isContains(Long key) {
        return counter.containsKey(key);
    }

    /**
     * 清除所有缓存
     */
    public void clearAll() {
        counter.clear();
        writeCaches.clear();
    }

    /**
     * 清除对应缓存
     */
    public void clearByKey(Long key) {
        if (isContains(key)) {
            counter.remove(key);
            writeCaches.remove(key);
        }
    }

    /**
     * 缓存是否超时失效
     */
    public boolean isTimeOut(Long key) {
        if (!isContains(key)) {
            return true;
        }
        ProductCache cache = writeCaches.get(key);
        long timeOut = cache.getTimeOut();
        long lastRefreshTime = cache.getLastRefreshTime();
        if (timeOut == 0 || System.currentTimeMillis() - lastRefreshTime >= timeOut) {
            return true;
        }
        return false;
    }

    /**
     * 获取所有key
     */
    public Set<Long>  getAllKeys() {
        return readCaches.keySet();
    }

    /**
     * 复制写到读
     */
    public void copy() {
        synchronized (readCaches){
            readCaches.clear();
            readCaches.putAll(writeCaches);
        }
    }

    /**
     * 刷新写
     */
    public void refresher() {
        synchronized(writeCaches){
            List<Long> topTen = getTopTen();
            for (Long key : topTen) {
                logger.info("refresher get "+key+" from dbData");
                ProductCache fromDB = getFromDB(key);
                writeCaches.put(key,fromDB);
            }
        }
    }
}
