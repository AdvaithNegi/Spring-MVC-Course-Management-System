<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
</head>
<body>

	<h1>Add Courses</h1>
	
	<form action="newcourse" method="post">
	
		Course Name: <input type="text" name="name" placeholder="Enter Course Name"> <br> <br>
		Course Duration: <input type="text" name="duration" placeholder="Enter Course Duration"> <br> <br>
		<input type="submit" value="Add Course"> <br>
	
	</form>
	
	

</body>
</html>