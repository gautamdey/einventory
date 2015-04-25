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
<title>add customer</title>

</head>
<body>

	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="container">Adding New Customer</div>
	<div class="container">
		<form:form method="POST" action="#"
			class="bs-docs-example form-horizontal">
			<div class="control-group info" modelAttribute="command">
				<form:label path="" for="fName">First Name</form:label>
				<div class="controls">
					<form:input path="fName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="mName" for="mName">Middle Name</form:label>
				<div class="controls">
					<form:input path="mName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="lName" for="lName">Last Name</form:label>
				<div class="controls">
					<form:input path="lName" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="street" for="street">Street</form:label>
				<div class="controls">
					<form:input path="street" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="houseNo" for="houseNo">House No</form:label>
				<div class="controls">
					<form:input path="houseNo" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="apt" for="apt">apt</form:label>
				<div class="controls">
					<form:input path="apt" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="city" for="city">City</form:label>
				<div class="controls">
					<form:input path="city" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="state" for="state">State</form:label>
				<div class="controls">
					<form:input path="state" />
				</div>
			</div>


			<div class="control-group info">
				<form:label path="country" for="country">Country</form:label>
				<div class="controls">
					<form:input path="country" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="phone" for="phone">Phone</form:label>
				<div class="controls">
					<form:input path="phone" readonly="true" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="mphone" for="mphone">Mobile Phonet</form:label>
				<div class="controls">
					<form:input path="mphone" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="email" for="email">Email </form:label>
				<div class="controls">
					<form:input path="email" />
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Add Customer</button>
			</div>
		</form:form>
	</div>
	<div>Footer</div>
</body>
</html>

