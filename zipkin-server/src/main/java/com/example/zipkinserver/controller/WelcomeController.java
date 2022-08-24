package com.example.zipkinserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("zipkin-welcome")
    public ResponseEntity<String> zipkinWelcome() {

        return ResponseEntity.ok("welcome to Zipkin Server");
    }
}
