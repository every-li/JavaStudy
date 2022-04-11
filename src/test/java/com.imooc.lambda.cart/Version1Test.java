package com.imooc.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * CartService测试类
 */
public class Version1Test {
    /**
     * 测试 filterElectronicSkus
     */
    @Test
    public void testFilterElectronicSkus() {
        CartService cartService = new CartService();
        List<Sku> skuList =
                cartService.filterElectronicSkus(CartService.getCartSkuList());
        System.out.println(
                JSON.toJSONString(skuList, true)
        );
    }
}
