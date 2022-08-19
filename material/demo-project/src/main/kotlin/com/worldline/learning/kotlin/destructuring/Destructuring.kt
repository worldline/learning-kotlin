package com.worldline.learning.kotlin.destructuring

data class Pokemon(
    val name: String,
    val experience: Int
)

fun main() {
    val pikachu = Pokemon(name = "Pikachu", experience = 50)
    val ratata = Pokemon(name = "Ratata", experience = 20)
    val roucool = Pokemon(name = "Roucool", experience = 25)

    // TODO: this should work below remove the comment and then fix the code
    //val (weak, strong) = weakestAndStrongest(arrayOf(pikachu, ratata, roucool))
    //println("My weakest pokemon is: $weak")
    //println("My strongest pokemon is: $strong")

}

fun weakestAndStrongest(pokemons: Array<Pokemon>) /* TODO */ {
    val min = pokemons.minBy { p -> p.experience } ?: pokemons.first()
    val max = pokemons.maxBy { p -> p.experience } ?: pokemons.first()
    return TODO("return a destructurable object")
}