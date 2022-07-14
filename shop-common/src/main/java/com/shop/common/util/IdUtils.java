package com.shop.common.util;

import com.shop.common.constant.StringConstant;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: dcWang
 * @Date: 2022/7/5 16:57
 * @Description: id生成器
 */
public class IdUtils {

    /**
     * 生成用户id
     *
     * @return String
     */
    public static String createUserId() {
        String regex = "[^0-9]";
        String uuid = UUID.randomUUID().toString();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uuid);
        return matcher.replaceAll(StringConstant.EMPTY).trim() + System.currentTimeMillis();
    }

}
