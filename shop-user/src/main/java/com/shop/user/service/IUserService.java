package com.shop.user.service;

import com.shop.user.dto.RegisterDTO;
import com.shop.user.entity.User;
import com.shop.user.vo.UserInfoVO;

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
    List<UserInfoVO> listUsers(User queryParam);

    /**
     * 获取用户详情
     *
     * @param id 用户id
     * @return User
     */
    UserInfoVO getUser(Long id);

    /**
     * 新增用户
     *
     * @param param 参数
     */
    void insertUser(RegisterDTO param);

    /**
     * 更新用户
     *
     * @param param 参数
     */
    void updateUser(User param);

    /**
     * 判断手机号是否存在
     *
     * @param phone 手机号
     * @return boolean
     */
    boolean isExist(String phone);

}
