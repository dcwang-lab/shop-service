package com.shop.product.mapper;

import com.shop.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:31
 * @Description: 商品mapper接口
 */
@Mapper
public interface ProductMapper {

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Product> listProducts(Product queryParam);

    /**
     * 获取商品详情
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
