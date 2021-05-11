<%@page import="in.ponram.service.ProductManager"%>
<%@page import="in.ponram.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String itemId = request.getParameter("itemId");
		String brandName = request.getParameter("brandName");
		String itemName = request.getParameter("itemName");
		String itemCategory = request.getParameter("itemCategory");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Product product1 = new Product(itemId, brandName, itemName, itemCategory, rate, quantity);
		
		boolean success = ProductManager.addStock(product1);
		if(success){
			String infoMessage = "Product Added Successfully";
			response.sendRedirect("add_product.jsp?infoMessage=" + infoMessage);
		}
		else{
			String errorMessage="Invalid product";
			response.sendRedirect("add_product.jsp?errorMessage=" + errorMessage);
		}
	%>
</body>
</html>