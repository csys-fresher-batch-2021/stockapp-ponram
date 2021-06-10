<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<script src="assets/js/jquery.min.js"></script>
<link rel="stylesheet" href="assets/css/style.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<script
	src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<c:set var="user" value="${sessionScope.USER_NAME}"></c:set>
<c:set var="role" value="${sessionScope.ROLE}"></c:set>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">StockApp</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<c:if test="${not empty role }">
					<c:if test="${role eq 'admin'}">
				<li class="nav-item"><a class="nav-link" href="AddProduct.jsp">Add
						product</a></li>
				<li class="nav-item"><a class="nav-link" href="StockReport.jsp">Stock
						Report</a></li>
					</c:if>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="ListProduct.jsp">List
						Product</a></li>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<c:if test="${empty role }">
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="Register.jsp">Register</a>
				</li>
				</c:if>
				<c:if test="${not empty role}">
				<li class="nav-item"><a class="nav-link" href="#">Welcome ${user}</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet"
					onClick="logout()">Logout</a></li>
					</c:if>
			</ul>

		</div>
	</nav>
</header>

<script>
let userRole = "${role}";
if(userRole !='null'){
	sessionStorage.setItem("USER_ROLE", userRole);
}

function logout(){
	sessionStorage.clear();
}
</script>