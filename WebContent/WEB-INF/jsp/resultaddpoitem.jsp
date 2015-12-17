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
<title>result add po item</title>

</head>
<body>
	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="bs-example">
	<div class="bs-example">
	 Item created 
	</div>
		Item created
		<div>
			<a href="addpo.html">add more invoice </a>
		</div>
		<div>
			<a href="/einventory-web/po/addpoitem.html?poid=${poId}">Add more item to
				Purchase Order</a>				
				 <c:out value="${poId}"/>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>