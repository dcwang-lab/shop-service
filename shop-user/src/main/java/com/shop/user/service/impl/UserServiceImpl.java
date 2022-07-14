package com.shop.user.service.impl;

import com.shop.common.constant.AESConstant;
import com.shop.common.constant.StringConstant;
import com.shop.common.enums.LoginEnum;
import com.shop.common.util.AESUtils;
import com.shop.common.util.IdUtils;
import com.shop.user.bo.LoginBO;
import com.shop.user.dto.QueryUserDTO;
import com.shop.user.dto.RegisterDTO;
import com.shop.user.entity.User;
import com.shop.user.mapper.UserMapper;
import com.shop.user.service.IUserService;
import com.shop.user.vo.UserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/6/13 11:28
 * @Description: 用户service实现
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginEnum login(String phone, String password) {
        try {
            LoginBO userInfo = this.getUser(phone);
            if (userInfo == null) {
                return LoginEnum.NON_EXISTENT;
            }
            // 用户密码解密
            String decrypt = AESUtils.decrypt(userInfo.getPassword(), AESConstant.KEY);
            if (!password.equals(decrypt)) {
                return LoginEnum.PASSWORD_ERROR;
            }
            return LoginEnum.LOGIN_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return LoginEnum.ERROR;
        }
    }

    @Override
    public List<UserInfoVO> listUsers(User queryParam) {
        return userMapper.listUsers(queryParam);
    }

    @Override
    public UserInfoVO getUser(QueryUserDTO queryParam) {
        return userMapper.getUserDetails(queryParam);
    }

    @Override
    public LoginBO getUser(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    @Transactional
    public void insertUser(RegisterDTO param) {
        // 生成用户id
        param.setUserId(IdUtils.createUserId());
        // 密码AES加密
        String password = param.getPassword();
        param.setPassword(AESUtils.encrypt(password, AESConstant.KEY));
        // 设置默认头像
        if (StringUtils.isBlank(param.getPhoto())) {
            param.setPhoto(StringConstant.DEFAULT_PHOTO);
        }
        userMapper.insertUser(param);
    }

    @Override
    @Transactional
    public void updateUser(User param) {
        userMapper.updateUser(param);
    }

    @Override
    public boolean isExist(String phone) {
        User queryParam = new User();
        queryParam.setPhone(phone);
        List<UserInfoVO> listUsers = listUsers(queryParam);
        return !listUsers.isEmpty();
    }
}
