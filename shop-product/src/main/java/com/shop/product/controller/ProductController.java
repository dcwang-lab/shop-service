package com.shop.product.controller;

import com.shop.product.entity.Product;
import com.shop.product.service.IProductService;
import com.shop.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:46
 * @Description: 商品controller
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService commodityService;

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return Result
     */
    @GetMapping("/listProducts")
    public Result listCommodities(Product queryParam) {
        List<Product> list = commodityService.listProducts(queryParam);
        return Result.success().put("data", list);
    }

    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return Result
     */
    @GetMapping("/getProduct/{id}")
    public Result getCommodity(@PathVariable("id") Long id) {
        return Result.success().put("data", commodityService.getProduct(id));
    }

    /**
     * 更新商品信息
     *
     * @param param 参数
     * @return Result
     */
    @PutMapping("/updateProduct")
    public Result updateProduct(@RequestBody Product param) {
        commodityService.update(param);
        return Result.success("更新商品信息成功");
    }

}
