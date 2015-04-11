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
<title>addcatagory</title>

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
			<div class="control-group info">
				<form:label path="invoiceNum" for="invoiceNum">Invoice #</form:label>
				<div class="controls">
					<form:input path="invoiceNum" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="invoiceDate" for="invoiceDate">Date</form:label>
				<div class='input-group date' id='datetimepicker1'>
					<form:input path="invoiceDate" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="supplierId" for="supplierId">Supplier</form:label>
				<div class="controls">
					<form:select path="supplierId">
						<form:options items="${suppliers}" />
					</form:select>
				</div>
			</div>
			<div class="control-group info">
				<form:label path="importduty" for="importduty">Import Duty</form:label>
				<div class="controls">
					<form:input path="importduty" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="shippingCost" for="shippingCost">Shipping Cost</form:label>
				<div class="controls">
					<form:input path="shippingCost" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="itemCount" for="itemCount">Item Count</form:label>
				<div class="controls">
					<form:input path="itemCount" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="netAmount" for="netAmount">Net Amount</form:label>
				<div class="controls">
					<form:input path="netAmount" />
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Add Invoice</button>
			</div>
		</form:form>

	</div>
	<div>Footer</div>
</body>
</html>

