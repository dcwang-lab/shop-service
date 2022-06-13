package com.shop.user.entity;

import com.shop.common.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dcWang
 * @Date: 2022/6/13 15:47
 * @Description: 用户实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户性别(0 未知 1 男 2 女)
     */
    private String sex;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 用户余额
     */
    private String balance;

}
