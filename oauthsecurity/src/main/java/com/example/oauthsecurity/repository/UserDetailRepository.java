package com.example.oauthsecurity.repository;

import com.example.oauthsecurity.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository  extends JpaRepository<User,Integer>{
    
}
