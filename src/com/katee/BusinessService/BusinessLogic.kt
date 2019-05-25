package com.katee.businessService

import com.katee.main.Cmd

class BusinessLogic(
    private val cmdService: CmdService,
    private val userService: UserService
) {
    //Функция которая работает с Cmd и с коллекцией
    fun authentication(commands: Cmd): Int {
        if (commands.h) {
            cmdService.referenceH()
            return 1
        }
        //Написать условие если Login указан неверно
        val patternEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        if(!commands.login.matches(Regex(pattern = patternEmail)))
            return 2

        /*Условие:
        если находим пользователя с верным логином и с верным паролем то успех
        если не находит логин то выведет:(4)- не нашли пароль
        если не найдет пароль то выведет(3)- неверной пароль*/
        val us = userService.userByLogin(commands.login)
        return when {
            us == null -> 3
            userService.validatePass(us, commands.pass) -> 0
            else -> 4
        }


    }
}
