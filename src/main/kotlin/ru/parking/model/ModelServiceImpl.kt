package ru.parking.model

class ModelServiceImpl: ModelService {

    data class Car(val regNumber: String, val color: String)
    var lots: HashMap<Int, Car?> = HashMap()
    //парковка авто в свободное место
    override fun park(regNumber: String, color: String): String {
        val index = searchEmptySpot()
        return if (index > 0 ) {
            lots[index] = Car(regNumber, color)
            "$color car parked in spot $index."
        } else "Sorry, the parking lot is full."
    }
    //убираем авто с парковки  по номеру парковочного места
    override fun leave(leaveSpot: Int): String {
        return if (lots[leaveSpot] == null) "There is no car in spot $leaveSpot."
        else {
            lots[leaveSpot] = null
            "Spot $leaveSpot is free."
        }
    }

    //создаем парковку на определенное количество мест, и заполняем пустыми значениями
    override fun create(num: Int) {
        lots = HashMap()
        for (i in 1 .. num) {
            lots[i] = null
        }
        println("Created a parking lot with $num spots.")
    }
    //медот для поска свободного места на парковке
    private fun searchEmptySpot(): Int {
        return try {
           lots.filter { it.value == null }.keys.first()
        } catch (ex: NoSuchElementException) {
            0
        }
    }
}