package com.example.systemdesign.data.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class URL {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "varchar(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;
    private String originalUrl;
    private Timestamp createdDate;
    private Timestamp expiryDate;
    private Integer userId;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    public Timestamp getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "URL [createdDate=" + createdDate + ", expiryDate=" + expiryDate + ", id=" + id + ", originalUrl="
                + originalUrl + ", userId=" + userId + "]";
    }

}
