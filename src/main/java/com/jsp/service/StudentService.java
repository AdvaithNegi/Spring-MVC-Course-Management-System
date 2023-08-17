package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@Component
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student getByUsernameStudent(String username) {
		return studentDao.getByUsernameStudent(username);
	}

	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public boolean authenticateStudent(String username, String password) {
		Student student = studentDao.getByUsernameStudent(username);

		if (student != null && student.getPassword().equals(password))
			return true;
		else
			return false;
	}

	public boolean enrollStudentInCourse(String username, int id) {
		return studentDao.enrollStudentInCourse(username, id);
	}

}
