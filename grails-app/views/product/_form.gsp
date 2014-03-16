<%--
	 action: 'save' or 'update'
--%>
<g:uploadForm controller='product' action="save" role="form" class="form-horizontal">
	<legend>${title}</legend>
	<g:hiddenField name="id" value="${params.id}" />
	<div class="form-group">
		<label for="" class="col-md-2 control-label">Title</label>
		<div class="col-md-10">
			<g:textField class="form-control" placeholder="Product name" value="${productType.title}" name="title"/>
		</div>
	</div>
	<div class="form-group">
		<label for="" class="col-md-2 control-label">Product Code</label>
		<div class="col-md-10">
			<g:textField type="text" class="form-control" placeholder="Product Code" value="${productType.productCode}" name="productCode" />
		</div>
	</div>
	<div class="form-group">
		<label for="" class="col-md-2 control-label">Description</label>
		<div class="col-md-10">
			<g:textArea placeholder="Description" class="form-control" name="description" value="${productType.description}"/>
		</div>
	</div>
	<div class="form-group">
		<label for="" class="col-md-2 control-label">Price</label>
		<div class="col-md-10">
			<input type="number" step="any" class="form-control" placeholder="Price" name="price" value="${productType.price}" name="price">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label>
					<input type="checkbox" checked="${productType.active ? 'checked' : ''}" name="active"> Active
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-primary" value="Save">
		</div>
	</div>
</g:uploadForm>
