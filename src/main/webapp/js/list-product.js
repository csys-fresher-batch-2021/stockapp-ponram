
/**
 *This method use the used display the message for success or error message
 */
function send(id) {
	let textBox = document.querySelector("#quantity" + id);
	let quantity = textBox.value;
	let product = textBox.getAttribute("data-product-name");
	if (isNotEmptyInput(quantity, product) && isValidateQuantity(parseInt(quantity))) {
		let url = "AddQuantityServlet?id=" + id + "&quantity=" + quantity;
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

function isNotEmptyInput(input, product) {

	let valid = true;
	if (input.trim() === "") {

		toastr.error(product + " quantity is empty");
		valid = false;
	}
	return valid;
}

function isValidateQuantity(quantity) {
	let valid = true;
	if (quantity <= 0) {
		toastr.error("Invalid quantity");
		valid = false;
	}
	return valid;
}

function store() {

	let noOfSuccess = 0, noOfItems = 0;
	let products = document.querySelectorAll("#products");
	let check = false;
	let selectedProducts = [];
	products.forEach(obj => {
		if (obj.checked) {
			let productId = parseInt(obj.getAttribute("data-product-id"));
			let quantityTxt = document.getElementById("pquantity" + productId);// quantiy_11
			let productQuantity = parseInt(quantityTxt.getAttribute("data-product-quantity"));
			let productName = quantityTxt.getAttribute("data-product-name");
			let purchaseQty = quantityTxt.value;
			check = isNotEmptyInput(purchaseQty, productName);
			if (check) {
				check = isValidateQuantity(parseInt(purchaseQty));
				if (check && productQuantity < parseInt(purchaseQty)) {

					toastr.error("Out of stock - " + productName);
					check = false;
				}
			}
			if (check) {
				let productObj = { productId: productId, quantity: purchaseQty };
				selectedProducts.push(productObj);
				noOfSuccess++;
			}
			noOfItems++;
		}
	});
	if (noOfItems == noOfSuccess) {
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
			error: function(errorMessage) {
				toastr.error(errorMessage);
			}
		})
	}
}
/**
 *This method is used to show the hidden input box
 */
function show(a) {
	let textBox = document.getElementById("show-" + a);
	let clickherebtn = document.getElementById("clickhere" + a);
	if (textBox.style.display === "none") {

		clickherebtn.style.display = "none";
		textBox.style.display = "block";

	} else {

		textBox.value = "";
		clickherebtn.style.display = "block"
		textBox.style.display = "none";
	}
}
/**
 *This method is used to show the hidden input box
*/
function display(a) {
	let textBox = document.getElementById("display-" + a);
	if (textBox.style.display === "none") {

		textBox.style.display = "block";

	} else {

		textBox.style.display = "none";
	}
}
function table_view(product) {
	let value = "";
	value = "<tr>" +
		"<td>" + product.brandName + "</td>" +
		"<td>" + product.productName + "</td>" +
		"<td>" + product.productCategory + "</td>" +
		"<td>" + product.arrivalDate + "</td>" +
		"<td>" + product.rate + "</td>" +
		"<td>" + product.quantity + "</td>";
	return value;
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
			if (role == null && product.quantity > 0) {

				content += table_view(product);
			}
			if (role != null) {
				if (role.toLowerCase().localeCompare('admin') == 0) {
					content += table_view(product) + "<td>" +
						"<a class='btn btn-success' id='clickhere" + product.productId + "' onclick='show(" + product.productId + ")'>Click here</a>" +
						"<div id='show-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='quantity" + product.productId + "' data-product-name= " + product.productName + " placeholder='Enter qunatity'/> &nbsp;" +
						"<a id='check' onclick=send(" + product.productId + ") class='btn btn-success'>Add</a>&nbsp;" +
						"<a id='check' onclick=show(" + product.productId + ") class='btn btn-danger'>Cancel</a>&nbsp;" +
						"</div>" +
						"</td>" +
						"<td><a href='RemoveProductServlet?itemName=" + product.productName + "' class='btn btn-danger'>Remove</a></td>";
				}
				if (role.toLowerCase().localeCompare('user') == 0 && product.quantity > 0) {
					content += table_view(product) + "<td>" +
						"<input type='checkbox' id='products' data-product-id=" + product.productId + " onclick='display(" + product.productId + ")'/>" +
						"</td>" +
						"<td>" +
						"<div id='display-" + product.productId + "' style='display:none'>" +
						"<input type='number' id='pquantity" + product.productId + "' min = 1 max=" + product.quantity + " data-product-quantity=" + product.quantity + " data-product-name= " + product.productName + "/>" +
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