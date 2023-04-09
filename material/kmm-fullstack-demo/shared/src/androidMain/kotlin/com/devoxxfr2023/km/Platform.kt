package com.devoxxfr2023.km

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import java.lang.reflect.Field

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
internal actual fun getMyImage( imageName:String): Painter {
    val c = R.drawable::class.java
    val field: Field = c.getField(imageName)
    val id: Int = field.getInt(null)
    return painterResource(id)

}