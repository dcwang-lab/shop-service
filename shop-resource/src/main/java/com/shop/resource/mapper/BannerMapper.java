package com.shop.resource.mapper;

import com.shop.resource.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 15:40
 * @Description: 轮播图mapper接口
 */
@Mapper
public interface BannerMapper {

    /**
     * 轮播图列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Banner> listBanners(Banner queryParam);

}
