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
<title>addcatagory</title>
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
	<div class="container">
		<form:form method="POST" action="#"
			class="bs-docs-example form-horizontal">
			<div class="control-group warning">
				<form:label path="itemCode" for="itemCode">Code</form:label>
				<div class="controls">
					<form:input path="itemCode" />
				</div>
			</div>
			
			<div>
				<form:label path="itemName" for="itemName">Name</form:label>
				<form:input path="itemName" />
			</div>
			<div>
				<form:label path="itemDesc" for="itemDesc">Description</form:label>
				<form:input path="itemDesc" />
			</div>
			<div>
				<form:label path="catagoryId" for="catagoryId">Catagory</form:label>
				<form:input path="catagoryId" />
			</div>
			<div>
				<form:label path="catalogId" for="catalogId">Catalog</form:label>
				<form:input path="catalogId" />
			</div>
			<div>
				<form:label path="shippingcost" for="shippingcost">shipping cost</form:label>
				<form:input path="shippingcost" />
			</div>
			<div>
				<form:label path="importduty" for="importduty">Import Duty</form:label>
				<form:input path="importduty" />
			</div>
			<div>
				<form:label path="shipmentid" for="shipmentid">Shipment Id </form:label>
				<form:input path="importduty" />
			</div>
	@Column(name = "costprice")
	private BigDecimal costPrice;
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

