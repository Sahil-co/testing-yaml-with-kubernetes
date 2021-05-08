package com.cg.login.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@GetMapping("/getAllPolicy")
	public ResponseEntity<String>  getAllPolicy() {
		logger.info("In AdminController to retrieve policy using map");
		String policy = restTemplate.getForObject("http://localhost:9000/admin/getAllPolicy", String.class);
		return ResponseEntity.ok(policy);
	}
}
