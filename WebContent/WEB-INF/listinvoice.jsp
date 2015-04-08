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
<title>Invoice Detail</title>

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
					<td>Item Code #</td>
					<td>Item Name</td>
					<td>Item Desc</td>
					<td>Cost Price</td>
					<td>Import Duty</td>
					<td>Catalogid</td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="invoiceitem" items="${invoiceitems}">
					<tr>
						<td>${invoiceitem.itemCode}</td>
						<td>${invoiceitem.itemName}</td>
						<td>${invoiceitem.itemDesc}</td>
						<td>${invoiceitem.costPrice}</td>
						<td>${invoiceitem.importDuty}</td>
						<td>${invoiceitem.catagoryId}</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addinvoice.html">Add
				Invoice</a>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

