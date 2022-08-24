package com.example.oauthsecurity.repository;

import com.example.oauthsecurity.entity.Permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{
    
}
