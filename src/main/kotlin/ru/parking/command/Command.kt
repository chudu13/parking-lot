package ru.parking.command

interface Command {
    fun isExist(passCommand: String): Boolean
    fun command(passCommand: String, text: String)
}