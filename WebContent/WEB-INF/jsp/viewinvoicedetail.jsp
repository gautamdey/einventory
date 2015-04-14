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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Invoice Detail</title>

</head>
<body>

	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="bs-example">
		<a class="btn btn-large btn-info"
			href="/einventory-web/invoice/addinvoiceitem.html?invoiceid=${invoiceid}">Add
			Invoice Item</a>
	</div>
	<div class="bs-example">

		<table class="table table-striped">
			<thead>
				<tr>
					<td>Item Code #</td>
					<td>Item Name</td>
					<td>color</td>
					<td>Item Desc</td>
					<td>Work</td>
					<td>Stitching Cost</td>
					<td>Cost Price</td>
					<td>Additional Cost</td>
					<td>Catalog #</td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="invoiceitem" items="${invoiceitems}">
					<tr>
						<td>${invoiceitem.itemCode}</td>
						<td>${invoiceitem.itemName}</td>
						<td>${invoiceitem.color}</td>
						<td>${invoiceitem.embroidery}</td>
						<td>${invoiceitem.itemDesc}</td>
						<td>${invoiceitem.stitching}</td>
						<td>${invoiceitem.costPrice}</td>
						<td>${invoiceitem.additionalCost}</td>
						<td>${invoiceitem.catagoryId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>Footer</div>
</body>
</html>