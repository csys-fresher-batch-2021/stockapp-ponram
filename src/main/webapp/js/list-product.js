/**
 * This method is used to filter the product in the table by brand name 
 */
function filter_brand() {
	let input, filter, table, row, data, i, txtValue;
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

/**
 *This method is used to show the hidden input box
 */
function show(a) {
	let x = document.getElementById("show-" + a);
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}
/**
 *This method use the used display the message for success or error message
 */
function send(id) {
	let qty = document.getElementById("quantity"+id).value;
	if(qty.trim()===""){
		
		toastr.error("Input is empty");
	}
	else{
		let url = "AddQuantityServlet?id=" + id + "&quantity=" + qty;
		fetch(url).then(res => res.json()).then(res => {
		
		let message = res;
		if(message.infoMessage != null){
			toastr.success(message.infoMessage);
		}
		if(message.errorMessagemessage != null){
			toastr.error(message.errorMessage);
		}
		getAllProducts();
	})
	}
}
/**
 *This method use the used receive plane text response and convert it into json value then display it in table
 */
function getAllProducts() {

	let role = sessionStorage.getItem("USER_ROLE");
	let url = "ListProductServlet";
	fetch(url).then(res => res.json()).then(res => {
		let products = res;
		let content = "";
		for (let product of products) {
			content += "<tr>" +
				"<td>" + product.productId + "</td>" +
				"<td>" + product.brandName + "</td>" +
				"<td>" + product.productName + "</td>" +
				"<td>" + product.productCategory + "</td>" +
				"<td>" + product.arrivalDate + "</td>" +
				"<td>" + product.rate + "</td>" +
				"<td>" + product.quantity + "</td>";
			if (role != null) {
				if (role.toLowerCase().localeCompare('admin') == 0) {
					content += "<td>" +
						"<a class='btn btn-success' onclick='show(" + product.productId + ")'>Add</a>" +
						"<div id='show-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='quantity" + product.productId + "' placeholder='Enter qunatity'/>" +
						"<a id='check' onclick='send(" + product.productId + ")' class='btn btn-success'>Add</a>" +
						"</div>" +
						"</td>" +
						"<td><a href='RemoveProductServlet?itemName=" + product.productName + "' class='btn btn-danger'>Remove</a></td>";
				}
				if(role.toLowerCase().localeCompare('user') == 0){
					content += "<td>" +
						"<input type='checkbox' id='book" + product.productId + "'/>" +
						"<div id='show-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='quantity" + product.productId + "' placeholder='Enter qunatity'/>" +
						"</div>" +
						"</td>";
				}
			}

			content += "</tr>";
		}

		document.querySelector("#listProduct-tbl").innerHTML = content;
	})

}
getAllProducts();