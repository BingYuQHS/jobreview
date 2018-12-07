package com.flamingo.jruser.service;


import com.baomidou.mybatisplus.service.IService;
import com.flamingo.jruser.model.entity.UserInfo;

/**
 * 用户service
 */
public interface UserService extends IService<UserInfo> {
    void saveUser(UserInfo userInfo);
}
