package com.shop.product.service;

import com.shop.product.entity.Product;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:44
 * @Description: 商品service接口
 */
public interface IProductService {

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Product> listProducts(Product queryParam);

    /**
     * 获取商品信息
     *
     * @param id 商品id
     * @return Commodity
     */
    Product getProduct(Long id);

    /**
     * 更新商品信息
     *
     * @param param 参数
     */
    void update(Product param);

}
