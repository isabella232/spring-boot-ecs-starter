package com.tpg.microservices.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

	/**
	 * This method is called by root path / of the service, like localhost:2221/
	 * 
	 * @return return a string value
	 */
	@RequestMapping("/")
	public String callRootPath() {
		return "Welcome to the 3Pilar Global springboot service sample";
	}
	
	/**
	 * This method can be called like localhost:2221/hello
	 * 
	 * @return return a string value
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "Hello, how are you today...";
	}
}
