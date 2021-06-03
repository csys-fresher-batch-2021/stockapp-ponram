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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
	<%
String value = request.getParameter("productId");
%>
	<div id="message" style="color: green;"></div>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of stock</h3>

		<div class="row">
			<div class="col-md-6">
				<label>Filter:</label> <input type="text" class="brandFilter"
					id="filter" onkeyup="filter_brand()" placeholder="Brand name">
			</div>
			<div class="col-md-6 text-right "></div>
		</div>
		<table class="table	table-bordered" id="list">
			<caption>List all the product in the stock</caption>
			<thead>
				<tr>
					<th scope="col">Bill no</th>
					<th scope="col">Customer Name</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Product Name</th>
					<th scope="col">Rate</th>
					<th scope="col">Purchased Quantity</th>
					<th scope="col">Total Amount</th>
					<th scope="col">Purchased Date</th>
				</tr>
			</thead>
			<tbody id="salesreport-tbl">
			</tbody>
		</table>
		<script>
		function getSalesDetails() {

			let url = "PurchaseDetailReport?productId="+<%= value %>;
			fetch(url).then(res => res.json()).then(res => {
				let userDetails = res;
				let content = "";
				for (let userDetail of userDetails) {
					
					content += "<tr>" +
						"<td>" + userDetail.billNumber + "</td>" +
						"<td>" + userDetail.customerName + "</td>" +
						"<td>" + userDetail.orderDetail.brandName + "</td>" +
						"<td>" + userDetail.orderDetail.productName + "</td>" +
						"<td>" + userDetail.orderDetail.rate + "</td>"+
						"<td>" + userDetail.orderDetail.quantity + "</td>" +
						"<td>" + userDetail.orderDetail.totalAmount + "</td>"+
						"<td>" + userDetail.purchaseDate + "</td>" +
						"</tr>";
				}

				document.querySelector("#salesreport-tbl").innerHTML = content;
			})

		}
		getSalesDetails();
		</script>
	</main>
</body>
</html>