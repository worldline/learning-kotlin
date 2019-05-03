package com.worldline.learning.kotlin

import org.junit.Test
import kotlin.test.assertEquals

class DestructuringTest {

    @Test
    fun testWeakestStrongest() {
        val pikachu = Pokemon(name = "Pikachu", experience = 150)
        val ratata = Pokemon(name = "Ratata", experience = 250)
        val roucool = Pokemon(name = "Roucool", experience = 100)
        val salameche = Pokemon(name = "Salameche", experience = 300)

        // TODO: this should work below
        val (weak, strong) = weakestAndStrongest(
            arrayOf(pikachu, ratata, roucool, salameche)
        )
        assertEquals(weak, roucool)
        assertEquals(strong, salameche)
    }

}
