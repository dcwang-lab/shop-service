package com.shop.product.service.impl;

import com.shop.product.entity.Category;
import com.shop.product.mapper.CategoryMapper;
import com.shop.product.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 15:07
 * @Description: 商品类别service实现
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategories(Category queryParam) {
        return categoryMapper.listCategories(queryParam);
    }
}
