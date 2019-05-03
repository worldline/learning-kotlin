package com.worldline.learning.kotlin.dataclass

// Data classes define the hashCode and equals methods
// TODO: read the test class DataClassTest and launch tests -> what happened ?
// TODO: Define the PokemonTrainer class as a data class and run the tests agais -> what happens
class PokemonTrainer(val name:String, var numberOfBadges:Int)

fun main(){
    val pierre = PokemonTrainer("Pierre", 1)
    // A data class allows destructring its components
    // TODO: retrive the name and numberOfBadges properties into constants and display them in the console
    // val (name, numberOfBadges) = pierre

    // Data classes can be cloned using the copy() function
    // TODO: copy the "pierre" object into another object and compare them using double equals '==' -> what is the result ?
    // TODO: modify the numberOfBadges of the original pierre object and compare the objects again -> what is the result ?


    // Data classes define a toString method
    // TODO: print the "pierre" object. How is this object displayed ?

    // data class and inheritance
    // TODO: define a class MasterPokemonTrainer that inherits from PokemonTrainer -> what happens ?
    // TODO: define a class Human that is the parent class of PokemonTrainer -> what happens ?
}