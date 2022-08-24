package com.tutorial.authserver.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.authserver.entity.Permission;
import com.tutorial.authserver.entity.Role;
import com.tutorial.authserver.entity.User;
import com.tutorial.authserver.model.UserBuilder;
import com.tutorial.authserver.service.core.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/methodlevel")
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
    public String notFound() {
        return "";
    }

	@GetMapping("${GET_USERS}")
	public ResponseEntity<?> getUser() {
		List<User> users = userService.findAllUsers();
//		UserBuilder user2 = GenericBuilder.of(UserBuilder::new).with(UserBuilder::setName, "").build();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping("${CREATE_USER}")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		// BCryptPasswordEncoder
//		int strength = 10; // work factor of bcrypt
//		 BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(strength, new SecureRandom());
//		 String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		UserBuilder userDetails = userService.saveUser(user);
		return ResponseEntity.ok().body(userDetails);
	}
	
	@GetMapping("get-roles")
	public ResponseEntity<?> getRoles() {
		List<Role> roles = userService.getRoles();
		return ResponseEntity.ok().body(roles);
	}
	
	@PostMapping("create-role")
	public ResponseEntity<?> createRole(@RequestBody Role role) {
		Role roleCreated = userService.createRoles(role);
		return ResponseEntity.ok().body(roleCreated);
	}
	
	@DeleteMapping("delete-roles")
	public ResponseEntity<?> deleteRole(@RequestBody Role role) {
		Role roles = userService.deleteRole(role);
		return ResponseEntity.ok().body(roles);
	}
	
	@GetMapping("get-permissions")
	public ResponseEntity<?> getPermissions() {
		List<Permission> permissions = userService.getPermissions();
		return ResponseEntity.ok().body(permissions);
	}
	
	@GetMapping("${GET_USER_BY_ID}")
	public ResponseEntity<?> getUserById(@RequestParam Integer id) {
		try {
			UserBuilder user = userService.findUserById(id);
			if(user !=null) {
				return ResponseEntity.ok().body(user);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("${DELETE_USER_BY_ID}")
	public ResponseEntity<?> deleteUserById(@RequestParam Integer id) {
		userService.DeleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	
//	@PutMapping("${UPDATE_USER}")
//	public ResponseEntity<?> updateUser(@RequestBody User user) {
//		UserBuilder userDetail = userService.updateUser(user);
//		return ResponseEntity.ok(userDetail);
//	}
	
}
