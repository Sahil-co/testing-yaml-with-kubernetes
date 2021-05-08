package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@Configuration
public class InsuranceCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCalculatorApplication.class, args);
	}
	
	@Configuration
    class RestTemplateConfig {
            
            @Bean
//            @LoadBalanced
            public RestTemplate restTemplate() {
              return new RestTemplate();
            }
    }

	@Bean
	public Docket employeeAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.controller")).build()
				.tags(new Tag("person-controller", "Person Controller has eligibility checker to check eligibility for policy"),
					  new Tag("person-eligibility-controller", "Person Eligibility Controller has method to get all eligible customers"));
	}
}
