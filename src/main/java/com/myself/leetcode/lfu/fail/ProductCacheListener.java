package com.myself.leetcode.lfu.fail;

import java.util.logging.Logger;

public class ProductCacheListener {
    Logger logger = Logger.getLogger("ProductProductCacheListener");
    private ProductCacheManagerImpl productCacheManagerImpl;
    public ProductCacheListener(ProductCacheManagerImpl productCacheManagerImpl) {
        this.productCacheManagerImpl = productCacheManagerImpl;
    }

    public void startListen() {
        new Thread() {
            public void run() {
                while (true) {
                    for (Long key : productCacheManagerImpl.getAllKeys()) {
                        if (productCacheManagerImpl.isTimeOut(key)) {
                            productCacheManagerImpl.clearByKey(key);
                            logger.info(key + "缓存被清除");
                        }
                    }
                }
            }
        }.start();
    }
}
