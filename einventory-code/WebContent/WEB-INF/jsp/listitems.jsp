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
<title>listitems</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
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
					<td>Item code</td>
					<td>Name</td>
					<td>desc</td>
					<td>Catagory ID</td>
					<td>Catalog ID</td>
					<td>cost price</td>
					<td>Shipping cost</td>
					<td>Import duty</td>
					<td>ShipmentId</td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.itemCode}</td>
						<td>${item.itemName}</td>
						<td>${item.itemDesc}</td>
						<td>${item.catagoryId}</td>
						<td>${item.catalogId}</td>
						<td>${item.costPrice}</td>
						<td>${item.shippingCost}</td>
						<td>${item.importDuty}</td>
						<td>${item.shipmentId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>Footer</div>
</body>
</html>