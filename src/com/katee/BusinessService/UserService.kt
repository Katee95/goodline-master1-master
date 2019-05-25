package com.katee.businessService

import com.katee.main.User
import java.security.MessageDigest

class UserService(private val usersDb: List<User>) {
    /**
     * Передаю логин и список List<User>.
     * Внутри функции userByLogin перебираю коллекцию и сравниваю каждую запись с логином,
     * чтобы найти нужную из коллекции
     */
    fun userByLogin(login: String): User? = usersDb.find { it.login == login }

    /**
     * Внутри функции validatePass проверяю есть ли получавшийся пароль в базе данных
     * TODO написать правильно функ
     */
    fun validatePass(user: User, pass: String): Boolean = user.hash == generitionPass(pass, user.salt)

    companion object {
        fun generitionPass(pass: String, salt: String) = hash(hash(pass) + salt)

        /**
         * Внутри функции hash генерации Sha-256
         */
        private fun hash(text: String): String {
            val byte = text.toByteArray()
            val message = MessageDigest.getInstance("SHA-256")
            val digest = message.digest(byte)
            return digest.fold("") { str, it -> str + "%02x".format(it) }
        }
    }
}