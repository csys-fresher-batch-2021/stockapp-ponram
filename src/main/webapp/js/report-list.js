/**
 * This method is used to filter the product in the table by brand name 
 */
function filter_brand() {
	let input, inputFilter, table, row, data, i, txtValue;
	input = document.getElementById("filter");
	inputFilter = input.value.toUpperCase();
	table = document.getElementById("list");
	row = table.getElementsByTagName("tr");
	for (i = 0; i < row.length; i++) {
		data = row[i].getElementsByTagName("td")[0];
		if (data) {
			txtValue = data.textContent || data.innerText;
			if (txtValue.toUpperCase().indexOf(inputFilter) > -1) {
				row[i].style.display = "";
			} else {
				row[i].style.display = "none";
			}
		}
	}
}

function getAllReports() {

	let url = "ReportListServlet";
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
				"<td>" + product.initialQuantity+ "</td>"+
				"<td>" + product.quantity + "</td>";
				
				if(product.status){
					
					content += "<td>Active</td>";
				} else{
					
					content += "<td>InActive</td>";
				}
				content += "<td>"+
				"<a href='SalesDetailsReport.jsp?productId=" + product.productId + "' class='btn btn-primary')'>Click here</a>"+
				"</td>"+
				"</tr>";
		}

		document.querySelector("#reportlist-tbl").innerHTML = content;
	})

}
getAllReports();