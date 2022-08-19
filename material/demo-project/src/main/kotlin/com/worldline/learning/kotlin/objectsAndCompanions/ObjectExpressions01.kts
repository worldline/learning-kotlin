package com.worldline.learning.kotlin.objectsAndCompanions

// Objects in kotlin https://kotlinlang.org/docs/reference/object-declarations.html
open class Drink(var volume: Int){
    open fun consume(consumedVolume: Int){
        this.volume -= consumedVolume
    }
}

// Creating an instance of Drink
val smallBottle = Drink(100)
// TODO create a bigBottle with a volume of 500

// Kotlin allows to quickly create an anonymous object that implements and existing class and/or interfaces
val smallCarbonatedDrinkBottle = object: Drink(100) {
    override fun consume(consumedVolume: Int) {
        super.consume(consumedVolume)
        println("PSHHHHHH")
    }
}
smallCarbonatedDrinkBottle.consume(20)

// TODO created an anonymous object smallCarbonatedRedDrinkBottle that both a Drink and colored
interface Colored{
    val color:String
}
// TODO Can kotlin infer the type of smallCarbonatedRedDrinkBottle ?


// TODO make this code print "Red"
// println(smallCarbonatedRedDrinkBottle.color)

// anonymous objects have access to variables in the enclosing scope
fun createDrinkAndCount(): Drink{
    var nbConsumption = 0
    return object : Drink(100){
        override fun consume(consumedVolume: Int) {
            super.consume(consumedVolume)
            nbConsumption += 1
            println(nbConsumption)
        }
    }
}

// TODO what is printed after calling the following code ?
val drinkThatCounts = createDrinkAndCount()
drinkThatCounts.consume(10)
drinkThatCounts.consume(20)

// TODO Try to guess what is printed if we get another drink from 'createDrinkAndCount()' and call consume ?