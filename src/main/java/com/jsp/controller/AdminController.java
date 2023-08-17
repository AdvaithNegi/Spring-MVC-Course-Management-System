package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.dto.Admin;
import com.jsp.dto.Course;
import com.jsp.dto.Student;
import com.jsp.service.AdminService;
import com.jsp.service.CourseService;
import com.jsp.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@RequestMapping("/admin")
	public String handleAdmin() {
		return "aLogin";
	}

	@RequestMapping(path = "/alogin", method = RequestMethod.POST)
	public String adminLogin(@RequestParam String username, @RequestParam String password, Model model) {
		Admin admin = adminService.getByUsernameAdmin(username);
		boolean b = adminService.authenticateAdmin(username, password);

		if (b) {
			model.addAttribute("home", "Admin " + admin.getUsername() + ", welcome!!!!");
			return "aHome";
		} else {
			model.addAttribute("no", "Incorrect Credentials, Check Again");
			return "aLogin";
		}
	}

	@RequestMapping("/asignup")
	public String handleNewAdmin() {
		return "aSignup";
	}

	@RequestMapping(path = "/newadmin", method = RequestMethod.POST)
	public String newAdmin(@ModelAttribute Admin admin, Model model) {
		this.adminService.saveAdmin(admin);
		model.addAttribute("new1", "Admin with name " + admin.getUsername() + " registered successfully");
		return "aLogin";
	}

	@RequestMapping("/addcourse")
	public String handleCourse() {
		return "aCourse";
	}

	@RequestMapping(path = "/newcourse", method = RequestMethod.POST)
	public String newCourse(@ModelAttribute Course course, Model model) {
		this.courseService.saveCourse(course);
		model.addAttribute("course", course.getName() + " Added to website!!!!");
		return "aHome";
	}

	@RequestMapping("/viewstudent")
	public String viewAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("s1", students);
		return "viewStudent";
	}

	@RequestMapping("/setstudent")
	public String handleStudent() {
		return "sstudent";
	}

	@RequestMapping(path = "/setStudent", method = RequestMethod.POST)
	public String setStudent(@RequestParam String username1, @RequestParam String username2, Model model) {
		Admin admin = adminService.getByUsernameAdmin(username1);
		Student student = studentService.getByUsernameStudent(username2);

		if (admin != null && student != null) {
			student.setAdmin(admin);
			studentService.updateStudent(student);
			return "aHome";
		} else {
			model.addAttribute("error", "Invalid credentials, Check again");
			return "sstudent";
		}
	}

}
