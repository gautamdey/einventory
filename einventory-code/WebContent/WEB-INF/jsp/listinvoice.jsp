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
<title>listinvoice</title>

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
					<td>Invoice #</td>
					<td>Date</td>
					<td>Supplier</td>
					<td>#</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="invoice" items="${invoices}">
					<tr>
						<td>${invoice.invoiceNum}</td>
						<td>${invoice.invoiceDate}</td>
						<td>${invoice.supplierName}</td>
						<td><button type="button" class="btn btn-default">View
								Items </button></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addinvoice.html">Add Invoice</a>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

