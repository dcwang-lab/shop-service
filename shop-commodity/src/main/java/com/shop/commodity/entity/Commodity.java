package com.shop.commodity.entity;

import com.shop.common.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author: dcWang
 * @Date: 2022/5/18 19:10
 * @Description: 商品实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Commodity extends BaseEntity {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String describe;

    /**
     * 商品规格id
     */
    private Long specsId;

    /**
     * 商品类型id
     */
    private Long typeId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品图片
     */
    private String filePath;

    /**
     * 商品库存
     */
    private Integer stock;

}
