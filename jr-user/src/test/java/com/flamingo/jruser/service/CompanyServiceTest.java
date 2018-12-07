package com.flamingo.jruser.service;

import com.flamingo.jruser.model.entity.CompanyInfo;
import com.flamingo.jruser.model.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;
    @Test
    public void saveCompany() throws Exception {
        CompanyInfo info = new CompanyInfo();
        info.setCompanyName("测试公司");
        info.setCheckType(0);
        info.setCompanyNo("199201923899991091");
        info.setLicensePath("http://xxx.png");

        companyService.saveCompany(info);
        Assert.assertNotEquals(null,info.getCompanyId());
        log.info("【userId】 = {}",info.getCompanyId());
    }

}