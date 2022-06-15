package com.shop.resource.controller;

import com.shop.common.constant.FileConstant;
import com.shop.common.util.DateUtils;
import com.shop.common.util.Result;
import com.shop.resource.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: dcWang
 * @Date: 2022/6/14 14:29
 * @Description: 文件controller
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${filePath}")
    private String filePath;

    @Value("${prefix}")
    private String prefix;

    /**
     * 文件上传
     *
     * @param files 文件集合
     * @return Result
     */
    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartFile[] files) {
        try {
            boolean isEmpty = files == null || StringUtils.isBlank(files[0].getOriginalFilename());
            if (isEmpty) {
                return Result.error("上传失败，请选择要上传的文件!");
            }
            if (FileUtils.isViolation(files)) {
                return Result.error("上传失败，存在未知的文件格式!");
            }
            // 返回集合
            List<String> paths = new ArrayList<>();
            for (MultipartFile file : files) {
                // 文件名称
                String fileName = file.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 后缀
                    String fileSuffix = fileName.substring(fileName.indexOf(".") + 1);
                    String path = "";
                    // 判断文件类型
                    if (FileConstant.IMAGE_TYPES.contains(fileSuffix)) {
                        path = FileConstant.IMAGE;
                    } else if (FileConstant.FILE_TYPES.contains(fileSuffix)) {
                        path = FileConstant.FILE;
                    } else if (FileConstant.VIDEO_TYPES.contains(fileSuffix)) {
                        path = FileConstant.VIDEO;
                    }
                    if (StringUtils.isNotBlank(path)) {
                        // 日期文件夹
                        String folder = DateUtils.getYearMonthDay() + "/";
                        // 获取1000内随机数，为防止文件名重复
                        int num = new Random().nextInt(1000);
                        // 时间戳
                        long currentTimeMillis = System.currentTimeMillis();
                        // 文件重命名
                        String newFileName = currentTimeMillis + num + "." + fileSuffix;
                        path += folder + newFileName;
                        // 完整路径
                        String fullPath = filePath + path;
                        // 访问路径
                        String visitPath = prefix + path;
                        // 判断路径是否存在
                        if (!FileUtils.createFolder(new File(fullPath))) {
                            return Result.error("文件夹创建失败!");
                        }
                        // 输出文件
                        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fullPath));
                        outputStream.write(file.getBytes());
                        outputStream.flush();
                        outputStream.close();
                        paths.add(visitPath);
                    }
                }
            }
            if (paths.size() > 1) {
                return Result.success("文件上传成功!").put("data", paths);
            } else {
                return Result.success("文件上传成功!").put("data", paths.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败，系统异常!");
        }
    }

}
