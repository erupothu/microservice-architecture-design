package com.example.systemdesign.data.repository;

import java.util.UUID;

import com.example.systemdesign.data.model.URL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, UUID> {
    
    
}
