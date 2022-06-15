package com.shop.resource.service;

import com.shop.resource.entity.Banner;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 15:40
 * @Description: 轮播图service接口
 */
public interface IBannerService {

    /**
     * 轮播图列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Banner> listBanners(Banner queryParam);

}
