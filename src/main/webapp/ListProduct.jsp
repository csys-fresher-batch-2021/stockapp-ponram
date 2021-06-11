<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List products</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="role" value="${sessionScope.ROLE}"></c:set>
	<div id="message" style="color: green;"></div>
	<main class="container-fluid">
		<h3>List of stock</h3>

		<div class="row">
		<h3>Filter</h3>
			<div class="col-md-6">
				<label>brand name:</label> <input type="text" class="brandFilter"
					id="brandfilter" onkeyup="filter_brand()" placeholder="Brand name"/>
				<c:if test="${fn:containsIgnoreCase(role, 'user')}">
				<button class="btn btn-primary" onclick="store()">Place order</button>
				</c:if>
				<c:if test="${fn:containsIgnoreCase(role, 'admin')}">
				<label>Quantity:</label> <input type="number" class="quantityFilter"
					id="quantityFilter"/>	
				<button class="btn btn-primary" onclick="getAllProducts()">Check</button>
				</c:if>
			</div>
		</div>
		<table class="table	table-bordered" id="list">
			<caption>List all the product in the stock</caption>
			<thead>
				<tr>
					<th scope="col">Brand Name</th>
					<th scope="col">Item Name</th>
					<th scope="col">Category</th>
					<th scope="col">Arrival date</th>
					<th scope="col">Prize&#8377;</th>
					<th scope="col">Quantity</th>
					<c:if test="${not empty role}">
						<c:if test="${fn:containsIgnoreCase(role, 'admin')}">
							<th scope="col">Add Quantity</th>
							<th scope="col">Action</th>
						</c:if>
						<c:if test="${fn:containsIgnoreCase(role, 'user')}">
							<th scope="col">Select</th>
							<th scope="col">No.of quantity</th>
						</c:if>
					</c:if>
				</tr>
			</thead>
			<tbody id="listProduct-tbl">
			</tbody>
		</table>
		<script src="js/filter-table.js"></script>
		<script src="js/list-product.js"></script>
	</main>
</body>
</html>