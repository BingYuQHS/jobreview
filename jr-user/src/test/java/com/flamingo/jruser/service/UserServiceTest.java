package com.flamingo.jruser.service;

import com.flamingo.jruser.model.entity.UserInfo;
import com.flamingo.jruser.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    @Transactional
    public void saveUser() {
        UserInfo info = new UserInfo();
        info.setCompanyId(1);
        info.setUserType(0);
        info.setExactName("Qin2");
        info.setPassword("12345");
        info.setSex(1);
        info.setPhone("18349133213");
        info.setEmail("123@163.com");
        info.setIdCard("1222222223");

        userService.saveUser(info);
        Assert.assertNotEquals(null,info.getUserId());
        log.info("【userId】 = {}",info.getUserId());
    }

}