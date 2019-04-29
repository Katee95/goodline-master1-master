import java.security.MessageDigest
import com.katee.Main.User


class UserService {
    /*Передаю логин и список List<User>.
    Внутри функции UserByLogin перебираю коллекцию и сравниваю каждую запись с логином,
    чтобы найти нужную из коллекции*/
    fun UserByLogin(val login:String, users: List<User>): User? {
        val find = users.find { it.login == login }
        return find
    }
    //Внутри функции ValidatePass проверяю есть ли получавшийся пароль в базе данных
    fun ValidatePass(val user: User, val pass: String): Boolean {
        val hashCode = hash(s = pass + user.salt)
        val comparison = user.pass == hashCode
        return comparison
}
    //Внутри функции Generation генерации Sha-256
    private fun generation(): String {
        val byte = this.toString().toByteArray()
        val message = MessageDigest.getInstance("SHA-256")
        val digest = message.digest(byte)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}