<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
</head>
<body>

	<h1 style="text-align: center;color: red">${no}</h1>
	<h1 style="text-align: center;color: blue;">${new1}</h1>
	<h1>Admin Login Page</h1>

	<form action="alogin" method="post">

		Username: <input type="text" name="username" placeholder="Enter your Username"> <br> <br>
		Password: <input type="password" name="password" placeholder="Enter your Password"> <br> <br>
		<input type="submit" value="Login"> <br>
		<a href="asignup">NEW?</a>

	</form>

</body>
</html>