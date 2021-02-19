package ru.parking.info

interface InfoService {
    fun status()
    fun regByColor(color: String)
    fun spotByColor(color: String)
    fun spotByReg(regNumber: String): Int
}