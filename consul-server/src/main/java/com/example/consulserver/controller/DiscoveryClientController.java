package com.example.consulserver.controller;

import java.net.URI;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoveryClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("student-with-consul")
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }

    @GetMapping("/discoveryClient")
    public String discoveryPing() throws RestClientException,
            ServiceUnavailableException {
        URI service = serviceUrl()
                .map(s -> s.resolve("/ping-from-consul-discover"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class)
                .getBody();
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/ping-from-consul-discover")
    public String pingFromConsul() {
        return "ping-from-consul-discover";
    }

    @GetMapping("/my-health-check")
public ResponseEntity<String> myCustomCheck() {
    String message = "Testing my healh check function";
    return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
}
}
