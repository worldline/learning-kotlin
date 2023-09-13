package com.worldline.learning.kotlin.dataclass

import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DataClassTest {

    @Test fun testHashCode() {
        val sacha1 = PokemonTrainer("sacha", 2)
        val sacha2 = PokemonTrainer("sacha", 2)
        assertEquals(sacha1.hashCode(), sacha2.hashCode())

        sacha2.numberOfBadges = 5
        assertNotEquals(sacha1.hashCode(), sacha2.hashCode())
    }

    @Test fun testEquals() {
        val sacha1 = PokemonTrainer("sacha", 2)
        val sacha2 = PokemonTrainer("sacha", 2)
        assertEquals(sacha1, sacha2)

        assertTrue(sacha1 == sacha2)
    }

    // EqualsVerifier is a library that checks the conformity of the equals and hashcode implementations
    // more details: https://jqno.nl/equalsverifier/
    @Test fun testWithEqualsVerifier(){
        EqualsVerifier.forClass(PokemonTrainer::class.java).suppress(Warning.NONFINAL_FIELDS).verify()
    }
}