package com.vaya.bestpractice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

@RestController
public class UnirestRestCallController {
	
	
	@GetMapping("get-call-rest-service")
	public ResponseEntity<?> callRestService() {
		
		HttpResponse<String> response = Unirest.get("http://localhost:8084/get-data/{id}")
				.basicAuth("harish", "hpass")
				.routeParam("id", "123")
				.asString();
		
		return ResponseEntity.ok("call Successful");
	}
	
	@GetMapping("post-call-rest-service")
	public ResponseEntity<?> postCallRestService() {
		
		HttpResponse<JsonNode> response = Unirest.put("http://localhost:8084/save-data/{id}")
				.header("accept", "application/json")
				.routeParam("id", "123")
				.queryString("requestParam", "requestParamName")
				.field("name", "harish")
				.field("email", "email@gmail.com")
				.field("designation", "IT").asJson();
		
		return ResponseEntity.ok("call Successful");
	}

}
