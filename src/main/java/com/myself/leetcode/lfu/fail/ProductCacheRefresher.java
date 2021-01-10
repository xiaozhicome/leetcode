package com.myself.leetcode.lfu.fail;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ProductCacheRefresher {
    Logger logger = Logger.getLogger("ProductCacheRefresher");

    private ProductCacheManagerImpl productCacheManagerImpl;

    public ProductCacheRefresher(ProductCacheManagerImpl productCacheManagerImpl) {
        this.productCacheManagerImpl = productCacheManagerImpl;
    }

    public void copy() {

        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        while (true) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    productCacheManagerImpl.copy();
                }
            } , 1 , TimeUnit.MINUTES);
        }
        

    }


    public void refresher() {
        
        new Thread() {
            public void run() {
                while (true) {
                    List<Long> topTen = productCacheManagerImpl.getTopTen();

                    for (Long key : topTen) {
                        logger.info("refresher get "+key+" from dbData");
                        productCacheManagerImpl.refresher();
                    }
                }
            }
        }.start();
    }
}
