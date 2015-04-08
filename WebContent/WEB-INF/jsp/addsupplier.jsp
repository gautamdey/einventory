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
<title>add supplier</title>
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
			<div class="control-group info">
				<form:label path="supplierName" for="supplierName">Name</form:label>
				<div class="controls">
					<form:input path="supplierName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="contactPerson" for="contactPerson">Contact Person</form:label>
				<div class="controls">
					<form:input path="contactPerson" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="email" for="email">Email</form:label>
				<div class="controls">
					<form:input path="email" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="phone1" for="phone1">Phone 1</form:label>
				<div class="controls">
					<form:input path="phone1" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="phone2" for="phone2">Phone 2</form:label>
				<div class="controls">
					<form:input path="phone2" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="accountNumber" for="accountNumber">Bank Account</form:label>
				<div class="controls">
					<form:input path="accountNumber" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="accountName" for="accountName">Bank Account Name</form:label>
				<div class="controls">
					<form:input path="accountName" />
				</div>
			</div class="control-group info">
			<div class="control-group info">
				<form:label path="ifcsCode" for="ifcsCode">IFCS Code</form:label>
				<div class="controls">
					<form:input path="ifcsCode" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="bankName" for="bankName">Bank Name</form:label>
				<div class="controls">
					<form:input path="bankName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="bankBranch" for="bankBranch">Bank Branch</form:label>
				<div class="controls">
					<form:input path="bankBranch" />
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Add Item</button>
			</div>
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

