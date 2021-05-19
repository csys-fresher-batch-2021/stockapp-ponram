<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Register</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
		%>
		<div style="color:red"><%=errorMessage %></div>
		<%}%>
		<form action="RegisterServlet" method="post">
			<label>Username:</label>
			<input type="text" id="userName" name="userName" placeholder="Enter your user name" pattern=".{3,10}" autofocus required/><br/>
			<div>
            <label for="gender">Gender:</label>
            <input id="gender" type="radio" name="gender" value="male" required/>Male
            <input id="gender" type="radio" name="gender" value="female" required/>Female
            </div>
			<label>Address:</label>
			<input type="text" id="address" name="address" pattern=".{4,20}" placeholder="Enter your address" required/><br/>
			<label>Mobile number:</label>
			<input type="number" id="mobileNumber" name="mobileNumber" pattern="[6-9][0-9]{9}" placeholder="Enter your mobile number" required/><br/>
			<label>Email:</label>
			<input type="email" id="email" name="email" pattern="" placeholder="Enter your email" required/><br/>
			<label>Password:</label>
			<input type="password" id="password" pattern=".{8,20}" name="password" placeholder="Enter your password" required/><br/>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</main>
</body>
</html>