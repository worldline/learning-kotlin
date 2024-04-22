package com.worldline.formats

import org.http4k.core.Body
import org.http4k.format.KotlinxSerialization.array
import org.http4k.format.KotlinxSerialization.boolean
import org.http4k.format.KotlinxSerialization.json
import org.http4k.format.KotlinxSerialization.number
import org.http4k.format.KotlinxSerialization.obj
import org.http4k.format.KotlinxSerialization.string

val kotlinXMessageLens = Body.json().toLens()

val kotlinXMessage = obj(
    "thisIsAString" to string("stringValue"),
    "thisIsANumber" to number(12345),
    "thisIsAList" to array(listOf(boolean(true)))
)
