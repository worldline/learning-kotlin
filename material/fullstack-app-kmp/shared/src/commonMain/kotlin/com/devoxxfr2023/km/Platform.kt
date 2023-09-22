package com.devoxxfr2023.km

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform