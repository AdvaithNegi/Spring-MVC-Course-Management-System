<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login Page</title>
</head>
<body>

	<h1 style="text-align: center; color: red;">${sno}</h1>
	
	<h1 style="text-align: center; color: red;">${snew1}</h1>
	
	<h1>Student Login Page</h1>

	<form action="slogin" method="post">

		Username: <input type="text" name="username" placeholder="Enter your Username"> <br> <br>
		Password: <input type="password" name="password" placeholder="Enter your Password"> <br> <br>
		<input type="submit" value="Login"> <br>
		<a href="ssignup">NEW?</a>

	</form>

</body>
</html>