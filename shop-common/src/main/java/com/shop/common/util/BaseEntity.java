package com.shop.common.util;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 19:04
 * @Description: 公共实体类
 */
@Data
public class BaseEntity {

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

    /**
     * 参数
     */
    private Map<String, Object> params;

}
