package com.shop.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: dcWang
 * @Date: 2022/6/17 15:07
 * @Description: 常用校验
 */
public class CheckUtils {


    /**
     * 是否为手机号
     *
     * @param str 参数
     * @return boolean
     */
    public static boolean isMobile(String str) {
        /*
          2019年1月16日已知(不含未知的，如有可以自行加入)
          中国电信号段：133,149,153,173,174,177,180,181,189,199
          中国联通号段：130,131,132,145,146,155,156,166,175,176,185,186
          中国移动号段：134(0-8),135,136,137,138,139,147,148,150,151,152,157,158,159,165,178,182,183,184,187,188,198
          上网卡专属号段（用于上网和收发短信，不能打电话）
              如中国联通的是145
              虚拟运营商  电信：1700,1701,1702  移动：1703,1705,1706  联通：1704,1707,1708,1709,171
                      星通信： 1349　　　   未知号段：141、142、143、144、154
        */
        if (StringUtils.isBlank(str)) {
            return false;
        }
        // 验证手机号
        String regular = "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";
        Pattern p = Pattern.compile(regular);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
