package com.vaya.bestpractice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaya.bestpractice.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
