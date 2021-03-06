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
	<form:form method="POST"
		action="/einventory-web/shipment/receiveshipment"
		modelAttribute="command">
		<div class="bs-example">Items :</div>
		<div class="bs-example">

			<table class="table table-striped">
				<thead>
					<tr>
						<td>#</td>
						<td>Item</td>
						<td>Quantity Order</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${itemlists}">
						<tr>
							<td><input type="checkbox" name="selectedItems"
								value="${item.itemCode}" /></td>
							<td>${item.itemName}</td>
							<td>${item.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<form:hidden path="poId" value="${poId}" />

		</div>
		<div class="bs-example">
			<button type="submit" class="btn btn-primary">Checkin Item</button>
		</div>
	</form:form>
	<div>Footer</div>
</body>
</html>

