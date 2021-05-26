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

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<%
String role = (String)session.getAttribute("ROLE");
%>
		<h3>List of stock</h3>
		
		<table class="table table-bordered">
		<caption>List all the product in the stock</caption>
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Item Name</th>
					<th scope="col">Category</th>
					<th scope="col">Arrival date</th>
					<th scope="col">Quantity</th>
					<th scope="col">Rate</th>
					<% if(role != null){ %>
					<th scope="col">Remove</th>
					<%} %>
				</tr>
			</thead>
			<tbody>
					<%
					ProductDAO display = new ProductDAO();
					List<Product> stocks=display.findAll();
					int i=0;
					for(Product product:stocks){
						i++;
						%>
			     <tr>
			     <td><%=product.getProductId()%></td> 
			     <td><%=product.getBrandName()%></td> 
			     <td><%=product.getProductName()%></td> 
			     <td><%=product.getProductCategory()%></td>
			     <td><%=product.getArrivalDate()%></td>
			     <td><%=product.getQuantity()%></td>  
			     <td><%=product.getRate()%></td> 
			     <% if(role != null){ %>
			     <td><a href="RemoveProductServlet?itemName=<%= product.getProductName()%>" class="btn btn-danger">Remove</a></td>
    			 </tr>
				 <% } %>
				 <%} %>
				</tbody>
				</table>
		
	</main>
</body>
</html>