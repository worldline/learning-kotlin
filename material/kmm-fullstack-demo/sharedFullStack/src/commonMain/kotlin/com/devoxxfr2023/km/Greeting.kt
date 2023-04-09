package com.devoxxfr2023.km

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }


}

@Composable
internal expect fun getMyImage( imageName:String): Painter