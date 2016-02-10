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
			<div class="control-group info">
				<form:label path="categoryId" for="categoryId">Category</form:label>
				<div class="controls">
					<form:select path="categoryId">
						<form:options items="${categories}" />
					</form:select>
				</div>
			</div>
			<div>
				<form:label path="catalogId" for="catalogId">Catalog</form:label>
				<form:input path="catalogId" />
			</div>
			<div>
				<form:label path="costPrice" for="costPrice">Cost Price</form:label>
				<form:input path="costPrice" />
			</div>

			<div class="control-group info">
				<form:label path="suppilerId" for="supplierId">Supplier</form:label>
				<div class="controls">
					<form:select path="supplierId">
						<form:options items="${suppliers}" />
					</form:select>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

