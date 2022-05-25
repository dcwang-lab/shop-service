package com.shop.commodity.service.impl;

import com.shop.commodity.entity.Category;
import com.shop.commodity.mapper.CategoryMapper;
import com.shop.commodity.service.ICategoryService;
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
