package com.vaya.bestpractice.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaya.bestpractice.data.model.User;
import com.vaya.bestpractice.data.repository.UserRepository;
import com.vaya.bestpractice.data.request.UserRequest;
import com.vaya.bestpractice.exceptions.RecordNotFoundException;
import com.vaya.bestpractice.service.core.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Validated
@Tag(name="Users", description="Operations pertaining to Users") 
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("${USER_CREATE_NEW}")
	public ResponseEntity<?> createUserNew(@RequestBody List<@Valid UserRequest> user) {
		User savedUser = null; //userRepo.save(user);
		log.info("User Created");
		return ResponseEntity.ok().body(Optional.ofNullable(savedUser).orElseGet(User::new));
	}
	
	@PostMapping("${USER_CREATE}")
	@Operation(description = "View a list of available products", summary="Create User")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "User Creation Successful",content = @Content),
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Invalid URL", 
			    content = @Content) })
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);
		log.info("User Created");
		return ResponseEntity.ok().body(savedUser);
	}
	
	@GetMapping("${USER_GET}")
	public ResponseEntity<?> getVayaUsers() {
		List<User> savedUser = userRepo.findAll();
		log.info("Found Users:");
		if(savedUser.size()==0) {
		       throw new RecordNotFoundException("Users not found : ");
		    }
		return ResponseEntity.ok().body(savedUser);
	}
	
	@GetMapping("${USER_GET_BY_ID}")
	public ResponseEntity<?> getVayaUsersById(@PathVariable Integer id) {
		Optional<User> savedUser = userRepo.findById(id);
		log.info("Found Users:");
		if(savedUser.isEmpty()) {
			throw new RecordNotFoundException("Users not found : ");
		}
		return ResponseEntity.ok().body(savedUser.get());
	}
	
	@PutMapping("${USER_UPDATE}")
	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 5000))
	public ResponseEntity<?> updateUser(@RequestBody User user, @Parameter(description = "id of User to be Updated") @RequestParam Integer id) {
		
		User savedUser = new User();
		try {
//			savedUser = userRepo.save(user);
			savedUser = Optional.ofNullable(userRepo.save(user)).orElseGet(User::new);
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("User Updated");
		return ResponseEntity.ok().body(savedUser);
	}
	
	@DeleteMapping("${USER_DELETE}")
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> deleteUser(@RequestBody User user,@RequestParam Integer id) {
		try {
			userRepo.delete(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("User Updated");
		return ResponseEntity.ok().body("");
	}
	
	@GetMapping(value = "/redirect")
    public ResponseEntity<Void> redirect(){
        System.out.println("redirecting: ");
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://vayafinserv.com")).build();
    }
	
	@GetMapping(value = "/multi-thread")
    public ResponseEntity<Void> multiThread(){
        System.out.println("redirecting: ");
        userService.multiTasking();
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://vayafinserv.com")).build();
    }
}
