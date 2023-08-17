package com.jsp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.dto.Course;
import com.jsp.dto.Student;
import com.jsp.service.CourseService;
import com.jsp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@RequestMapping("/student")
	public String handleStudent() {
		return "sLogin";
	}

	@RequestMapping(path = "slogin", method = RequestMethod.POST)
	public String loginStudent(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		Student student = studentService.getByUsernameStudent(username);
		boolean b = studentService.authenticateStudent(username, password);

		if (b) {
			model.addAttribute("shome", "Welcome " + student.getUsername());
			session.setAttribute("abc", username);
			return "sHome";
		} else {
			model.addAttribute("sno", "Incorrect Credentials, Check again....");
			return "sLogin";
		}

	}

	@RequestMapping("/ssignup")
	public String handleSignup() {
		return "sSignup";
	}

	@RequestMapping(path = "/newstudent", method = RequestMethod.POST)
	public String newStudent(@ModelAttribute Student student, Model model) {
		this.studentService.saveStudent(student);
		model.addAttribute("snew1", "Student with name " + student.getUsername() + " added to database successfully");
		return "sLogin";
	}

	@RequestMapping("/viewcourse")
	public String viewCourses(Model model) {
		List<Course> courses = courseService.getAllCourses();
		model.addAttribute("courses", courses);
		return "viewCourse";
	}

	@RequestMapping("/apply")
	public String applyCourse(@RequestParam int id, Model model, HttpSession session) {
		String username = (String) session.getAttribute("abc");
		boolean b = studentService.enrollStudentInCourse(username, id);
		if (b) {
			model.addAttribute("apply", "Successfully Applied for the Course");
			return "applied";
		} else {
			model.addAttribute("Wrong", "Course is not available right now");
			return "wrong";
		}

	}

}
