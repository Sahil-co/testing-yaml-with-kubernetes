package com.cg.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class LoginModuleGitApplication {

	public static final Logger logger = LoggerFactory.getLogger(LoginModuleGitApplication.class);

	public static void main(String[] args) {

		logger.info("Main Application Started............");
		SpringApplication.run(LoginModuleGitApplication.class, args);

	}

	@Bean
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
