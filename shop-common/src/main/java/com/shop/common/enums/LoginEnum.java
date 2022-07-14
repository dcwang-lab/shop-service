package com.shop.common.enums;

/**
 * @Author: dcWang
 * @Date: 2022/7/14 15:10
 * @Description: 登陆状态
 */
public enum LoginEnum {

    LOGIN_SUCCESS(1, "登陆成功!"), NON_EXISTENT(2, "登陆失败,手机号不存在!"),
    PASSWORD_ERROR(3, "登陆失败,密码错误!"), ERROR(4, "登陆失败,系统异常!");

    private final Integer code;
    private final String message;

    LoginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
