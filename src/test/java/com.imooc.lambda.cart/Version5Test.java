package com.imooc.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version5Test {
    @Test
    public void TestFilterSkus(){
        CartService cartService = new CartService();
        SkuPredicate skuPredicate = new SkuTotalPricePredicate();
        List<Sku> skus = cartService.filterSkus(CartService.getCartSkuList(), new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
            }
        });

        for(Sku sku : skus){
            System.out.println(
                    JSON.toJSONString(skus,true)
            );
        }
    }
}
