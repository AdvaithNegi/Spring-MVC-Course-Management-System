package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Course;

@Component
public class CourseDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Course saveCourse(Course course) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (course != null) {
			entityTransaction.begin();
			entityManager.persist(course);
			entityTransaction.commit();
			return course;
		} else
			return null;
	}

	public Course getByIdCourse(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Course.class, id);
	}

	public List<Course> getAllCourses() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "select c from Course c";
		Query query = entityManager.createQuery(sql);
		List<Course> courses = query.getResultList();
		return courses;
	}

}
