package com.shop.resource.controller;

import com.shop.common.util.Result;
import com.shop.resource.entity.Banner;
import com.shop.resource.service.IBannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 15:41
 * @Description: 轮播图controller
 */
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Resource
    private IBannerService bannerService;

    @GetMapping("/listBanners")
    public Result listBanners(Banner queryParam) {
        List<Banner> list = bannerService.listBanners(queryParam);
        return Result.success("轮播图列表查询成功!").put("data", list);
    }

}
