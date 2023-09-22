package tech.worldline.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("DEPRECATION")
@Composable
internal fun WebApp() {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Hello")
                    })
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Text("Compose for Web Canvas works !")
            }

        }
    }
}

fun main() {
    onWasmReady {
        BrowserViewportWindow("Quiz made with Comopose Canvas Web") {
            WebApp()
            //WebApp()
//            ComposeCanvasWebApp()
        }
    }
}