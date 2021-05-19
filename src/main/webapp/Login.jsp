<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Login</h3>
		<form action="LoginServlet" method="post">
			<label>Username:</label>
			<input type="text" id="userName" name="userName" placeholder="Enter user name" autofocus required/><br/>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="Enter password" required/><br/>
			<div>
            <label for="userType">User Type:</label>
            <input id="userType" type="radio" name="userType" value="user" checked required/>User
            <input id="userType" type="radio" name="userType" value="admin" required/>Admin
            </div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</main>
</body>
</html>