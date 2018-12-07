package com.flamingo.jruser.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.flamingo.jruser.dao.UserMapper;
import com.flamingo.jruser.enums.ResultEnum;
import com.flamingo.jruser.exception.UserException;
import com.flamingo.jruser.model.entity.UserInfo;
import com.flamingo.jruser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service实现
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,UserInfo> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void saveUser(UserInfo userInfo) {
        int result = userMapper.insertUser(userInfo);
        if (result != 1){
            log.error("【save user error】 userInfo={}",userInfo);
            throw new UserException(ResultEnum.SAVE_USER_FAILD);
        }
    }
}
