package com.shop.user.dto;

import lombok.Data;

/**
 * @Author: dcWang
 * @Date: 2022/6/17 14:50
 * @Description: 登录dto
 */
@Data
public class LoginDTO {

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

}
