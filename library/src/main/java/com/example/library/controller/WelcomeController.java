package com.example.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("lwelcome")
    public ResponseEntity<String> echoLibrary() {

        return ResponseEntity.ok("welcome to Library Service");
    }
}
