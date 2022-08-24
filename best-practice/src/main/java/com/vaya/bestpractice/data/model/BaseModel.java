package com.vaya.bestpractice.data.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel {
	
	@Id     
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Integer id;
	
	private Integer createdById;
	private Timestamp createdOnDate;
	private Integer modifiedById;
	private Timestamp modifiedonDate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCreatedById() {
		return createdById;
	}
	public void setCreatedById(Integer createdById) {
		this.createdById = createdById;
	}
	public Timestamp getCreatedOnDate() {
		return createdOnDate;
	}
	public void setCreatedOnDate(Timestamp createdOnDate) {
		this.createdOnDate = createdOnDate;
	}
	public Integer getModifiedById() {
		return modifiedById;
	}
	public void setModifiedById(Integer modifiedById) {
		this.modifiedById = modifiedById;
	}
	public Timestamp getModifiedonDate() {
		return modifiedonDate;
	}
	public void setModifiedonDate(Timestamp modifiedonDate) {
		this.modifiedonDate = modifiedonDate;
	}
	
}
