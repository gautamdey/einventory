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
	<form:form method="POST" action="/einventory-web/shipment/checkinshipment.html" modelAttribute="command">
		<div class="bs-example">Items :</div>
		<div class="bs-example">
			<form:checkboxes items="${itemlists}" path="selectedItems"
				itemLabel="itemName" itemValue="itemCode" delimiter=" <br/>" />
			<form:hidden path="invoiceId" value="${invoiceId}" />

		</div>
		<div class="bs-example">
			<button type="submit" class="btn btn-primary">Checkin Item</button>
		</div>
	</form:form>
	<div>Footer</div>
</body>
</html>

