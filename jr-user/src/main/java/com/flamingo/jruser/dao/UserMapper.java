package com.flamingo.jruser.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.flamingo.jruser.model.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * mapper|dao userMapper
 */
@Component
public interface UserMapper extends BaseMapper<UserInfo> {

    int insertUser(@Param("userInfo") UserInfo userInfo);

    List<UserInfo> getUserList(@Param("companyId") Integer companyId);
}
