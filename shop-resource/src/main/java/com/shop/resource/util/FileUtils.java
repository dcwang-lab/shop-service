package com.shop.resource.util;

import com.shop.common.constant.FileConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Author: dcWang
 * @Date: 2022/6/15 16:03
 * @Description: 文件utils
 */
@Slf4j
public class FileUtils {

    /**
     * 判断是否有未知的文件格式
     *
     * @param files 文件集合
     * @return boolean
     */
    public static boolean isViolation(MultipartFile[] files) {
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            if (StringUtils.isBlank(fileName)) {
                return true;
            }
            String fileSuffix = fileName.substring(fileName.indexOf(".") + 1);
            if (!FileConstant.IMAGE_TYPES.contains(fileSuffix) && !FileConstant.FILE_TYPES.contains(fileSuffix)
                    && !FileConstant.VIDEO_TYPES.contains(fileSuffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建文件夹
     *
     * @param file file
     */
    public static boolean createFolder(File file) {
        if (!file.getParentFile().exists()) {
            boolean isCreateMkdirs = file.getParentFile().mkdirs();
            if (!isCreateMkdirs) {
                log.info("父文件夹创建失败!");
                return false;
            }
        }
        return true;
    }

}
