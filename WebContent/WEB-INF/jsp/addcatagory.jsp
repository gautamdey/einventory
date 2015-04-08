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
	<div >
		<form:form method="POST" action="#">
			<div class="form-group">
				<form:label path="catagoryName" for="catagoryName">Category Name</form:label>
				<form:input path="catagoryName" class="form-control"/>
			</div>
			<div >
				<form:label path="catDesc" for="catDesc">Description</form:label>
				<form:input path="catDesc" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Add Category</button>
		</form:form>

 

 
 	</div>
	<div>Footer</div>
</body>
</html>

