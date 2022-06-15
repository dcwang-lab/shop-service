package com.shop.common.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/14 14:33
 * @Description: 常量
 */
public class FileConstant {

    /**
     * 常见图片类型
     */
    public static final List<String> IMAGE_TYPES = Arrays.asList("png", "jpg", "gif", "svg", "bmp", "tif", "apng", "pcd", "psd");

    /**
     * 常见文件类型
     */
    public static final List<String> FILE_TYPES = Arrays.asList("txt", "doc", "wps", "docx", "xls", "xlsx", "pdf");

    /**
     * 常见视频类型
     */
    public static final List<String> VIDEO_TYPES = Arrays.asList("wmv", "asf", "rm", "rmvb", "mov", "mp4", "avi");

    /**
     * 图片文件夹
     */
    public static final String IMAGE = "/image/";

    /**
     * 文件文件夹
     */
    public static final String FILE = "/file/";

    /**
     * 视频文件夹
     */
    public static final String VIDEO = "/video/";

}
