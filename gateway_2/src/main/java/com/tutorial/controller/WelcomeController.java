package com.tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("")
	private ResponseEntity<?> welcom() {
		// TODO Auto-generated method stub
		
		return ResponseEntity.ok("Welcome to ApI Gateway");

	}
}
