package com.example.student.client;

import com.example.student.Exceptions.LibraryFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "LIBRARY", fallback = LibraryFallback.class)
public interface LibraryClient {

    @GetMapping("lwelcome")
    public ResponseEntity<String> echoLibrary();
    
}
