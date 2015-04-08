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
	<div class="bs-example">

		<table class="table table-striped">
			<thead>
				<tr>
					<td>Supplier Name #</td>
					<td>email</td>
					<td>contact person</td>
					<td>phone1</td>
					<td>phone2</td>
					<td>Account Number</td>
					<td>Account Name</td>
					<td>IFCS Code</td>
					<td>Bank Name</td>
					<td>Bank Branch</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="supplier" items="${suppliers}">
					<tr>
						<td>${supplier.supplierName}</td>
						<td>${supplier.email}</td>
						<td>${supplier.contactPerson}</td>
						<td>${supplier.phone1}</td>
						<td>${supplier.phone2}</td>
						<td>${supplier.accountNumber}</td>
						<td>${supplier.accountName}</td>
						<td>${supplier.ifcsCode}</td>
						<td>${supplier.bankName}</td>
						<td>${supplier.bankBranch}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addsupplier.html">Add
				Supplier</a>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

