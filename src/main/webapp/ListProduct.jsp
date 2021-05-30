<%@page import="in.ponram.dao.ProductDAO"%>
<%@page import="in.ponram.service.ProductManager"%>
<%@page import="in.ponram.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>List products</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
<%
String role = (String)session.getAttribute("ROLE");
%>
	<div id="message" style="color:green;"></div>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>List of stock</h3>
	<label>Filter:</label>
	<input type="text" class="brandFilter" id="filter" onkeyup="filter_brand()" placeholder="Brand name" >
		<table class="table	table-bordered" id="list">
			<caption>List all the product in the stock</caption>
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Item Name</th>
					<th scope="col">Category</th>
					<th scope="col">Arrival date</th>
					<th scope="col">Rate</th>
					<th scope="col">Quantity</th>
					<% if(role != null){ %>
					<th scope="col">Add Quantity</th>
					<th scope="col">Remove</th>
					<%} %>
				</tr>
			</thead>
			<tbody id="listProduct-tbl">
			</tbody>
		</table>
		<script src="js/list-product.js"></script>
		</main>
</body>
</html>

