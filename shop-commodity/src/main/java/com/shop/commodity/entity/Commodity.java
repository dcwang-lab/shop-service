package com.shop.commodity.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dcWang
 * @Date: 2022/5/18 19:10
 * @Description: 商品实体类
 */
@Data
public class Commodity {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String describe;

    /**
     * 商品类型
     */
    private Integer type;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品图片
     */
    private String filePath;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态(0 未删除 1 已删除)
     */
    private Integer delFlag;

}
