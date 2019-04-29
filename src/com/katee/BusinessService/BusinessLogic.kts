import com.katee.Main.User
import com.katee.Main.Cmd


class BisinessLogic {
    //Функция которая работает с Cmd и с коллекцией
    fun authentication(cmd: Cmd, users: List<User>): Int {
        if (commands.h) {
            CmdService().h()
            System.exit(1)
        }
        //Написать условие если Login указан неверно
        val patternEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!login.matches(Regex(patternEmail))
                System.exit(2)

        /*Условие:
        если находим пользователя с верным логином и с верным паролем то успех
        если не находит логин то выведет:(3)- не нашли пароль
        если не найдет пароль то выведет(4)- неверной пароль*/
        val user = UserService().UserByLogin(users, commands.login)
        if (user != null) {
            if (UserService().ValidatePass(commands.pass, user))
                System.exit(0)
            else System.exit(3)
        } else System.exit(4)
    }
}