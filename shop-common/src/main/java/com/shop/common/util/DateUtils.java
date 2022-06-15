package com.shop.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: dcWang
 * @Date: 2021/9/3 15:10
 * @Description: 日期工具类
 */
public class DateUtils {


    private static final Date DATE = new Date();

    private static final String YEAR = "yyyy";

    private static final String MONTH = "MM";

    private static final String DAY = "dd";

    private static final String YEAR_MONTH = "yyyy-MM";

    private static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

    private static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

    private static final String[] PARSE_PATTERNS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前年份
     *
     * @return 当前年份
     */
    public static String getYear() {
        return parseDate(YEAR).format(DATE);
    }

    /**
     * 获取当前月份
     *
     * @return 当前月份
     */
    public static String getMonth() {
        return parseDate(MONTH).format(DATE);
    }

    /**
     * 获取当前天号
     *
     * @return 当前天号
     */
    public static String getDay() {
        return parseDate(DAY).format(DATE);
    }

    /**
     * 获取当前年月
     *
     * @return 当前年月
     */
    public static String getYearMonth() {
        return parseDate(YEAR_MONTH).format(DATE);
    }

    /**
     * 获取当前年月日
     *
     * @return 当前年月日
     */
    public static String getYearMonthDay() {
        return parseDate(YEAR_MONTH_DAY).format(DATE);
    }

    /**
     * 获取当前日期String类型
     *
     * @return 当前日期String类型
     */
    public static String getStrNowDate() {
        return parseDate(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND).format(DATE);
    }

    /**
     * 获取当前日期Date类型
     *
     * @return 当前日期Date类型
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 日期类型转日期字符串
     *
     * @param date 需转换的日期
     * @return 日期字符串
     */
    public static String parseDateToStr(Date date) {
        if (date == null) {
            return null;
        }
        return parseDate(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND).format(date);
    }

    /**
     * 日期字符串转日期类型
     *
     * @param str 日期字符串
     * @return 日期
     */
    public static Date parseStrToDate(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            return parseDate(str, PARSE_PATTERNS);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
            return null;
        }
    }

    /**
     * 获取近十二月的日期集合
     *
     * @param contain 是否包含当月 0不包含 1包含
     * @return 近十二月的日期集合不包含当月
     */
    public static List<String> getTwelveMonths(int contain) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            List<String> last12Months = new ArrayList<>(12);
            Calendar cal = Calendar.getInstance();
            // 要先+1,才能把本月的算进去
            int calendar = cal.get(Calendar.MONTH);
            if (contain != 0) {
                calendar = cal.get(Calendar.MONTH) + 1;
            }
            cal.set(Calendar.MONTH, calendar);
            int length = 12;
            for (int i = 0; i < length; i++) {
                // 逐次往前推1个月
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
                last12Months.add(sdf.format(sdf.parse(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1))));
            }
            return last12Months;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("获取十二个月集合失败");
        }
        return new ArrayList<>();
    }

    /**
     * 获取两个日期的时间差
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return String[] [0]天 [1]小数 [2]分钟 [3]秒
     */
    public static String[] getDatePoor(Date startDate, Date endDate) {
        StringJoiner joiner = new StringJoiner(",");
        // 毫秒换算天
        long day = 1000 * 60 * 60 * 24;
        // 毫秒换算小时
        long hours = 1000 * 60 * 60;
        // 毫秒换算分钟
        long minute = 1000 * 60;
        // 毫秒换算秒
        long second = 1000;
        // 计算两个时间的毫秒差
        long diff = endDate.getTime() - startDate.getTime();
        joiner.add(String.valueOf(diff / day));
        joiner.add(String.valueOf(diff / hours));
        joiner.add(String.valueOf(diff / minute));
        joiner.add(String.valueOf(diff / second));
        return joiner.toString().split(",");
    }

    /**
     * 日期格式化
     *
     * @param format 日期格式
     * @return SimpleDateFormat对象
     */
    private static SimpleDateFormat parseDate(String format) {
        return new SimpleDateFormat(format);
    }

    private static Date parseDate(final String str, final String... parsePatterns) throws ParseException {
        return parseDate(str, null, parsePatterns);
    }

    private static Date parseDate(final String str, final Locale locale, final String... parsePatterns) throws ParseException {
        return parseDateWithLeniency(str, locale, parsePatterns, true);
    }

    private static Date parseDateWithLeniency(final String str, final Locale locale, final String[] parsePatterns,
                                              final boolean lenient) throws ParseException {
        if (str == null || parsePatterns == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }

        SimpleDateFormat parser;
        if (locale == null) {
            parser = new SimpleDateFormat();
        } else {
            parser = new SimpleDateFormat("", locale);
        }

        parser.setLenient(lenient);
        final ParsePosition pos = new ParsePosition(0);
        for (final String parsePattern : parsePatterns) {

            String pattern = parsePattern;

            // LANG-530 - need to make sure 'ZZ' output doesn't get passed to SimpleDateFormat
            if (parsePattern.endsWith("ZZ")) {
                pattern = pattern.substring(0, pattern.length() - 1);
            }

            parser.applyPattern(pattern);
            pos.setIndex(0);

            String str2 = str;
            // LANG-530 - need to make sure 'ZZ' output doesn't hit SimpleDateFormat as it will ParseException
            if (parsePattern.endsWith("ZZ")) {
                str2 = str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2");
            }

            final Date date = parser.parse(str2, pos);
            if (date != null && pos.getIndex() == str2.length()) {
                return date;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

}
