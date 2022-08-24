package com.vaya.bestpractice.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author vaya-it
 *
 */
@Entity
@Table
@Schema
public class User extends AuditableEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 0, max = 200)
//	@Schema(name = "Name is mandatory for the User")
	private String name;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email is mandatory")
	private String email;
	
	private String phone;
	private String password;
	
	@Min(value=18, message = "age cannot be less than 18") @Max(value=60, message = "age cannot be more than 60")
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
}
