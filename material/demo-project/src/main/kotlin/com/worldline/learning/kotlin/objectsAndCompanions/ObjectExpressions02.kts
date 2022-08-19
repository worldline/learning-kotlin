package com.worldline.learning.kotlin.objectsAndCompanions

val smallBottle = ObjectExpressions01.Drink(100)

// Kotlin also allows to create anonymous objects without supertypes
fun mix(drinkToMix: ObjectExpressions01.Drink){
    val mixture = object {
        val drink = drinkToMix
        val ingredient = "Salt"
    }
    // TODO try to print the result of mixture.ingredient + mixture.drinkToMix
    println()
}
mix(smallBottle)

// Let's try to return an adhoc anonymous object
fun prepareNewMix(drinkToMix: ObjectExpressions01.Drink) = object {
    val drink = drinkToMix
    val ingredient = "Salt"
}
val newMix = prepareNewMix(smallBottle)
// TODO type to print the components of newMix. Is it possible to access the contents of the anonymous object outside the local scope ?

// TODO please read the following code
//  Try to instantiate a drink mixer and call its 'mix' function
//  what happens if we remove the 'private' qualifier of prepare ?
class DrinkMixer {
    private fun perapre(drinkToMix: ObjectExpressions01.Drink) = object {
        val drink = drinkToMix
        val ingredient = "Salt"
    }

    fun mix(){
        val preparation = perapre(ObjectExpressions01.Drink(100))
        println("${preparation.drink} and ${preparation.ingredient}")
    }
}


