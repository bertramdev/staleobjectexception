<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
	<head>
		<title></title>
		<meta name="layout" content="shopbert/main"/>
	</head>
	<body>
		<ol class="breadcrumb breadcrumb-arrow">
			<li><g:link controller='shopBertHome'><g:message code='shopbert.accounts.menu.home' /></g:link></li>
			<li><g:link resource="product"><g:message code="shopbert.products.productTypes"/></g:link></li>
			<li class="active"><span>${productType?.title}</span></li>
		</ol>
		<div class="wrapper container-fluid">
			<h1 class="page-header">${productType?.title}</h1>
			<g:link class="pull-right" resource='product' action='edit' id="${productType?.id}"><g:message code="shopbert.edit"/></g:link>
			<div class="row product-content">
				<div class="col-md-12">
					<g:if test="${productType?.description}">
						<p>
							${productType.description}
						</p>
					</g:if>
				</div>
			</div>
		</div>
	</body>
</html>
