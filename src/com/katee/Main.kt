package com.katee

import com.katee.BusinessSevice.BuisnessLogic
import com.katee.BusinessSevice.CmdService
import com.katee.Main.Cmd
import com.katee.Main.User

fun main(args: Array<String>) {
    val userfoo = User("foo@example.com")
    val userbar = User("bar.baz@gmail.com")

    val commands: Cmd = CmdService().parse(args)
    BuisnessLogic().authenticate(commands, users)
}