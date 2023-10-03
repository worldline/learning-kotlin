import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    TopAppBar(title = { Text("Hello Compose") }, backgroundColor = MaterialTheme.colors.primary)
                }
            }
        ) {
            var greetingText by remember { mutableStateOf("Show Image") }
            var showImage by remember { mutableStateOf(false) }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("You are running on ${getPlatformName()}")
                Button(onClick = {
                    greetingText = if (showImage) "Show image" else "Show numbers"
                    showImage = !showImage
                }) {
                    Text(greetingText)
                }
                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
                AnimatedVisibility(!showImage) {
                    RandomNumberList()
                }
            }
        }
    }
}

@Composable
fun RandomNumberList() {
    // Generate a list of random numbers
    val myRandomValues = List(5) { Random.nextInt(0, 30) }
    // LazyColumn is a vertically scrolling list that renders items on demand
    LazyColumn {
        items(myRandomValues.size) {
            Text(text = "$it")
        }
    }
}

expect fun getPlatformName(): String