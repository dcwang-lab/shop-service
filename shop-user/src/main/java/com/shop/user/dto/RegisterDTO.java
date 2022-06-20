package com.shop.user.dto;

import lombok.Data;

/**
 * @Author: dcWang
 * @Date: 2022/6/17 14:56
 * @Description: 注册dto
 */
@Data
public class RegisterDTO {

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
     * 密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String photo;

}
