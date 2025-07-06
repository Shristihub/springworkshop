package com.bookapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//  REST api
@RestController
public class GreetController {

	
	// methods -> restend point
	// return type can be anything
	
	//http://localhost:8080/welcome
	
	@GetMapping("/welcome")
	public String welcomeMessage() {
		return "Have a great day";
	}
	
	//http://localhost:8080/hello/priya
	@GetMapping("/hello/{username}")
	public String sayHello(@PathVariable String username) {
		return "Hello "+username;
	}
	//query string
	//http://localhost:8080/greet-user?uname=Sripriya
	
		@GetMapping("/greet-user")
		public String greetUser(@RequestParam("uname") String username) {
			return "Welcome "+username;
		}
	
	
	
	
}
