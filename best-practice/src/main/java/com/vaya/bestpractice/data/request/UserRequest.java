package com.vaya.bestpractice.data.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class UserRequest {

	@NotBlank(message = "{validation.name.NotEmpty}")
	@Size(min = 0, max = 200)
//	@Schema(name = "Name is mandatory for the User")
	private String name;
	
	@NotBlank(message = "{validation.email.NotEmpty}")
	@Email(message = "{validation.email.Type}")
	private String email;
	
	private String phone;
	private String password;
	
	@Min(value=18, message = "{validation.age.Mininimum}") 
	@Max(value=60, message = "{validation.age.Maximum}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
