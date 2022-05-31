package com.shop.commodity.controller;

import com.shop.commodity.entity.Commodity;
import com.shop.commodity.service.ICommodityService;
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
 * @Date: 2022/5/19 18:46
 * @Description: 商品controller
 */
@RestController
@RequestMapping("/commodity")
//@CrossOrigin
@Slf4j
public class CommodityController {

    @Resource
    private ICommodityService commodityService;

    @GetMapping("/listCommodities")
    public Result listCommodities(Commodity queryParam) {
        log.info("来了1111");
        List<Commodity> list = commodityService.listCommodities(queryParam);
        return Result.success().put("data", list);
    }

}
