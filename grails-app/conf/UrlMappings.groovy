class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"(parseRequest:true){
			constraints {
				// apply constraints here
			}
		}

		"500"(view:'/error')
	}

}
