<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>

	<h1 style="text-align: center; font-size: 50px">${home}</h1>
	<h1 style="text-align: center;color: maroon;">${course}</h1>
	
		<a href="viewstudent">See List of Student</a>
		<br> <br>
		<a href="addcourse">Add Course</a>
		<br> <br>
		<a href="setstudent">Set Student</a>
	
</body>
</html>