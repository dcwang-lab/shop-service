package com.shop.commodity.service;

import com.shop.commodity.entity.Commodity;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:44
 * @Description: 商品service接口
 */
public interface ICommodityService {

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Commodity> listCommodities(Commodity queryParam);

}
