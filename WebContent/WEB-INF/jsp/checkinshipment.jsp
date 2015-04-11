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
			href="/einventory-web/invoice/addinvoiceitem.html?invoiceid=${invoiceid}">Checkin Item</a>
	</div>
	<div class="bs-example">
		<form:form method="POST" >
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Item Code #</td>
						<td>Item Name</td>
						<td>#</td>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="invoiceitem" items="${itemlists}">
						<tr>
							<td>${invoiceitem.itemCode}</td>
							<td>${invoiceitem.itemName}</td>
							<td><form:checkbox path="itemCode" value="${invoiceitem.itemCode}" />Java </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form:hidden path="invoiceId" />
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

