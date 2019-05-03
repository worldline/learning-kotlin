package com.worldline.learning.kotlin.controlStructure

data class Pokemon(var name:String, var level:Int, val type:String)


/**
 * TODO
 * If the given pokemon is either Water or Flight, returns "Super effective !"
 * If it's Rock type, returns "Not very effective !"
 * Otherwise returns "Neutral !"
 * ...
 */
fun strenghVsPikachu(pokemon:Pokemon) =
        when (pokemon.type){
            "Water","Flying" -> "Super effective !"
            "Rock" -> "Not very effective !"
            else -> "Neutral !"
        }

fun countPikachus(list : List<Pokemon>):Int{
    var count = 0
    for (pokemon in list){
        if (pokemon.name == "Pikachu") count++
    }
    return count
}

fun sayPika(times:Int):String{
    val build = StringBuilder("")
    for(i in 1..times){
        build.append("Pika")
    }
    return build.toString()
}
