<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>list supplier</title>

</head>
<body>

	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addcustomer.html">Add
				Customer</a>
		</div>

	<div class="bs-example">

		<table class="table table-striped">
			<thead>
				<tr>
					<td>First Name #</td>
					<td>Middle Name #</td>
					<td>Second Name #</td>
					<td>email</td>
					<td>phone1</td>
					<td>Mobile</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td><a href="updatecustomer.html?custid=${customer.custId}">${customer.fName}</a></td>
						<td>${customer.mName}</td>
						<td>${customer.lName}</td>
						<td>${customer.email}</td>
						<td>${customer.phone}</td>
						<td>${supplier.mphone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addcustomr.html">Add
				Customer</a>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

