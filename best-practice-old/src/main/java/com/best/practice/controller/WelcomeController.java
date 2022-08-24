package com.best.practice.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.best.practice.data.dao.core.CustomQueryDao;
import com.best.practice.data.entity.Employees;
import com.best.practice.exceptions.CustomException;
import com.best.practice.exceptions.RecordNotFoundException;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WelcomeController {

	Logger log = LoggerFactory.getLogger(WelcomeController.class);

	@Value("${transactionId}")
	private String transactionId;
	
	@Value("${cacheA}")
	private String cacheA;

	@Autowired
	CustomQueryDao customQueryDao;

	@GetMapping("/")
	public String welcome() {
		Log.info("welcome page");

		String password = "harish";
		if (!password.equals("vinny")) {
			throw new CustomException("wring password", "starts with H");
		}

		return "welcome to Spring boot Best Practice";
	}

	@GetMapping("employees")
	public ResponseEntity<?> getEmployees(@RequestHeader("transaction-id") String trId) {

		HttpHeaders header = new HttpHeaders();
		
		if (!trId.equals(transactionId)) {
			cacheA = "harish";
			transactionId = UUID.randomUUID().toString();
			header.set("transaction-id", transactionId);
			header.set("max-age", "60");
			List<Employees> result = customQueryDao.getAllEmployees();
			if (result == null) {
				throw new RecordNotFoundException("Employees not found : ");
			}
			log.info("TransactionID:  ", transactionId);
			return ResponseEntity.ok().headers(header).body(result);
//			return ResponseEntity.ok().header("transaction-id", transactionId).body(result);
		}

		return ResponseEntity.ok().headers(header).body("Validation confirmed");
//		return ResponseEntity.ok().header("transaction-id", "12345").body("Validation confirmed");
	}

	@GetMapping("employee/{id}")
	public ResponseEntity<?> getEmployeeById(@Valid @PathVariable int id) {

		Employees result = customQueryDao.getEmployeeById(id);
		if (result == null) {
			throw new RecordNotFoundException("Employees not found : ");
		}
		return ResponseEntity.ok(result);
	}
}
