package com.example.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableScheduling
public class AdminDashboardApp {

	public static void main(String[] args) {
		SpringApplication.run(AdminDashboardApp.class, args);
	}
}
