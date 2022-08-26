package com.worldline.training.common

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun getLogoPainter() = painterResource(R.drawable.logo)