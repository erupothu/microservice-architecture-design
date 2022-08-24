package com.tutorial.authserver.model;

import com.tutorial.authserver.entity.User;

public class UserBuilder extends User  {

	public User build() {
		return new User(this.username, this.password, this.email, this.accountNonExpired, this.accountNonLocked, this.enabled);
	}
	
}
