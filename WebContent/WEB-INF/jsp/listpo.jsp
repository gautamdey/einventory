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
					<td>Purchase #</td>
					<td>date</td>
					<td>Supplier</td>
					<td>Import duty</td>
					<td>Shipping</td>
					<td>Total Item</td>
					<td>Net Amount</td>
					<td>#</td>
					<td>#</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="po" items="${pos}">
					<tr>
						<td>${po.poNum}</td>
						<td>${po.poDate}</td>
						<td>${po.supplierId}</td>
						<td>${po.importDuty}</td>
						<td>${po.shippingCost}</td>
						<td>${po.itemCount}</td>
						<td>${po.netAmount}</td>
					<td>
						<a class="btn btn-large btn-info" href="/einventory-web/purchaseorder/editpodetail.html?poid=${po.poId}">View/Edit Purchase Order</a>
						</td>
						<td>
						<a class="btn btn-large btn-info" href="/einventory-web/purchaseorder/viewpodetail.html?poid=${po.poId}">View Items</a>
						</td>
			
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="browse_app">
			<a class="btn btn-large btn-info" href="addpo.html">Add
				Purchase Order </a>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

