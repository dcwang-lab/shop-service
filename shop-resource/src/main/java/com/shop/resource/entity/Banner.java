package com.shop.resource.entity;

import com.shop.common.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 15:37
 * @Description: banner实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Banner extends BaseEntity {

    /**
     * 类型
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String describe;

    /**
     * 文件路径
     */
    private String filePath;

}
