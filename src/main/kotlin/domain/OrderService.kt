package domain

import java.util.*

class OrderService(private val orderRepository: OrderRepository, private val deliveryCostCalculator: DeliveryCostCalculator) {
    fun createOrder(products: List<Product>, deliveryAddress: DeliveryAddress): Order {
        val orderFactory = OrderFactory()
        val order = orderFactory.createOrder(UUID.randomUUID().toString(), products, deliveryAddress)
        val deliveryCost = deliveryCostCalculator.calculateCost(order)
        // выполнить какие-то дополнительные операции, например, подсчет общей стоимости заказа
        orderRepository.save(order)
        return order
    }
}

/**В этом примере OrderService использует OrderRepository и DeliveryCostCalculator для создания заказа и рассчета стоимости доставки.
 * Аналогично, вы можете создать сервисы для других агрегатов и организовать их взаимодействие в зависимости от бизнес-логики вашего приложения.
 */
