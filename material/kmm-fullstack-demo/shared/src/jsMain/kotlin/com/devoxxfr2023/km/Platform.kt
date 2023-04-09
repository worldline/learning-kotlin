package com.devoxxfr2023.km

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter

class WebPlatform : Platform {
    override val name: String = "Desktop"
}

actual fun getPlatform(): Platform = WebPlatform()


@Composable
internal actual fun getMyImage(imageName: String): Painter {
    return ColorPainter(Color.Cyan)
}