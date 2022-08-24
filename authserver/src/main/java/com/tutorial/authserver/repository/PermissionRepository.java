package com.tutorial.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.authserver.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
