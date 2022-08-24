package com.example.jwtauthentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("welcome")
    public ResponseEntity<String> welcomeMethod() {
        
        return ResponseEntity.ok("welcome to Authentication Service");
    }
}
