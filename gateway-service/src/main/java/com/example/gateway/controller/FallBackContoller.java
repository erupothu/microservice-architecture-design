package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackContoller {
	
	@GetMapping("/library-service")
	public String library() {
		return "Library is Down.. please try later";
	}
	
	@GetMapping("/student-service")
	public String student() {
		return "Student is Down.. please try later";
	}
	
	@GetMapping("/school-service")
	public String school() {
		return "School is Down.. please try later";
	}
}
