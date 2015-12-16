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
<title>add invoice item</title>

</head>
<body>

	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="container">Adding items for purchase order #
		{command.poId}</div>
	<div class="container">
		<form:form method="POST" action="#"
			class="bs-docs-example form-horizontal">
			<div class="control-group info" modelAttribute="command">

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
				<form:label path="itemDesc" for="itemDesc">Desc</form:label>
				<div class="controls">
					<form:input path="itemDesc" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="embroidery" for="embroidery">Embroidery Work</form:label>
				<div class="controls">
					<form:input path="embroidery" />
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
			<div class="control-group info">
				<form:label path="catalogId" for="catalogId">Catalog</form:label>
				<div class="controls">
					<form:select path="catalogId">
						<form:options items="${catalogs}" />
					</form:select>
				</div>
			</div>
			<div class="control-group info">
				<form:label path="unitCost" for="unitCost">Unit Cost</form:label>
				<div class="controls">
					<form:input path="unitCost" readonly="true" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="stitchingCost" for="stitchingCost">Stitching Cost</form:label>
				<div class="controls">
					<form:input path="stitchingCost" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="stitchingDetail" for="stitchingDetail">Stitching Detail</form:label>
				<div class="controls">
					<form:input path="stitchingDetail" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="quantity" for="quantity">Quantity</form:label>
				<div class="controls">
					<form:input path="quantity" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="costPrice" for="costPrice">Cost</form:label>
				<div class="controls">
					<form:input path="costPrice" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="discount" for="discount">Discount </form:label>
				<div class="controls">
					<form:input path="discount" />
				</div>
			</div>

			<div class="control-group info">
				<form:label path="netCostPrice" for="netCostPrice">Net Cost Price </form:label>
				<div class="controls">
					<form:input path="netCostPrice" readonly="true"/>
				</div>
			</div>

			
	<%-- 		<div class="control-group info">
				<div class="controls">
					<form:input path="poId" readonly="true" hidden="true" value="{command.poId}"/>
				</div>
			</div> --%>
			<div>
				<button type="submit" class="btn btn-primary">Add Item</button>
			</div>
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

