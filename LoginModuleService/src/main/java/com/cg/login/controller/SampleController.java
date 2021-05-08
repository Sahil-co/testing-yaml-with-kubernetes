package com.cg.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*Access the urls of your application through login Service
 * You can make separate controllers for different actors
 * specify the actions performed by that actors in your respective controller
 * and design the WebSecurityConfig.java accordingly*/

@RestController
public class SampleController {

	public static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String homePage() {

		logger.info("The user is on Home Page with No authentication");
		return "<h1>Insurance Management System</h1>";
	}

	@RequestMapping("/admin")
	public String admin() {

		return "Admin Operations ";
	}

//	@GetMapping("/admin/getemps")
//	public ResponseEntity<String> getemployees() {
//		String emps = restTemplate.getForObject("http://localhost:9000/employee/getAll", String.class);
//		return ResponseEntity.ok(emps);
//
//	}

	@RequestMapping("/403")
	public String noAuthority() {
		return "403 error You Dont Have Permission to access this page";
	}

}
