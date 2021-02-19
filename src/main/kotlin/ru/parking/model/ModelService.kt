package ru.parking.model

interface ModelService {
    fun park(regNumber: String, color: String): String
    fun leave(leaveSpot: Int): String
    fun create(num: Int)
}