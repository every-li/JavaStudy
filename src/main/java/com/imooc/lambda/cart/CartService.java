package com.imooc.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {
    // 加入到购物车中的商品信息
    private static List<Sku> cartSkuList =
            new ArrayList<Sku>() {
                {
                    add(new Sku(654032, "无人机",
                            4999.00, 1,
                            4999.00, SkuCategoryEnum.ELECTRONICS));

                    add(new Sku(642934, "VR一体机",
                            2299.00, 1,
                            2299.00, SkuCategoryEnum.ELECTRONICS));

                    add(new Sku(645321, "纯色衬衫",
                            409.00, 3,
                            1227.00, SkuCategoryEnum.CLOTHING));

                    add(new Sku(654327, "牛仔裤",
                            528.00, 1,
                            528.00, SkuCategoryEnum.CLOTHING));

                    add(new Sku(675489, "跑步机",
                            2699.00, 1,
                            2699.00, SkuCategoryEnum.SPORTS));

                    add(new Sku(644564, "Java编程思想",
                            79.80, 1,
                            79.80, SkuCategoryEnum.BOOKS));

                    add(new Sku(678678, "Java核心技术",
                            149.00, 1,
                            149.00, SkuCategoryEnum.BOOKS));

                    add(new Sku(697894, "算法",
                            78.20, 1,
                            78.20, SkuCategoryEnum.BOOKS));

                    add(new Sku(696968, "TensorFlow进阶指南",
                            85.10, 1,
                            85.10, SkuCategoryEnum.BOOKS));
                }
            };

    /**
     * 获取商品信息
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * @param cartSkuList
     * @return
     * @Version 1.0.0
     * 获取购物车中所有电子产品
     */
    public List<Sku> filterElectronicSkus(List<Sku> cartSkuList) {
        List<Sku> skus = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)) {
                skus.add(sku);
            }
        }
        return skus;
    }

    /**
     * @param cartSkuList
     * @param category
     * @return
     * @Version 2.0.0
     * 根据传入商品类型的参数，返回相同商品类型的商品列表
     */
    public List<Sku> filterSkusByCategory(
            List<Sku> cartSkuList, SkuCategoryEnum category) {
        List<Sku> skus = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (sku.getSkuCategory().equals(category)) {
                skus.add(sku);
            }
        }
        return skus;
    }

    /**
     * @param cartSkuList
     * @param category
     * @param totalPrice
     * @param categoryOrPrice - true: 根据商品类型，false: 根据商品总价
     * @return
     * @Version 3.0.0
     * 支持通过商品类型或总价来过滤商品
     */
    public static List<Sku> filterSkus(
            List<Sku> cartSkuList, SkuCategoryEnum category,
            Double totalPrice, Boolean categoryOrPrice) {

        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {

            // 如果根据商品类型判断，sku类型与输入类型比较
            // 如果根据商品总价判断，sku总价与输入总价比较
            if (
                    (categoryOrPrice
                            && category.equals(sku.getSkuCategory())
                            ||
                            (!categoryOrPrice
                                    && sku.getTotalPrice() > totalPrice))) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * @param cartSkuList
     * @param predicate   不同的Sku判断标准策略
     * @return
     * @Version 4.00
     * 根据不同的Sku判断标准，对Sku列表进行过滤
     */
    public List<Sku> filterSkus(
            List<Sku> cartSkuList, SkuPredicate predicate) {
        List<Sku> skus = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            // 根据不同的Sku判断策略进行判断
            if (predicate.test(sku)) {
                skus.add(sku);
            }
        }
        return skus;
    }

}
