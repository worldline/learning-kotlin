import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator


@Composable()
internal fun scoreScreen(navigator: Navigator, score: String){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
            backgroundColor = Color.Green

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            fontSize = 15.sp,
                            text = "score",
                        )
                        Text(
                            fontSize = 30.sp,
                            text = score,
                        )
                        Button(
                            modifier = Modifier.padding(all = 20.dp),
                            onClick = {
                                navigator.navigate(route = "/quiz")
                            }
                        ) {
                            Icon(Icons.Filled.Refresh, contentDescription = "Localized description")
                            Text(text = "Retake the Quiz",)

                        }
                    }
            }
        }
    }
}