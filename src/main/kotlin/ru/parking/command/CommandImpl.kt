package ru.parking.command

import ru.parking.info.InfoServiceImpl
import ru.parking.model.ModelServiceImpl

class CommandImpl: Command {
    //внедряем зависимость(композиция)
    private val modelServiceImpl = ModelServiceImpl()
    private val listCommand: List<String> = listOf(
            "park", "create", "reg_by_color",
            "leave", "spot_by_color", "spot_by_reg")
    //проверяем была ли создана парковка с помощью команды create
    private var isInvoke = false

    //проверяем существет ли введенная команда к коллекции listCommand
    override fun isExist(passCommand: String): Boolean = listCommand.contains(passCommand)

    //обработка команды из списка котороя прошла проверку isExist, передача управления другому классу
    override fun command(passCommand: String, text: String) {
        var command = passCommand
        var tempText = text

        while ("exit" != command) {
            when (command) {
                "park" -> {
                    if (isInvoke)
                    println(modelServiceImpl.park(getReg(tempText), tempText.split(" ").last()))
                }
                "leave" -> {
                    if (isInvoke)
                    println(modelServiceImpl.leave(getNum(tempText)))
                }
                "status" -> {
                    if (isInvoke) {
                        connectModelInfo()
                        infoServiceImpl.status()
                    }
                }
                "create" -> {
                    isInvoke = true
                    modelServiceImpl.create(getNum(tempText))
                }
                "reg_by_color" -> {
                    if (isInvoke) {
                        connectModelInfo()
                        infoServiceImpl.regByColor(getColor(tempText))
                    }
                }
                "spot_by_color" -> {
                    if (isInvoke) {
                        connectModelInfo()
                        infoServiceImpl.spotByColor(getColor(tempText))
                    }
                }
                "spot_by_reg" -> {
                    if (isInvoke) {
                        connectModelInfo()
                        val temp = infoServiceImpl.spotByReg(getReg(tempText))
                        if (temp > 0) println(temp)
                        else println("No cars with registration number ${getReg(tempText)} were found.")
                    }
                }
            }

            if (!isInvoke) error()

            tempText = readLine()!!
            command = tempText.split(" ").first()
        }
    }

    //получаем список существующих команды из списка listCommand
    fun getCommand(): String {
        return toString()
    }

    override fun toString(): String {
        var text = ""
        for (e in listCommand) {
            text += "$e\n"
        }
        return text
    }

    private fun getColor(msg: String) = msg.split(" ").component2()
    private fun getNum(msg: String) = msg.split(" ").component2().toInt()
    private fun getReg(msg: String) = msg.split(" ").component2()
    //выводим текст с ошибкой если не ввели команду create
    private fun error() {
        println("Sorry, a parking lot has not been created.")
    }

    //агрегируем обновленную коллекцию
    private fun connectModelInfo() {
        infoServiceImpl =
            InfoServiceImpl(modelServiceImpl.lots)
    }

    companion object {
        private var infoServiceImpl: InfoServiceImpl =
            InfoServiceImpl()
    }
}
