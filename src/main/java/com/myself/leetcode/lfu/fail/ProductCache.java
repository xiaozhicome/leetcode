package com.myself.leetcode.lfu.fail;


public class ProductCache {

   
    private  Product datas;

    
    private  long timeOut=5;

    
    private  long lastRefreshTime;


    public ProductCache(Product datas, long lastRefreshTime) {
        this.datas = datas;
        this.lastRefreshTime = lastRefreshTime;
    }
    public Product getDatas() {
        return datas;
    }
    public void setDatas(Product datas) {
        this.datas = datas;
    }
    public long getTimeOut() {
        return timeOut;
    }
    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
    public long getLastRefreshTime() {
        return lastRefreshTime;
    }
    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    @Override
    public String toString() {
        return "ProductCache{" +
                "datas=" + datas +
                ", timeOut=" + timeOut +
                ", lastRefreshTime=" + lastRefreshTime +
                '}';
    }
}
