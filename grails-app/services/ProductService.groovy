
class ProductService {

	def updateProductType(productTypeOrId, params) {
		def rtn = [:]

		rtn.productType
		if(productTypeOrId instanceof Product) {
			rtn.productType = productTypeOrId
		} else {
			rtn.productType = Product.get(productTypeOrId)
		}
		def allowed = ['title', 'description', 'active', 'productCode']
		allowed.each {allow ->
			rtn.productType."${allow}" = params[allow]
		}

		rtn.productType.save(flush:true)

		rtn
	}

	def createProductType(params) {
		updateProductType(new Product(), params)
	}

}
