import com.katee.Main.Cmd

class CmdService {
    /*Внутри функции Parse проверяю указан ли параментр в качестве аргумента или нет
    Если аргумент равен 4 параметру будем получать нужные параметры без вывода справки
    Иначе параметры пустые и выводится справка*/
    fun Parse(args: Array <String>): Cmd {
        val commands = when (args.size) {
            4 -> Cmd(login = args.get(1), pass = args.get(3), h = false)
            else Cmd(login = "", pass = "", h = true)
        }
        return commands
    }
    // Внутри функции ReferenceH вывод сообщения
    fun ReferenceH() {
        println("Справка")
    }
}
