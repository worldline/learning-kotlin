package com.worldline.training.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
actual fun getLogoPainter() = painterResource("logo.png")