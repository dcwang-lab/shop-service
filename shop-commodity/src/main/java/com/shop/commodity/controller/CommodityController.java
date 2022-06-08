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
@RestController
@RequestMapping("/commodity")
@Slf4j
public class CommodityController {

    @Resource
    private ICommodityService commodityService;

    @GetMapping("/listCommodities")
    @ResponseBody
    public Result listCommodities(Commodity queryParam) {
        log.info("来了1111");
        List<Commodity> list = commodityService.listCommodities(queryParam);
        return Result.success().put("data", list);
    }

}
