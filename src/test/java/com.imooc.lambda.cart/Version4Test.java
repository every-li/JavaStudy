package com.imooc.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version4Test {
    @Test
    public void TestFilterSkus(){
        CartService cartService = new CartService();
        SkuPredicate skuPredicate = new SkuTotalPricePredicate();
        List<Sku> skus = cartService.filterSkus(CartService.getCartSkuList(),skuPredicate);

        for(Sku sku : skus){
            System.out.println(
                    JSON.toJSONString(skus,true)
            );
        }
    }
}
