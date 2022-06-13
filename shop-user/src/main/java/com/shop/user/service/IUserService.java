package com.shop.user.service;

import com.shop.user.entity.User;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/13 11:28
 * @Description: 用户service接口
 */
public interface IUserService {

    /**
     * 用户列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<User> listUsers(User queryParam);

    /**
     * 获取用户详情
     *
     * @param id 用户id
     * @return User
     */
    User getUser(Long id);

    /**
     * 新增用户
     *
     * @param param 参数
     */
    void insertUser(User param);

    /**
     * 更新用户
     *
     * @param param 参数
     */
    void updateUser(User param);

}
