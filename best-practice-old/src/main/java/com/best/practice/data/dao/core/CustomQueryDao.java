package com.best.practice.data.dao.core;

import java.util.List;

import javax.validation.Valid;

import com.best.practice.data.entity.Employees;

public interface CustomQueryDao {
	
	public List<Employees> getAllEmployees();

	public Employees getEmployeeById(@Valid int id);

}
