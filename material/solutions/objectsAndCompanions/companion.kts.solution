package com.worldline.learning.kotlin.objectsAndCompanions

// TODO using the object declaration synctax, create a singleton DrinkDispenser that has these methods: putDrink(Drink), List<Drink> allAvailableDrinks() and pickLastDrink():Drink
//  Syntax: object SingletonName { ... } }

// TODO uncomment to test you code
//DrinkDispenser.putDrink(ObjectExpressions01.Drink(100))
//DrinkDispenser.putDrink(ObjectExpressions01.Drink(50))
//DrinkDispenser.putDrink(ObjectExpressions01.Drink(70))
//println(DrinkDispenser.allAvailableDrinks().size) // 3
//DrinkDispenser.putDrink(ObjectExpressions01.pickLastDrink())
//println(DrinkDispenser.allAvailableDrinks().size) // 2

// TODO create a class named DrinkMaker. We want to have a static method "createDrink(): ObjectExpressions01.Drink" that creates a new Drink.
//   An object declaration inside a class can be marked as companion
//   Syntax:
/*
class ClassName {
    companion object (optionnal name) {
        ...
    }
}
*/
class DrinkMaker {
    companion object: Counter{
        private var nbCreated = 0
        override var count: Int
            get() = nbCreated
            set(value) { nbCreated = value}

        fun createDrink() : ObjectExpressions01.Drink{
            count += 1
            return ObjectExpressions01.Drink(100)
        }
    }
}

// TODO uncomment to test
//val drink = DrinkMaker.createDrink()
//val drink2 = DrinkMaker.Companion.createDrink()

// TODO what is the type of companionObject
//val companionObject = DrinkMaker
//companionObject.createDrink()

// TODO make the earlier companion object implement the following Counter interface and count the number of created Drinks
interface Counter{
    var count: Int
}
// TODO uncomment to test
//println(DrinkMaker.count) // 3