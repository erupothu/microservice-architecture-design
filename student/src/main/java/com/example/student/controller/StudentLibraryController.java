package com.example.student.controller;

import com.example.student.client.LibraryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentLibraryController {

    @Autowired
    LibraryClient libraryClient;

    @GetMapping("library-welcome")
    public ResponseEntity<String> echoLibrary() {

        return libraryClient.echoLibrary();
    }
    
    
}
