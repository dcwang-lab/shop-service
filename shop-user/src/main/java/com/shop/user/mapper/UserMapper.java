package com.shop.user.mapper;

import com.shop.user.bo.LoginBO;
import com.shop.user.dto.QueryUserDTO;
import com.shop.user.dto.RegisterDTO;
import com.shop.user.entity.User;
import com.shop.user.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/13 11:27
 * @Description: 用户mapper接口
 */
@Mapper
public interface UserMapper {

    /**
     * 用户列表查询
     *
     * @param queryParam 查询条件
     * @return List
     */
    List<UserInfoVO> listUsers(User queryParam);

    /**
     * 获取用户信息
     *
     * @param queryParam 查询条件
     * @return UserInfoVO
     */
    UserInfoVO getUserDetails(QueryUserDTO queryParam);

    /**
     * 获取用户信息
     *
     * @param phone 手机号
     * @return LoginBO
     */
    LoginBO getUserByPhone(String phone);

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

}
