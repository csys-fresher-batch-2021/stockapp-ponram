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
