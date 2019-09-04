package com.worldline.learning.kotlin.controlFlow

import org.junit.Test
import kotlin.test.assertNotEquals


class ControlFlowTest {

    @Test
    fun testTransform() {

        assertNotEquals(transform("hello"), "hEllO")
        assertNotEquals(transform("worldline"), "wOrldlIne")
    }
}