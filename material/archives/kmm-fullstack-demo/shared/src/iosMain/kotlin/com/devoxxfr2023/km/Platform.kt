package com.devoxxfr2023.km

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

@Composable
internal actual fun getMyImage( imageName:String): Painter {
    TODO("Not yet implemented")
}