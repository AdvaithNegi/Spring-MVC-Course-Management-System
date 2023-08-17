<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
</head>
<body>

	<h1 style="text-align: center;">List Of Teachers</h1>

	<table border="1" style="border-collapse: collapse; width: 100%">
		<tr style="text-align: center;">
			<th>Student Username</th>
			<th>Student Email</th>
			<th>Student Password</th>
			<th>Student Course(Name)</th>
			<th>Student Admin(Name)</th>
		</tr>
		<c:forEach var="student" items="${s1}">
			<tr style="text-align: center;">
				<td>${student.getUsername()}</td>
				<td>${student.getEmail()}</td>
				<td>${student.getPassword()}</td>
				<td>${student.getCourses()}</td>
				<td>${student.getAdmin()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>