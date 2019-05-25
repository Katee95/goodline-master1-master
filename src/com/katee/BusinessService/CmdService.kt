package com.katee.businessService

import com.katee.main.Cmd
class CmdService {
    /*Внутри функции Parse проверяю указан ли параментр в качестве аргумента или нет
   Если аргумент равен 4 параметру будем получать нужные параметры без вывода справки
   Иначе параметры пустые и выводится справка*/
    fun parse(args: Array <String>): Cmd {
        val result = when (args.size) {
            4 -> Cmd(login = args[1], pass = args[3], h = false)
            else -> Cmd(login = "", pass = "", h = true)
        }
        println("login:${result.login}")
        println("pass:${result.pass}")
        return result
    }
    // Внутри функции ReferenceH вывод сообщения
    fun referenceH() {
        println(message = "Справка")
    }
}