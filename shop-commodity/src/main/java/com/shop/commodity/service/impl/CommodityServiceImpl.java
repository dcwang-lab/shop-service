package com.shop.commodity.service.impl;

import com.shop.commodity.entity.Commodity;
import com.shop.commodity.mapper.CommodityMapper;
import com.shop.commodity.service.ICommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:45
 * @Description: 商品service实现
 */
@Service
public class CommodityServiceImpl implements ICommodityService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> listCommodities(Commodity queryParam) {
        return commodityMapper.listCommodities(queryParam);
    }
}
