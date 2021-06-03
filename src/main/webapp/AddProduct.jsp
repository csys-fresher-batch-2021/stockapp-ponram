<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Stock</title>
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Product</h3>

		<form action="AddProductServlet" method="get">
			<label>Brand Name:</label> <input type="text" id="brandName"
				name="brandName" placeholder="Enter brand name" required /><br />

			<label>Product Name:</label> <input type="text" id="itemName"
				name="itemName" placeholder="Enter item name" required /><br /> <label>Category:</label>
			<select id="itemCategory" name="itemCategory" required>
				<option selected disabled value="">--Select Product
					category--</option>
				<option value="Mobile">Mobile</option>
				<option value="Laptop">Laptop</option>
				<option value="Headset">Headphone</option>
			</select><br /> <label>Quantity:</label> <input type="number" id="quantity"
				name="quantity" min=1 max=1000 placeholder="Enter quantity" required /><br />

			<label>Rate:</label> <input type="number" id="rate" name="rate" min=1
				max=100000 placeholder="Enter rate" required /><br />

			<button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</main>
</body>
</html>