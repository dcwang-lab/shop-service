package com.shop.commodity.controller;

import com.shop.commodity.entity.Category;
import com.shop.commodity.service.ICategoryService;
import com.shop.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RestController
@RequestMapping("/category")
@CrossOrigin
@Slf4j
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
