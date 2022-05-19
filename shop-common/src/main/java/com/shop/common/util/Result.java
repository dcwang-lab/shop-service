package com.shop.common.util;


import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dcWang
 * @Date: 2022/1/6 17:25
 * @Description: 返回结果工具类
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", HttpStatus.OK.value());
        put("msg", "操作成功");
    }

    public static Result success() {
        return new Result();
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put("code", HttpStatus.OK.value());
        result.put("msg", msg);
        return result;
    }

    public static Result success(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result success(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static Result error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

}
