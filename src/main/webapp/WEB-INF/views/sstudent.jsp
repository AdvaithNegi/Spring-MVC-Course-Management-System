<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Student</title>
</head>
<body>

	<h1 style="text-align: center;">${error}</h1>

	<form action="setStudent" method="post">
	
		Admin Username: <input type="text" name="username1" placeholder="Enter Admin Username"> <br> <br>
		Student Username: <input type="text" name="username2" placeholder="Enter Student Username"> <br> <br>
		<input type="submit">
	
	</form>

</body>
</html>