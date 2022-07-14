package com.shop.user.bo;

import com.shop.common.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author: dcWang
 * @Date: 2022/7/11 16:07
 * @Description: 登录BO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginBO extends BaseEntity {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户性别(0 未知 1 男 2 女)
     */
    private Integer sex;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 用户余额
     */
    private BigDecimal balance;

}
