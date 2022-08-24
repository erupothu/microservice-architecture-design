package com.example.sslsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("welcome")
    public ResponseEntity<?> welcome() {

        return ResponseEntity.ok("welcome to SLL Security Service");
    }
}
