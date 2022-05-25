package com.shop.commodity.mapper;

import com.shop.commodity.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 14:57
 * @Description: 商品类别mapper接口
 */
@Mapper
public interface CategoryMapper {

    /**
     * 商品类别列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Category> listCategories(Category queryParam);

}
