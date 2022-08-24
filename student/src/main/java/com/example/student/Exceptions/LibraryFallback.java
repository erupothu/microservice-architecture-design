package com.example.student.Exceptions;

import java.util.Collections;
import java.util.List;

import com.example.student.client.LibraryClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LibraryFallback implements LibraryClient {

    public List<String> getBooks() {
        return Collections.emptyList();
    }

    public String getBooksById() {
        return null;
    }

    public ResponseEntity<String> echoLibrary() {
        return ResponseEntity.ok("Service down");
    }
    
}   
