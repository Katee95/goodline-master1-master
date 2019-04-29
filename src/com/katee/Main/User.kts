class User (val login: String, val pass: String, val salt: String) {

    var userfoo = User("foo@example.com", "123456")
    var userbar = User("bar.baz@gmail.com", "qwerty")
}
    //Создаю коллекцию юзер и заполняю ее пользователями
    val user = listOf(
        User(userfoo, userbar)
)