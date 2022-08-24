package com.vaya.bestpractice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	
	
	@GetMapping("${WELCOME}")
	public ResponseEntity<?> welcome() {
		
		return ResponseEntity.ok("welcome to Best Practice App");
	}
	
//	@GetMapping("/")
//	public String home(Model model, Authentication authentication) {
//		if (authentication != null && authentication.isAuthenticated()) {
//			model.addAttribute("name", authentication.getName());
//			model.addAttribute("principal", authentication.getPrincipal());
//			model.addAttribute("authorities", authentication.getAuthorities().stream().map(a -> a.getAuthority())
//					.collect(Collectors.joining(",")));
//		}
//
//		model.addAttribute("message", "AWS Cognito with Spring Security");
//
//		return "index";
//	}
}
