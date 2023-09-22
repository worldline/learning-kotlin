package com.devoxxfr2023.km

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

class DesktopPlatform: Platform {
    override val name: String = "Desktop"
}
actual fun getPlatform(): Platform = DesktopPlatform()


@Composable
internal actual fun getMyImage(imageName: String ) = painterResource("images/$imageName.png")