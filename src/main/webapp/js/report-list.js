function getAllReports() {

	let url = "ReportListServlet";
	fetch(url).then(products => products.json()).then(products => {
		let reportProducts = products;
		let content = "";
		for (let reportProduct of reportProducts) {
			content += "<tr>" +
				"<td>" + reportProduct.brandName + "</td>" +
				"<td>" + reportProduct.productName + "</td>" +
				"<td>" + reportProduct.productCategory + "</td>" +
				"<td>" + reportProduct.arrivalDate + "</td>" +
				"<td>" + reportProduct.rate + "</td>" +
				"<td>" + reportProduct.initialQuantity+ "</td>"+
				"<td>" + reportProduct.quantity + "</td>";
				
				let status = "Active"
				if(!reportProduct.status){
					
					status = "Inactive";
				}
				
				content += "<td>"+status+"</td>"+
				"<td>"+
				"<a href='SalesDetailsReport.jsp?productId=" + reportProduct.productId + "' class='btn btn-primary')'>Click here</a>"+
				"</td>"+
				"</tr>";
		}

		document.querySelector("#reportlist-tbl").innerHTML = content;
	})

}
getAllReports();