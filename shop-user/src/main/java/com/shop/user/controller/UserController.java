package com.shop.user.controller;

import com.shop.common.util.Result;
import com.shop.user.entity.User;
import com.shop.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
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
     * 获取用户详情
     *
     * @param id 用户id
     * @return Result
     */
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Long id) {
        return Result.success("用户信息查询成功").put("data", userService.getUser(id));
    }

    /**
     * 新增用户
     *
     * @param param 参数
     * @return Result
     */
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User param) {
        userService.insertUser(param);
        return Result.success("新增用户成功");
    }

    /**
     * 更新用户
     *
     * @param param 参数
     * @return Result
     */
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User param) {
        userService.updateUser(param);
        return Result.success("更新用户成功");
    }

}
