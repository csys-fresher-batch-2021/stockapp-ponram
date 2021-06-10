<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<c:set var="infoMessage" value="${param.infoMessage}"></c:set>
		<c:if test="${not empty infoMessage}">
			<div style="color: green;">${infoMessage}</div>
		</c:if>
		<c:set var="errorMessage" value="${param.errorMessage}"></c:set>
		<c:if test="${not empty errorMessage}">
			<div style="color: red">${errorMessage}</div>
		</c:if>
	</main>
</body>
</html>