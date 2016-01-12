<div class="bs-example">
	<div class="page-header">
		<h1>
			Einventory <small>RazzelDazzel Inventory management</small>
		</h1>
	</div>

</div>
<div class="bs-example">
	<nav role="navigation" class="navbar navbar-default">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">Brand</a>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="list-group-item"><a href="/einventory-web/welcome.html">Home</a></li>
				<li class="list-group-item"><a href="/einventory-web/listcatagory.html">Category</a></li>
				<li class="list-group-item"><a href="/einventory-web/invoice/listinvoice.html">Invoice</a></li>
				<li class="list-group-item"><a href="/einventory-web/listsupplier.html">Supplier</a></li>
				<li class="list-group-item"><a href="/einventory-web/listcatalog.html">Catalog</a></li>
				<li class="list-group-item"><a href="/einventory-web/getInvoiceItem.html">Test</a></li>
				<li class="list-group-item"><a href="/einventory-web/purchaseorder/listpo.html">Purchase Order</a></li>
				<li class="list-group-item"><a
					href="/einventory-web/customer/listcustomer.html">Customers</a></li>
				<li class="class="list-group-item dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">Stock <b class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">View Item Stock</a></li>
						<li><a
							href="/einventory-web/shipment/checkinshipmentstart.html">Receive
								Shipment</a></li>
					</ul></li>
			</ul>
			<form role="search" class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" placeholder="Search" class="form-control">
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
			</ul>
		</div>
	</nav>
</div>
<script type="text/javascript">
  $('.list-group-item').on('click',function(e){
    //var previous = $(this).closest(".nav").children(".active");
    //previous.removeClass('active'); // previous list-item
    $(e.target).addClass('active'); // activated list-item
  });

</script>
