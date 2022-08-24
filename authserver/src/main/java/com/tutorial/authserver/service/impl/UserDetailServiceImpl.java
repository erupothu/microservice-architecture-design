package com.tutorial.authserver.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tutorial.authserver.entity.Permission;
import com.tutorial.authserver.entity.Role;
import com.tutorial.authserver.entity.User;
import com.tutorial.authserver.model.AuthUserDetail;
import com.tutorial.authserver.model.GenericBuilder;
import com.tutorial.authserver.model.UserBuilder;
import com.tutorial.authserver.repository.PermissionRepository;
import com.tutorial.authserver.repository.RoleRepository;
import com.tutorial.authserver.repository.UserDetailRepository;
import com.tutorial.authserver.service.core.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService,UserService {
	
	@Autowired
    private UserDetailRepository userDetailRepository;
	
	@Autowired
    private PermissionRepository permissionRepository;
	
	@Autowired
    private RoleRepository roleRepository;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userDetailRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
		UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}


	@Override
	public List<User> findAllUsers() {
		List<User> user= userDetailRepository.findAll();
//		UserBuilder user2 = GenericBuilder.of(UserBuilder::new).with(UserBuilder::setUsername, user).build();
		return user;
	}
	@Override
	public UserBuilder findUserById(Integer id) {
		User user = userDetailRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not found"));
		UserBuilder userDetails = GenericBuilder.of(UserBuilder::new).with(UserBuilder::setUsername, user.getUsername())
				.with(UserBuilder::setPassword, user.getPassword()).build();
		return userDetails;
	}


	@Override
	public UserBuilder saveUser(User user) {
		User userData = userDetailRepository.save(user);
		UserBuilder userDetails = GenericBuilder.of(UserBuilder::new).with(UserBuilder::setUsername, userData.getUsername())
				.with(UserBuilder::setPassword, userData.getPassword()).with(User::setId, userData.getId()).build();
		return userDetails;
	}


	@Override
	public void DeleteUserById(Integer id) throws IllegalArgumentException {
			userDetailRepository.deleteById(id);
		
	}


	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}


	@Override
	public List<Permission> getPermissions() {
		return permissionRepository.findAll();
	}


	@Override
	public Role createRoles(Role role) {
		return roleRepository.save(role);
	}


	@Override
	public Role deleteRole(Role role) {
		roleRepository.delete(role);
		return null;
	}


//	@Override
//	public UserBuilder updateUser(User user) {
//		// TODO Auto-generated method stub
//		User userData = userDetailRepository.save(user);
//		UserBuilder userDetails = GenericBuilder.of(UserBuilder::new).with(UserBuilder::setUsername, userData.getUsername())
//				.with(UserBuilder::setPassword, userData.getPassword()).with(User::setId, userData.getId()).build();
//		return userDetails;
//	}

}
