package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Admin;

@Component
public class AdminDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Admin saveAdmin(Admin admin) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			return admin;
		} else
			return null;
	}

	public Admin getByUsernameAdmin(String username) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Admin.class, username);
	}

}
