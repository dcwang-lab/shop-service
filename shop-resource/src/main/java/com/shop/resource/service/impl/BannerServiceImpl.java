package com.shop.resource.service.impl;

import com.shop.resource.entity.Banner;
import com.shop.resource.mapper.BannerMapper;
import com.shop.resource.service.IBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 15:41
 * @Description: 轮播图service接口实现
 */
@Service
public class BannerServiceImpl implements IBannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> listBanners(Banner queryParam) {
        return bannerMapper.listBanners(queryParam);
    }
}
