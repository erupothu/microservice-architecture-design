package com.tutorial.authserver.service.core;

import java.util.List;
import java.util.Map;

import com.tutorial.authserver.entity.Permission;
import com.tutorial.authserver.entity.Role;
import com.tutorial.authserver.entity.User;
import com.tutorial.authserver.model.UserBuilder;

public interface UserService {

	List<User> findAllUsers();

	UserBuilder findUserById(Integer id);

	UserBuilder saveUser(User user);

	void DeleteUserById(Integer id);

	List<Role> getRoles();

	List<Permission> getPermissions();

	Role createRoles(Role role);

	Role deleteRole(Role role);

//	UserBuilder updateUser(User user);

}
