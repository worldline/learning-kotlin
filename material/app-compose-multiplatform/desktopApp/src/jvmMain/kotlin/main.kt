import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(title = "Hello Compose", onCloseRequest = ::exitApplication) {
        MainView()
    }
}