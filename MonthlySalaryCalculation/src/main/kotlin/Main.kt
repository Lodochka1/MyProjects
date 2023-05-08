fun main() {
    val data = mapOf(
        "Январь" to listOf(100, 100, 100, 100),
        "Февраль" to listOf(200, 200, -190, 200),
        "Март" to listOf(300, 180, 300, 100),
        "Апрель" to listOf(250, -250, 100, 300),
        "Май" to listOf(200, 100, 400, 300),
        "Июнь" to listOf(200, 100, 300, 300)
    )
    println(printInfo(data))
}

fun printInfo(data: Map<String, List<Int>>) {
    val dataValid = data.filterNot { it.value.any{it < 0} }
    val weekAverage = dataValid.flatMap { it.value }.average()
    println("Средняя выручка: $weekAverage")

    val listOfSum = dataValid.map { it.value.sum() }
    val monthMaxIncome = listOfSum.max()
    val monthMinIncome = listOfSum.min()
    val monthAverage = listOfSum.average()
    println("Среlняя выручка за месяц: $monthAverage")

    val maxMonth = dataValid.filter { it.value.sum() == monthMaxIncome }.keys
    val minMonth = dataValid.filter { it.value.sum() == monthMinIncome }.keys


    println("Максимальный доход: $monthMaxIncome")
    print("Максимальный доход был в этом месяце:")
    for (month in maxMonth) {
        print(" $month")
    }

    println("\nМинимальный доход: $monthMinIncome")
    print("Минимальный доход был в этом месяце: ")
    for (month in minMonth) {
        println(" r$month")
    }

    val invalidData = data.filter { it.value.any{it < 0} }
    val errorMonth = invalidData.keys
    println("Ошибки были в этих мясецах: $errorMonth")
}