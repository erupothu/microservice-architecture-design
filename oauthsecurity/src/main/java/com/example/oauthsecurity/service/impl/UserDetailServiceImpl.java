package com.example.oauthsecurity.service.impl;

import java.util.Optional;

import com.example.oauthsecurity.repository.UserDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

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
}
