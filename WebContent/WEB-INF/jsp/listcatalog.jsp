<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>listcatalog</title>

</head>
<body>
 
	<br>
	<br>
	<div>
	   <%@ include file="/WEB-INF/jsp/header.jsp" %>
	</div>
	<div class="bs-example">

  	<table  class="table table-striped">
	    <thead><tr><td>Catalog#</td><td>Name</td><td>Desc#</td><td>Catagory#</td></tr></thead>
	    <tbody>
	        <c:forEach var="catalog" items="${catalogs}">
	        <tr>
	        <td>${catalog.catalogId}</td>
	        <td>${catalog.catalogName}</td>
	        <td>${catalog.catalogDesc}</td>
	        <td>${catalog.catagoryId}</td>
	        <td><button type="button" class="btn btn-default">View Items</button></td>
	            
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	</div>
			<div id="browse_app">
			<a class="btn btn-large btn-info" href="addcatalog.html">Add Catalog</a>
		</div>
	<div>
	   Footer
	</div>
</body>
</html>

 