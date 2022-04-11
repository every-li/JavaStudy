package com.imooc.lambda.cart;

/**
 * 对Sku的总价是否超过2000作为标准
 */
public class SkuTotalPricePredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
