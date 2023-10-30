package domain

data class DeliveryAddress(val street: String, val city: String, val postalCode: String)

data class Order(val id: String, val products: List<Product>, val deliveryAddress: DeliveryAddress){
    init {
        require(products.isNotEmpty()) { "Заказ должен содержать хотя бы один продукт." }
    }
}

class OrderRepository {
    fun save(order: Order) {
        // сохранение заказа в базе данных
    }
}

class OrderFactory {
    fun createOrder(id: String, products: List<Product>, deliveryAddress: DeliveryAddress): Order {
        return Order(id, products, deliveryAddress)
    }
}

class DeliveryCostCalculator {
    fun calculateCost(order: Order): Double {
        // рассчет стоимости доставки на основе адреса и продуктов в заказе
        return 0.0
    }
}
