package com.shop.commodity.controller;

import com.shop.commodity.entity.Commodity;
import com.shop.commodity.service.ICommodityService;
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
@RequestMapping("/commodity")
public class CommodityController {

    @Resource
    private ICommodityService commodityService;

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return Result
     */
    @GetMapping("/listCommodities")
    public Result listCommodities(Commodity queryParam) {
        List<Commodity> list = commodityService.listCommodities(queryParam);
        return Result.success().put("data", list);
    }

    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return Result
     */
    @GetMapping("/getCommodity/{id}")
    public Result getCommodity(@PathVariable("id") Long id) {
        return Result.success().put("data", commodityService.getCommodity(id));
    }

    /**
     * 更新商品信息
     *
     * @param param 参数
     * @return Result
     */
    @PutMapping("/updateCommodity")
    public Result updateCommodity(@RequestBody Commodity param) {
        commodityService.update(param);
        return Result.success("更新商品信息成功");
    }

}
