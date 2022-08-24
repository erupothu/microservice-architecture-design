package com.best.practice.data.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.best.practice.config.CustomQueryConfig;
import com.best.practice.data.dao.core.CustomQueryDao;
import com.best.practice.data.entity.Employees;

@Repository
public class CustomQueryDaoImpl implements CustomQueryDao {
	
	Logger log = LoggerFactory.getLogger(CustomQueryDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	CustomQueryConfig cumstomQueryProp;
	
	@PostConstruct
	  private void postConstruct() {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub

		String query = cumstomQueryProp.getAllEmployees();
		List<Employees> emp = null;
		
		try {
			emp = entityManager.createNativeQuery(query).getResultList();
			
//			List<Employees> emp2 = entityManager.createNativeQuery(query).getResultList();
		} catch (NonUniqueResultException | DataAccessException | SecurityException nure) {
			// TODO: handle exception\
			// EmptyResultDataAccessException, Duplicatekeyexception
			log.error("Get Employees: ",nure);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Get Employees: ",e);
		}
		return emp;

	}

	@Override
	public Employees getEmployeeById(int id) {
		// TODO Auto-generated method stub
		String query = cumstomQueryProp.getEmployeeById();
		Employees emp2 = null;
		try {
			
			 emp2 = (Employees) entityManager.createNativeQuery(query).setParameter(1, id).getSingleResult();
		} catch (NonUniqueResultException | DataAccessException | SecurityException nure) {
			log.error("Get Employees: ",nure);
		} catch (Exception e) {
			log.error("Get Employees: ",e);
		}
		return emp2;
	}

}
