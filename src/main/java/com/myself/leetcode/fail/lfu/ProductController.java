/*
package com.myself.part2020.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("product/")
public class ProductController {

    private ProductCacheManager productCacheManager=new ProductCacheManagerImpl();

    @GetMapping("get")
    public Product getProduct(@RequestParam Long key){
        Product cacheDataByKey = productCacheManager.getCacheDataByKey(key);
        return cacheDataByKey;
    }
}
*/
