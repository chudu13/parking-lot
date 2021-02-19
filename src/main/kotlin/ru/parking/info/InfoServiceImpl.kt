package ru.parking.info

import ru.parking.model.ModelServiceImpl

class InfoServiceImpl : InfoService {
    private var model: HashMap<Int, ModelServiceImpl.Car?>

    constructor(model: HashMap<Int, ModelServiceImpl.Car?>) {
        this.model = model
    }
    constructor(): this(HashMap<Int, ModelServiceImpl.Car?>())
    //получаем список припаркованных авто
    override fun status() {
        when(model.values.toList().size) {
            0 -> println("Parking lot is empty.")
            else -> {
                for (i in model) {
                    if (i.value != null)
                        println("${i.key} ${i.value!!.regNumber} ${i.value!!.color}")
                }
            }
        }
    }
    //выводим номера авто по заданному цвету
    override fun regByColor(color: String) {
        if (containColor(color)) {
            print(model
                    .filter { it.value?.color?.toLowerCase() == color.toLowerCase() }
                    .values.toSet()
                    .joinToString(postfix = "\n") { it!!.regNumber })
        } else println("No cars with color $color were found.")
    }
    //выводим места парковки по цвету авто
    override fun spotByColor(color: String) {
        if (containColor(color)) {
            print(model.filter {it.value?.color?.toLowerCase() == color.toLowerCase()}
                    .keys.joinToString(postfix = "\n") { it.toString() })
        } else println("No cars with color $color were found.")
    }
    //получаем место парковки по номеру авто
    override fun spotByReg(regNumber: String): Int {
        return try {
            model.filter {it.value?.regNumber == regNumber}.keys.first()
        } catch (e: NoSuchElementException) {
            0
        }
    }

    private fun containColor(color: String) = model.values.map { it?.color?.toLowerCase() }.contains(color.toLowerCase())
}