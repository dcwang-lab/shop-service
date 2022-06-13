package com.shop.commodity.mapper;

import com.shop.commodity.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:31
 * @Description: 商品mapper接口
 */
@Mapper
public interface CommodityMapper {

    /**
     * 商品列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<Commodity> listCommodities(Commodity queryParam);

    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return Commodity
     */
    Commodity getCommodity(Long id);

    /**
     * 更新商品信息
     *
     * @param param 参数
     */
    void update(Commodity param);

}
