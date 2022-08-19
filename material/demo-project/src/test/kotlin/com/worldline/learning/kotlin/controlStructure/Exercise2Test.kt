package com.worldline.learning.kotlin.controlStructure

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class Exercise2Test {
    @Before
    fun init(){
    }

    @Test
    fun testStrenghVsPikachu(){
        val pokemon1 = Pokemon("Pikachu",2,"Electrik")
        val pokemon2 = Pokemon("Squirtle",5,"Water")
        val pokemon3 = Pokemon("Geodude ",3,"Rock")
        assertEquals("Neutral !", strenghVsPikachu(pokemon1))
        assertEquals("Super effective !", strenghVsPikachu(pokemon2))
        assertEquals("Not very effective !", strenghVsPikachu(pokemon3))
    }

    @Test
    fun testCountPikachus(){
        val myBag = listOf(
            Pokemon("Pikachu",1,"Electrik"),Pokemon("Pidgey",1,"Flying"),Pokemon("Pidgey",1,"Flying"),Pokemon("Pikachu",1,"Electrik"),
            Pokemon("Pikachu",1,"Electrik"),Pokemon("Pidgey",1,"Flying"),Pokemon("Pidgey",1,"Flying"))
        assertEquals(3, countPikachus(myBag))
    }

    @Test
    fun testSayPika(){
        assertEquals("Pika", sayPika(1))
        assertEquals("PikaPika", sayPika(2))
        assertEquals("PikaPikaPikaPikaPika", sayPika(5))
    }
}
