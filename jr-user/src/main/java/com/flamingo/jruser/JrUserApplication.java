package com.flamingo.jruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JrUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JrUserApplication.class, args);
	}
}
