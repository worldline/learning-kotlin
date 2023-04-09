package com.devoxxfr2023.km

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable()
internal fun WelcomeScreen(navigator: Navigator) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (getPlatform().name != "iOS")
                    Image(
                        painter = getMyImage("logo"),
                        contentDescription = "Logo of the quiz app", // decorative
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.width(150.dp).padding(20.dp)
                    )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Quiz",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(all = 10.dp)
                    )
                    Text(
                        modifier = Modifier.padding(all = 10.dp),
                        text = "A simple Quiz to discovers KMP, KMM and compose.",
                    )
                    Button(
                        modifier = Modifier.padding(all = 10.dp),
                        onClick = { navigator.navigate(route = "/quiz") }

                    ) {
                        Text("Start the Quiz")
                    }
                }
            }
        }
    }
}
