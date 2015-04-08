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
<title>add catalog</title>

</head>
<body>

	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="container">

		<form:form method="POST" action="#"
			class="bs-docs-example form-horizontal"  modelAttribute="command">
			<div class="control-group info" >
				<form:label path="catalogName" for="invoiceNum">Catalog Name #</form:label>
				<div class="controls">
					<form:input path="catalogName" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="catalogDesc" for="supplierId">Desc</form:label>
				<div class="controls">
					<form:input path="catalogDesc" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="catagoryId" for="catagoryId">Category</form:label>
				<div class="controls">
					<form:select path="catagoryId">
						<form:options items="${categories}" />
					</form:select>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Add Catalog</button>
			</div>
		</form:form>

	</div>
	<div>Footer</div>
</body>
</html>

