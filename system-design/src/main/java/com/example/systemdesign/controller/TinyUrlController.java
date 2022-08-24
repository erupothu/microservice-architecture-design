package com.example.systemdesign.controller;

import java.util.List;
import java.util.UUID;

import com.example.systemdesign.data.model.URL;
import com.example.systemdesign.data.model.User;
import com.example.systemdesign.data.repository.URLRepository;
import com.example.systemdesign.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/tinyurl/")
public class TinyUrlController {

    @Autowired
    URLRepository urlRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("get-url-data")
    public ResponseEntity<List<URL>> getUrlData() {

        List<URL> urlData = urlRepository.findAll();
        return ResponseEntity.ok(urlData);
    }

    @GetMapping("get-users")
    public ResponseEntity<List<User>> getUserData() {
        List<User> userData = userRepository.findAll();
        return ResponseEntity.ok(userData);
    }
    
    @PostMapping("create-url")
    public ResponseEntity<URL> createTinyUrl(@RequestBody URL urlData) {
        URL urlDataResponse = urlRepository.save(urlData);
        return ResponseEntity.ok(urlDataResponse);
    }

    @PostMapping("create-user")
    public ResponseEntity<User> createUser(@RequestBody User userData) {
        User userDataResponse = userRepository.save(userData);
        return ResponseEntity.ok(userDataResponse);
    }

    @GetMapping("get-url-by-Id/{id}")
    public ResponseEntity<URL> getUrlById(@PathVariable UUID id) {

        URL urlData = urlRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Url not found"));
        return ResponseEntity.ok(urlData);
    }

}
