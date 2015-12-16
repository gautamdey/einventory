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
			href="/einventory-web/purchaseorder/addpoitem.html?poid=${poid}">Add
			Item</a>
	</div>
	<div class="bs-example">

		<table class="table table-striped">
			<thead>
				<tr>
					<td>Code</td>
					<td>Name</td>
					<td>Desc</td>
					<td>catagoryId</td>
					<td>catlogId</td>
					<td>unitCost</td>
					<td>stitchingCost</td>
					<td>costPrice</td>
					<td>quantity</td>
					<td>discount</td>
					<td>netCost</td>
					<td>embroidery</td>
					<td>stitchingDetail</td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="poitem" items="${poitems}">
					<tr>
						<td>${poitem.itemCode}</td>
						<td>${poitem.itemName}</td>
						<td>${poitem.itemDesc}</td>
						<td>${poitem.catagoryId}</td>
						<td>${poitem.catlogId}</td>
						<td>${poitem.unitCost}</td>
						<td>${poitem.stitchingCost}</td>
						<td>${poitem.costPrice}</td>
						<td>${poitem.quantity}</td>
						<td>${poitem.discount}</td>
						<td>${poitem.netCost}</td>
						<td>${poitem.embroidery}</td>
						<td>${poitem.stitchingDetail}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>Footer</div>
</body>
</html>