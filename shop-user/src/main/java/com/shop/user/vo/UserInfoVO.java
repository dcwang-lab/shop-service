package com.shop.user.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dcWang
 * @Date: 2022/6/14 9:22
 * @Description: 用户信息VO
 */
@Data
public class UserInfoVO {

    /**
     * 主键id
     */
    private Long id;

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
     * 用户头像
     */
    private String photo;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户性别text
     */
    private String sexText;

    public String getSexText() {
        if (sex == null) {
            return "";
        }
        switch (sex) {
            case 0: {
                return "未知";
            }
            case 1: {
                return "男";
            }
            case 2: {
                return "女";
            }
            default: {
                return "";
            }
        }
    }

}
