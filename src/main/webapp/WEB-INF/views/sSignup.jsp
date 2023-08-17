<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Signup Page</title>
</head>
<body>

	<h1 style="text-align: center;">Student Signup Page</h1>
	
	<form action="newstudent" method="post">
	
		Username: <input type="text" name="username" placeholder="Enter your Name"> <br><br>
		Email: <input type="email" name="email" placeholder="Enter your Email"> <br> <br>
		Password: <input type="password" name="password" placeholder="Enter your Password"> <br> <br>
		<input type="submit" value="SignUp">
	
	</form>

</body>
</html>