package com.shop.user.mapper;

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
    void insertUser(User param);

    /**
     * 更新用户
     *
     * @param param 参数
     */
    void updateUser(User param);

}
