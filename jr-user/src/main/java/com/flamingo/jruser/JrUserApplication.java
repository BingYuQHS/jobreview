package com.flamingo.jruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EnableDiscoveryClient
// @EnableFeignClients
@ComponentScan(basePackages = {"com.flamingo.jruser.model.entity","com.flamingo.jruser"})
public class JrUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JrUserApplication.class, args);
	}
}
