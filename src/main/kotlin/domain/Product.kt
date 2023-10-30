package domain

data class Price(val value: Double)

data class Product(val id: String, val name: String, val description: String, val price: Price){
    init {
        require(name.isNotBlank()) { "Имя продукта не может быть пустым или состоять только из пробелов." }
        require(description.isNotBlank()) { "Описание продукта не может быть пустым или состоять только из пробелов." }
        require(price.value > 0) { "Цена продукта должна быть положительным числом." }
    }
    /**
     * Эти инварианты гарантируют, что имя и описание продукта не могут быть пустыми или состоять только из пробелов, а цена должна быть положительным числом.
     */
}

class ProductRepository {
    fun getProductById(productId: String): Product {
        // получение продукта из базы данных по ID
        return Product("1", "Example Product", "Description", Price(29.99))
    }
}

class ProductFactory {
    fun createProduct(id: String, name: String, description: String, price: Price): Product {
        return Product(id, name, description, price)
    }
}