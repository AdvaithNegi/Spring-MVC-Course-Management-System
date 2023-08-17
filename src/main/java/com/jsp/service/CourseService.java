package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.CourseDao;
import com.jsp.dto.Course;

@Component
public class CourseService {

	@Autowired
	private CourseDao courseDao;

	public Course saveCourse(Course course) {
		return courseDao.saveCourse(course);
	}

	public Course getByIdCourse(int id) {
		return courseDao.getByIdCourse(id);
	}

	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

}
