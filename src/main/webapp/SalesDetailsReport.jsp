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
<title>Sales Details</title>
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
		<h3>Sales Details</h3>
		<h2 class="badge badge-success">Total sales:-<span id = "total-sales"></span></h2>
		<h2 class="badge badge-success">Total Sold quantity:-<span id = "total-sales-quantity"></span></h2>
		<h2 class="badge badge-info">Total Soled prize&#8377;:-<span id = "total-sale-samount"></span></h2>
		<table class="table	table-bordered" id="list">
			<caption>List all sales details</caption>
			<thead>
				<tr>
					<th scope="col">Bill no</th>
					<th scope="col">Customer Name</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Product Name</th>
					<th scope="col">Prize&#8377;</th>
					<th scope="col">Purchased Quantity</th>
					<th scope="col">Total Amount&#8377;</th>
					<th scope="col">Purchased Date</th>
				</tr>
			</thead>
			<tbody id="salesreport-tbl">
			</tbody>
		</table>
		<script>
		function getSalesDetails() {

			let url = "PurchaseDetailReport?productId="+<%= value %>;
			let totalsales = 0;
			let totalSalesQuantity = 0;
			let totalSalesAmount = 0;
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
					totalsales = totalsales + 1;
					totalSalesQuantity = totalSalesQuantity + userDetail.orderDetail.quantity;
					totalSalesAmount  = totalSalesAmount + userDetail.orderDetail.totalAmount;
				}
				document.querySelector("#total-sales").innerHTML = totalsales;
				document.querySelector("#total-sales-quantity").innerHTML = totalSalesQuantity;
				document.querySelector("#total-sale-samount").innerHTML = totalSalesAmount;
				document.querySelector("#salesreport-tbl").innerHTML = content;
			})

		}
		getSalesDetails();
		</script>
	</main>
</body>
</html>