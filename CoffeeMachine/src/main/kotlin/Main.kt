
var waterStav = 400 // ml
var milkStav = 540  //540 ml
var cofeStav = 120  // g
var costStav = 550  // $
var cups = 9        // ks

//For espresso
val espressoWater = 250
val espressoBeans = 16
val espressoCost = 4
val cup = 1

//For latte
val latteWater = 350
val latteMilk = 75
val latteBeans = 20
val latteCost = 7

//For cappuccino
val cappuccinoWater = 200
val cappuccinoMilk = 100
val cappuccinoBeans = 12
val cappuccinoCost = 6

fun fill() {
    println("Write how many ml of water you want to add:")
    var waterDopln = readln().toInt()
    waterStav += waterDopln

    println("Write how many ml of milk you want to add:")
    var milkDopln = readln().toInt()
    milkStav += milkDopln

    println("Write how many grams of coffee beans you want to add:")
    var cofeDopln = readln().toInt()
    cofeStav += cofeDopln

    println("Write how many disposable cups you want to add:")
    var cupDopln = readln().toInt()
    cups += cupDopln

}

fun remaining() {
    println("The coffee machine has:")
    println("$waterStav ml of water")
    println("$milkStav ml of milk")
    println("$cofeStav g of coffee beans")
    println("$cups disposable cups")
    println("\$$costStav of money")
    println()
}

fun buy(coffeNumber: String) {
    if (coffeNumber == "1" && waterStav >= espressoWater && cofeStav >= espressoBeans && costStav >= espressoCost) {
        waterStav -= 250 //ml
        cofeStav -= 16  //g
        costStav += 4 //$
        cups -= 1
        println("I have enough resources, making you a coffee!")
    } else if (coffeNumber == "2" && waterStav >= latteWater && milkStav >= latteMilk && cofeStav >= latteBeans && costStav >= latteCost) {
        waterStav -= 350 //ml
        milkStav -= 75 //ml
        cofeStav -= 20 //g
        costStav += 7 //$
        cups -= 1
        println("I have enough resources, making you a coffee!")
    } else if (coffeNumber == "3" && waterStav >= cappuccinoWater && milkStav >= cappuccinoMilk && cofeStav >= cappuccinoBeans && costStav >= cappuccinoCost) {
        waterStav -= 200 //ml
        milkStav -= 100 //ml
        cofeStav -= 12 //g
        costStav += 6 //$
        cups -= 1
        println("I have enough resources, making you a coffee!")
    }


    //нужно исправить ошибку с back
    else if (coffeNumber == "back") {
        return
    } else {
        when {
            //код можно укаратить с помощью &&
            waterStav < espressoWater -> println("Sorry, not enough water!")
            cofeStav < espressoBeans -> println("Sorry, not enough coffee beans!")
            costStav < espressoCost -> println("Sorry, not enough money!")
            cups == 0 -> println("Sorry, not enough cups!")

            waterStav < latteWater -> println("Sorry, not enough water!")
            milkStav < latteMilk -> println("Sorry, not enough milk!")
            cofeStav < latteBeans -> println("Sorry, not enough coffee beans!")
            costStav < latteCost -> println("Sorry, not enough money!")
            cups == 0 -> println("Sorry, not enough cups!")

            waterStav < cappuccinoWater -> println("Sorry, not enough water!")
            milkStav < cappuccinoMilk -> println("Sorry, not enough milk!")
            cofeStav < cappuccinoBeans -> println("Sorry, not enough coffee beans!")
            costStav < cappuccinoCost -> println("Sorry, not enough money!")
            cups == 0 -> println("Sorry, not enough cups!")
        }
    }
}

fun take() {
    println("I gave you \$$costStav")
    costStav = 0 // -= costStav
}

fun main() {
    while (1 > 0) {
        println()
        println("Write action (buy, fill, take, remaining, exit): ")
        var action = readln()
        println()
        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                val coffeeNumber = readln()
                buy(coffeeNumber)
            }

            "fill" -> fill()
            "remaining" -> remaining()
            "take" -> take()
            "exit" -> break
        }
    }
}
