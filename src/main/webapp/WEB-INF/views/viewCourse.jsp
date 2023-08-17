<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Courses</title>
</head>
<body>

	<h1 style="text-align: center;">List of Student</h1>

	<table border="1px" style="border-collapse: collapse; width: 100%">
		<tr style="text-align: center;">
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Apply</th>
		</tr>
		<c:forEach var="course" items="${courses}">
			<tr style="text-align: center;">
				<td>${course.getId()}</td>
				<td>${course.getName()}</td>
				<td><a href="apply?id=${course.getId()}">Click Here</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>