package com.shop.product.controller;

import com.shop.product.entity.Category;
import com.shop.product.service.ICategoryService;
import com.shop.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 15:08
 * @Description: 商品类别controller
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    /**
     * 商品类别列表查询
     *
     * @param queryParam 查询条件
     * @return Result
     */
    @GetMapping("/listCategories")
    public Result listCategories(Category queryParam) {
        List<Category> list = categoryService.listCategories(queryParam);
        return Result.success().put("data", list);
    }

}
