package com.flamingo.jreurekaserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置类禁用csrf,使服务免密码注册到eureka-server
 */
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
        }catch (Exception e){
            log.error("【jr-message服务免密注册失败】");
            e.printStackTrace();
        }

    }
}
