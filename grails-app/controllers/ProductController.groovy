class ProductController {
	def productService

	def show() {
		def rtn = [:]
		rtn.productType = Product.get(params.long('id'))
		render(view:'show', model:rtn)
	}

	def index() {
		log.debug 'index'
		def rtn = [:]
		rtn.productTypes = Product.list()
		render(view:'index', model:rtn)
	}

	def create() {
		def rtn = [:]
		rtn.productType = new Product()

		render view: 'create', model: rtn
	}

	def edit () {
		def rtn = [:]
		rtn.productType = Product.get(params.long('id'))
		render(view:'edit', model:rtn)
	}

	def save () {
		def rtn = [:]

		try {
			if (params.id) {
				rtn = productService.updateProductType(params.long('id'), params)
			}
			else {
				rtn = productService.createProductType(params)
			}
		} catch(e) {
			flash.error = "Error saving product type: ${e.message}"
			log.warn e
			render view: (request.post ? 'create' : 'edit'), model: rtn
			return
		}

		if(rtn.productType.hasErrors()) {
			log.warn rtn.productType.errors
			render view: (request.post ? 'create' : 'edit'), model: rtn
		} else {
			redirect(resource: 'product', action:'show', id: rtn.productType.id)
		}
	}
}