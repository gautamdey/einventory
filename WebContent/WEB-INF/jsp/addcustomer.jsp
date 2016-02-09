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
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
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
			class="bs-docs-example form-horizontal" commandName="customer">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<!--  <div class="control-group info" modelAttribute="command">-->
			<div class="control-group info">
				
				<form:label path="" for="fName">First Name</form:label>
				<div class="controls">
					<form:input path="fName" />
					<form:errors path="fName" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="mName" for="mName">Middle Name</form:label>
				<div class="controls">
					<form:input path="mName" />
					<form:errors path="mName" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="lName" for="lName">Last Name</form:label>
				<div class="controls">
					<form:input path="lName" />
					<form:errors path="lName" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="street" for="street">Street</form:label>
				<div class="controls">
					<form:input path="street" />
					<form:errors path="street" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="houseNo" for="houseNo">House No</form:label>
				<div class="controls">
					<form:input path="houseNo" />
					<form:errors path="houseNo" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="apt" for="apt">apt</form:label>
				<div class="controls">
					<form:input path="apt" />
					<form:errors path="apt" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="city" for="city">City</form:label>
				<div class="controls">
					<form:input path="city" />
					<form:errors path="city" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="state" for="state">State</form:label>
				<div class="controls">
					<form:input path="state" />
					<form:errors path="state" cssClass="error" />
				</div>
			</div>


			<div class="control-group info">
				<form:label path="country" for="country">Country</form:label>
				<div class="controls">
					<form:input path="country" />
					<form:errors path="country" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="phone" for="phone">Phone</form:label>
				<div class="controls">
					<form:input path="phone" />
					<form:errors path="phone" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="mphone" for="mphone">Mobile Phone</form:label>
				<div class="controls">
					<form:input path="mphone" />
					<form:errors path="mphone" cssClass="error" />
				</div>
			</div>
			<div class="control-group info">
				<form:label path="email" for="email">Email </form:label>
				<div class="controls">
					<form:input type="email" path="email" />
					<form:errors path="email" cssClass="error" />
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

