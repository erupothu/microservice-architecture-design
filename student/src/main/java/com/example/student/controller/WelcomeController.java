package com.example.student.controller;

import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("swelcome")
    public ResponseEntity<String> welcome() {

        return ResponseEntity.ok("welcome to student service");
    }
    
}
