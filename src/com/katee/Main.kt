package com.katee

import com.katee.businessService.BusinessLogic
import com.katee.businessService.CmdService
import com.katee.businessService.UserService
import com.katee.main.Cmd
import com.katee.main.User
import java.util.*

fun main(args: Array<String>) {

    val users = listOf(
        User(
            "foo@example.com",
            UserService.generitionPass(pass = "qwerty", salt = "cFudk"),
            "cFudk"
        ),
        User(
            "bar.baz@gmail.com",
            UserService.generitionPass(pass = "123456", salt = "cFudk"),
            "cFudk"
        )
    )
    println(listOf(*args))

    val userService = UserService(users)
    val cmdService = CmdService()
    val commands: Cmd = cmdService.parse(args)
    val businessLogic = BusinessLogic(cmdService, userService)

    val status = businessLogic.authentication(commands)
    System.exit(status)

}