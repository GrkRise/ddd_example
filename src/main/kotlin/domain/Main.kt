package domain

fun main() {
    // Пример использования агрегатов, репозиториев и сервисов
    val productRepository = ProductRepository()
    val orderRepository = OrderRepository()
    val userRepository = UserRepository()
    val deliveryCostCalculator = DeliveryCostCalculator()

    // Создание продукта
    val product = productRepository.getProductById("1")

    // Создание пользователя
    val user = userRepository.getUserById("1")

    // Создание заказа
    val deliveryAddress = DeliveryAddress("123 Main St", "City", "12345")
    val orderService = OrderService(orderRepository, deliveryCostCalculator)
    val order = orderService.createOrder(listOf(product), deliveryAddress)

    // Аутентификация пользователя
    val email = EmailAddress("example@example.com")
    val password = "password123"
    val userService = UserService()
    val isAuthenticated = userService.authenticate(email, password)

    // Вывод результатов
    println("Продукт: ${product.name}, Цена: ${product.price.value}")
    println("Пользователь: ${user.name}, Email: ${user.email.value}")
    println("Создан заказ с ID: ${order.id}, Стоимость доставки: ${deliveryCostCalculator.calculateCost(order)}")
    println("Пользователь аутентифицирован: $isAuthenticated")
}

/*
В этом примере Main-класс создает объекты продукта и пользователя, затем создает заказ с использованием OrderService и проверяет аутентификацию пользователя с использованием UserService.
 */