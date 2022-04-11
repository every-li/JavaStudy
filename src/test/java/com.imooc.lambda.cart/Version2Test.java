package com.imooc.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version2Test {
    @Test
    public void testFilterSkusByCategory() {
        CartService cartService = new CartService();
        List<Sku> skuList =
                cartService.filterSkusByCategory(
                        CartService.getCartSkuList(),SkuCategoryEnum.BOOKS);

        System.out.println(
                JSON.toJSONString(skuList, true)
        );
    }
}
