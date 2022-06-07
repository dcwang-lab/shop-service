package com.shop.commodity.entity;

import com.shop.common.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 14:54
 * @Description: 商品类别实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends BaseEntity {

    /**
     * 上级id
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

}
