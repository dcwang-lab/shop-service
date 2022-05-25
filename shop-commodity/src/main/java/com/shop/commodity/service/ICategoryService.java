package com.shop.commodity.service;

import com.shop.commodity.entity.Category;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 15:07
 * @Description: 商品类别service接口
 */
public interface ICategoryService {

    /**
     * 商品类别列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Category> listCategories(Category queryParam);

}
