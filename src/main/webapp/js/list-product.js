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
	let qty = document.getElementById("quantity" + id).value;
	if (qty.trim() === "") {

		toastr.error("Input is empty");
	}
	else {
		let url = "AddQuantityServlet?id=" + id + "&quantity=" + qty;
		fetch(url).then(res => res.json()).then(res => {

			let message = res;
			if (message.infoMessage != null) {
				toastr.success(message.infoMessage);
			}
			if (message.errorMessagemessage != null) {
				toastr.error(message.errorMessage);
			}
			getAllProducts();
		})
	}
}
function store() {

	let products = document.querySelectorAll("#products");
	let check = 0;
	let selectedProducts = [];
	products.forEach(obj => {
		if (obj.checked) {
			let productId = parseInt(obj.getAttribute("data-product-id"));
			let quantityTxt = document.getElementById("pquantity" + productId);// quantiy_11
			let productQuantity = parseInt(quantityTxt.getAttribute("data-product-quantity"));
			let productName = quantityTxt.getAttribute("data-product-name");
			let purchaseQty = quantityTxt.value;
			if (purchaseQty.trim() === "") {
				toastr.error(productName + " Quantity is empty");
				check = 1;
			}
			else {
				purchaseQty = parseInt(purchaseQty);
				if (productQuantity < purchaseQty) {

					toastr.error("Out of stock - " + productName);
					check = 1;
				}

				else {
					let productObj = { productId: productId, quantity: purchaseQty };
					selectedProducts.push(productObj);
				}
			}
		}
	});
	if (check != 1) {
		let orderProduct = JSON.stringify(selectedProducts);
		$.ajax({
			url: 'OrderProductsServlet',
			type: 'POST',
			data: {
				dt: orderProduct
			},
			success: function() {
				toastr.success("Purchase done");
				getAllProducts();
			},
			error: function() {
				toastr.error("Can't able place the order");
			}
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
				"<td>" + product.brandName + "</td>" +
				"<td>" + product.productName + "</td>" +
				"<td>" + product.productCategory + "</td>" +
				"<td>" + product.arrivalDate + "</td>" +
				"<td>" + product.rate + "</td>" +
				"<td>" + product.quantity + "</td>";
			if (role != null) {
				if (role.toLowerCase().localeCompare('admin') == 0) {
					content += "<td>" +
						"<a class='btn btn-success' onclick='show(" + product.productId + ")'>Click here</a>" +
						"<div id='show-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='quantity" + product.productId + "' placeholder='Enter qunatity'/>" +
						"<a id='check' onclick='send(" + product.productId + ")' class='btn btn-success'>Add</a>" +
						"</div>" +
						"</td>" +
						"<td><a href='RemoveProductServlet?itemName=" + product.productName + "' class='btn btn-danger'>Remove</a></td>";
				}
				if (role.toLowerCase().localeCompare('user') == 0) {
					content += "<td>" +
						"<input type='checkbox' id='products' data-product-id=" + product.productId + " onclick='show(" + product.productId + ")'/>" +
						"</td>" +
						"<td>" +
						"<div id='show-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='pquantity" + product.productId + "' min = 1 max=" + product.quantity + " data-product-quantity=" + product.quantity + " data-product-name= " + product.productName + " placeholder='Enter qunatity'/>" +
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