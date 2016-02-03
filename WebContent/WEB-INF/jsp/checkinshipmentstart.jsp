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

<script type="text/javascript">
function callcheckin()
{
		var poId = $('#poId').val();
		console.log(invoiceId);
		window.location="/einventory-web/shipment/checkinshipment.html?poId="+poId;
	} 

	</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>receive shipment</title>



</head>
<body>

	<br>
	<br>
	<div>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</div>
	<div class="container">
		<div class="control-group info">
			<table>
				<tr>
					<td><select class="form-control" id="poId">
							<c:forEach var="po" items="${pos}">
								<option value="${po.poId}">${po.poNum}</option>
							</c:forEach>
					</select></td>
					<td><input type="button" onclick="callcheckin();"  value ="Select Purchase Order" class="btn btn-primary"></td>
				</tr>
			</table>
		</div>
	</div>
	<div>Footer</div>
</body>
</html>

