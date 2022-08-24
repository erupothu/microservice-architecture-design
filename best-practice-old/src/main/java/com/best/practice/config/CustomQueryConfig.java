package com.best.practice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource(value="classpath:customquery.properties")
public class CustomQueryConfig {
	
	private String allEmployees;
	private String employeeById;

	public String getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(String allEmployees) {
		this.allEmployees = allEmployees;
	}

	public String getEmployeeById() {
		return employeeById;
	}

	public void setEmployeeById(String employeeById) {
		this.employeeById = employeeById;
	}
	
	
	
	

}
