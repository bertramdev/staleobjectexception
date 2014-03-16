<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
	<head>
		<title></title>
		<meta name="layout" content="shopbert/main"/>
	</head>
	<body>
	<script>
		$(function () {
			function readURL(input) {

				if (input.files && input.files[0]) {
					var reader = new FileReader();

					reader.onload = function (e) {
						$('#prod-image').attr('src', e.target.result);
					}

					reader.readAsDataURL(input.files[0]);
				}
			}

			$("#img-loader").change(function(){
				readURL(this);
			});
			
		});
	</script>
		<ol class="breadcrumb breadcrumb-arrow">
			<li><g:link resource="product"><g:message code="shopbert.products.productTypes"/></g:link></li>
			<li class="active"><span>${productType.title}</span></li>
		</ol>
		<div class="wrapper container-fluid">
			<div class="row">
				<div class="col-md-8">
					<div class="product-content">
						<g:render template="form" model="[mode: 'create', title: g.message(code: 'shopbert.create')]"/>
					</div>
				</div>
				<div class="col-md-4">
					<div class="product-content">
						<legend>Product Kits</legend>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
