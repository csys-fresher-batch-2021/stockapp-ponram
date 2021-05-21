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
					<th scope="col">S.no</th>
					<th scope="col">Item Id</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Item Name</th>
					<th scope="col">Category</th>
					<th scope="col">Rate</th>
					<th scope="col">Quantity</th>
					<% if(role != null){ %>
					<th scope="col">Remove</th>
					<%} %>
					<%
					List<Product> stocks=ProductDAO.getStock();
					int i=0;
					for(Product product:stocks){
						i++;
						%>
			     <tr>
			     <td><%=i%></td>
			     <td><%=product.getItemId()%></td> 
			     <td><%=product.getBrandName()%></td> 
			     <td><%=product.getItemName()%></td> 
			     <td><%=product.getItemCategory()%></td>
			     <td><%=product.getRate()%></td> 
			     <td><%=product.getQuantity()%></td>  
			     <% if(role != null){ %>
			     <td><a href="RemoveProductServlet?itemName=<%= product.getItemName()%>" class="btn btn-danger">Remove</a></td>
    			 </tr>
				 <% } %>
				 <%} %>
			</thead>
				</table>
		
	</main>
</body>
</html>