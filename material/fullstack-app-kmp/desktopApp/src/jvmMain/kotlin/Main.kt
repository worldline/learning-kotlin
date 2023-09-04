
import androidx.compose.ui.window.application
import com.devoxxfr2023.km.DesktopApp
import moe.tlaster.precompose.PreComposeWindow

fun main() = application { // kotlin application
        PreComposeWindow(onCloseRequest = ::exitApplication, title = "QuizzApp") {
                DesktopApp() // composable view shared
        }
}