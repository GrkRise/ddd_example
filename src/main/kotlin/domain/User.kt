package domain

data class EmailAddress(val value: String)

data class User(val id: String, val email: EmailAddress, val name: String, val password: String){
    init {
        require(email.value.isNotBlank()) { "Адрес электронной почты не может быть пустым или состоять только из пробелов." }
        require(name.isNotBlank()) { "Имя пользователя не может быть пустым или состоять только из пробелов." }
        require(password.length >= 6) { "Пароль должен содержать не менее 6 символов." }
    }
    /**
     * Эти инварианты гарантируют, что адрес электронной почты и имя пользователя не могут быть пустыми или состоять только из пробелов, а пароль должен содержать не менее 6 символов.
     */
}

class UserService {
    fun authenticate(email: EmailAddress, password: String): Boolean {
        // аутентификация пользователя
        return true
    }
}

class UserRepository {
    fun getUserById(userId: String): User {
        // получение пользователя из базы данных по ID
        return User("1", EmailAddress("example@example.com"), "John Doe", "password123")
    }
}