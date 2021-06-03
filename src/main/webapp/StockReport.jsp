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
<title>stock report</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
	<%
String role = (String)session.getAttribute("ROLE");
%>
	<div id="message" style="color: green;"></div>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Stock report</h3>

		<div class="row">
			<div class="col-md-6">
				<label>Filter:</label> <input type="text" class="brandFilter"
					id="filter" onkeyup="filter_brand()" placeholder="Brand name">
			</div>
			<div class="col-md-6 text-right "></div>
		</div>
		<table class="table	table-bordered" id="list">
			<caption>List all the stock report</caption>
			<thead>
				<tr>
					<th scope="col">Brand Name</th>
					<th scope="col">Product Name</th>
					<th scope="col">Category</th>
					<th scope="col">Arrival date</th>
					<th scope="col">Prize(Rs.)</th>
					<th scope="col">Initial Quantity</th>
					<th scope="col">Available Quantity</th>
					<th scope="col">Status</th>
					<th scope="col">Sales details</th>
				</tr>
			</thead>
			<tbody id="reportlist-tbl">
			</tbody>
		</table>
		<script src="js/filter-table.js"></script>
		<script src="js/report-list.js"></script>
	</main>
</body>
</html>