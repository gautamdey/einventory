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
<title>add item</title>
<style type="text/css">
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
				<form:label path="itemCode" for="itemCode">Code</form:label>
				<div class="controls">
					<form:input path="itemCode" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="itemName" for="itemName">Name</form:label>
				<div class="controls">
					<form:input path="itemName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="itemDesc" for="itemDesc">Description</form:label>
				<div class="controls">
					<form:input path="itemDesc" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="category.catagoryId" for="category.catagoryId">Category</form:label>
				<div class="controls">
					<form:select path="category.catagoryId">
						<form:options itemLabel="catagoryName" itemValue="catagoryId" items="${categories}" />
					</form:select>
				</div>
			</div>
			<div class="control-group info">
				<form:label path="catalogId" for="catalogId">Catalog</form:label>
				<div class="controls">
					<form:input path="catalogId" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="costPrice" for="costPrice">Cost Price</form:label>
				<div class="controls">
					<form:input path="costPrice" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="supplier.supplierId" for="supplier.supplierId">Supplier</form:label>
				<div class="controls">
					<form:select path="supplier.supplierId">
						<form:options itemLabel="supplierName" itemValue="supplierId" items="${suppliers}" />
					</form:select>
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

