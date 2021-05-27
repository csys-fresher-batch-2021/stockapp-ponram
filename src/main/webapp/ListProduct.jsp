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
					<th scope="col">Remove</th>
					<%} %>
				</tr>
			</thead>
			<tbody id="listProduct-tbl">
			</tbody>
		</table>
		<script>
		function filter_brand() {
			  var input, filter, table, row, data, i, txtValue;
			  input = document.getElementById("filter");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("list");
			  row = table.getElementsByTagName("tr");
			  for (i = 0; i < row.length; i++) {
				data = row[i].getElementsByTagName("td")[1];
			    if (data) {
			      txtValue = data.textContent || data.innerText;
			      if (txtValue.toUpperCase().indexOf(filter) > -1) {
			    	  row[i].style.display = "";
			      } else {
			    	  row[i].style.display = "none";
			      }
			    }       
			  }
			}
	  function getAllProducts(){
		  
		let role = localStorage.getItem("USER_ROLE");
		  console.log(role);
	console.log("Fetching all tasks ");
	let url = "ListProductServlet";
	//"  naresh ".trim().length() => method chaining
	fetch(url).then(res=> res.json()).then(res=>{
		let tasks = res;
		console.log(tasks);
		let content = "";
		for(let task of tasks){
			content += "<tr>"+
			"<td>" + task.productId+ "</td>"+
			"<td>" + task.brandName + "</td>"+
			"<td>" + task.productName+"</td>"+
			"<td>" + task.productCategory+"</td>"+
			"<td>" + task.arrivalDate+"</td>"+
			"<td>" + task.rate+"</td>"+
			"<td>" + task.quantity+"</td>";
			if(role != null){
				let value = role.toLowerCase().localeCompare('admin');
				if(value >= 0){
				    content+= "<td><a href='RemoveProductServlet?itemName=" +task.productName+"' class='btn btn-danger'>Remove</a></td>";
				}
			}
			
			
			content +="</tr>";
			
		}
		console.log(content);
		
		document.querySelector("#listProduct-tbl").innerHTML= content;
		
	})
	
}
getAllProducts();
</script>
	</main>
</body>
</html>
