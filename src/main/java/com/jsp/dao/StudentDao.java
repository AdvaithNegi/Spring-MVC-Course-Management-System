package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Course;
import com.jsp.dto.Student;

@Component
public class StudentDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (student != null) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			return student;
		} else
			return null;
	}

	public Student getByUsernameStudent(String username) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Student.class, username);
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (student != null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		} else
			return null;
	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "select s from Student s";
		Query query = entityManager.createQuery(sql);
		List<Student> students = query.getResultList();
		return students;
	}

	@Transactional
	public boolean enrollStudentInCourse(String username, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			Student student = entityManager.find(Student.class, username);
			Course course = entityManager.find(Course.class, id);

			if (student != null && course != null) {
				student.getCourses().add(course);
				course.getStudents().add(student);
				entityManager.persist(student);
				entityManager.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
