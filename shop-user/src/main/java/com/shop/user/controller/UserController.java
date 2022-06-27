package com.shop.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shop.common.util.CheckUtils;
import com.shop.common.util.Result;
import com.shop.user.dto.LoginDTO;
import com.shop.user.dto.RegisterDTO;
import com.shop.user.entity.User;
import com.shop.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: dcWang
 * @Date: 2022/5/25 15:08
 * @Description: 用户controller
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 登录
     *
     * @param param 参数
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO param) {
        log.info("参数==={}", param);
        return Result.success();
    }

    /**
     * 注册
     *
     * @param param 参数
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterDTO param) {
        if (param == null) {
            return Result.error("注册失败!");
        }
        if (StringUtils.isBlank(param.getName())) {
            return Result.error("请填写姓名!");
        }
        if (StringUtils.isBlank(param.getPhone())) {
            return Result.error("请填写手机号!");
        }
        if (!CheckUtils.isMobile(param.getPhone())) {
            return Result.error("请正确填写手机号!");
        }
        if (userService.isExist(param.getPhone())) {
            return Result.error("手机号已存在!");
        }
        if (StringUtils.isBlank(param.getPassword())) {
            return Result.error("请填写密码!");
        }
        if (param.getPassword().length() < 6 || param.getPassword().length() > 10) {
            return Result.error("请填写6~10位的密码!");
        }
        userService.insertUser(param);
        return Result.success("注册成功!");
    }

    /**
     * 获取用户详情
     *
     * @param id 用户id
     * @return Result
     */
    @SentinelResource(value = "getUser", blockHandler = "getUserFlowQpsException")
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Long id) {
        return Result.success("用户信息查询成功").put("data", userService.getUser(id));
    }

    public Result getUserFlowQpsException(Long id, BlockException be) {
        log.info("id为：" + id + "的用户访问过于频繁，已限流!");
        return Result.error("访问过于频繁，请稍后重试!");
    }

    /**
     * 更新用户信息
     *
     * @param param 参数
     * @return Result
     */
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User param) {
        userService.updateUser(param);
        return Result.success("更新用户信息成功");
    }

}
