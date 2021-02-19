@file:JvmName("Main")

package ru.parking

import ru.parking.command.CommandImpl

val commandImpl = CommandImpl()
fun main() {
    println("Enter one from next commands:\n${commandImpl.getCommand()}")
    try {
        val text: String? = readLine()
        val passCommand: String? = text?.split(" ")?.first()?.toLowerCase()

        if (passCommand?.let { it1 -> commandImpl.isExist(it1) }!!) {
            text.let { it1 ->
                commandImpl.command(passCommand, it1)
            }
        }
    } catch (ex: KotlinNullPointerException) {
        println("You entered an invalid command!")
    }
}