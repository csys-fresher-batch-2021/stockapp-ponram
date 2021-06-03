<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			%>
		<div style="color: green;"><%=infoMessage %></div>
		<%}%>

		<% 
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			%>
		<div style="color: red"><%=errorMessage %></div>
		<%}%>
	</main>
</body>
</html>