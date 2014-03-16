class Product {
  
  Date dateCreated
  Date lastUpdated
  String title
  String productCode
  String description
  Boolean active = false
  BigDecimal price
  
  static mapping = {
		if(System.getProperty("staleobject.datasource")) datasource System.getProperty("staleobject.datasource")

  }

  static constraints = {
    productCode(nullable:true)
    title(nullable:true)
    description(nullable:true)
    price(nullable:true, scale: 2)
  }
}
