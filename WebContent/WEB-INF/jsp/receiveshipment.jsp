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
	function doAjaxGet() {
		var invoiceId = $('#invoiceId').val();
		console.log(invoiceId);
		$.ajax({
			headers : {
				Accept : "application/json"
			},
			type : "GET",
			/* 			dataType: 'json', */
			url : "/einventory-web/shipment/getInvoiceItem?invoiceId="
					+ invoiceId,
			/* 			data : "invoiceId=" + invoiceId, */
			success : function(response) {
				alert(invoiceId);
				alert(response.field1 + " " + response.field2);
				var obj = JSON.parse(response);
				alert(obj.field1 + " " + obj.field2);
				
				/* 				$('#info').html(""); */
				// we have the response
				/* alert(response); */
				/* 				$('#info').html(response); */

			},
			error : function(e) {
				alert('Error: ' + e);

			}
		});
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
					<td><select class="form-control" id="invoiceItemId">
							<c:forEach var="invoice" items="${invoices}">
								<option value=${invoice.invoiceItemId}>${invoice.invoiceNum}</option>
							</c:forEach>
					</select></td>

					<td><a class="btn btn-large btn-info" href="#"
						onclick="doAjaxGet()">Select Invoice</a></td>
				</tr>
			</table>
		</div>
		<div id="info" style="color: green;"></div>
	</div>
	<div>Footer</div>
</body>
</html>

