<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Stock</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Product</h3>
		
		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}

		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%> 
		
		<form action="AddProductServlet" method="get">
			<label>Item id:</label> 
			<input type="text" id="itemId" name="itemId"
				placeholder="Enter item id" autofocus required /><br /> 
				
			<label>Brand Name:</label> 
			<input type="text" id="brandName" name="brandName" 
			placeholder="Enter brand name" required /><br /> 
				
			<label>Item Name:</label>
			<input type="text" id="itemName" name="itemName" 
			placeholder="Enter item name" required /><br /> 
				
			<label>Item category:</label> 
			<select id="itemCategory" name="itemCategory" required>
					<option selected disabled value="">--Select Item category--</option>
					<option value="Mobile">Mobile</option>
					<option value="Laptop">Laptop</option>
					<option value="Headset">Headset</option>
			</select><br />
			
			<label>Quantity:</label>
			<input type="number" id="quantity" name="quantity" min=1 max=1000 
			placeholder="Enter quantity" required /><br /> 
				
			<label>Rate:</label>
			<input type="number" id="rate" name="rate" min=1 max=100000 
			placeholder="Enter rate" required /><br />
				
			<button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</main>
</body>
</html>