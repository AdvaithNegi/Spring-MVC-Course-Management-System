package com.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.AdminDao;
import com.jsp.dto.Admin;

@Component
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public Admin getByUsernameAdmin(String username) {
		return adminDao.getByUsernameAdmin(username);
	}

	public boolean authenticateAdmin(String username, String password) {
		Admin admin = adminDao.getByUsernameAdmin(username);

		if (admin != null && admin.getPassword().equals(password))
			return true;
		else
			return false;

	}

}
