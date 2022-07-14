package com.shop.user.dto;

import lombok.Data;

/**
 * @Author: dcWang
 * @Date: 2022/7/14 15:46
 * @Description: 用户查询DTO
 */
@Data
public class QueryUserDTO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 手机号
     */
    private String phone;

}
