package com.devoxxfr2023.km


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devoxxfr2023.km.network.data.Question
import moe.tlaster.precompose.navigation.Navigator

@Composable()
internal fun questionScreen(navigator: Navigator, questions: List<Question>) {

    var questionProgress by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.padding(60.dp)

        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {

                Text(

                    modifier = Modifier.padding(all = 10.dp),
                    text = questions[questionProgress].label,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                )
            }
        }


        Column(modifier = Modifier.selectableGroup()) {
            questions[questionProgress].answers.forEach { answer ->
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier.padding(end = 16.dp),
                        selected = (selectedAnswer == answer.id),
                        onClick = { selectedAnswer = answer.id },
                    )
                    Text(text = answer.label)
                }
            }
        }

        Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
            Button(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    if(selectedAnswer == questions[questionProgress].correctAnswerId) {
                        score++
                    }
                    if (questionProgress < questions.size - 1) {
                        questionProgress++
                        selectedAnswer = 1
                    }else{
                        navigator.navigate("/score/$score out of ${questions.size}")
                    }
                }
            ) {
                if(questionProgress < questions.size - 1) nextOrDoneButton(Icons.Filled.ArrowForward,"Next")
                else nextOrDoneButton(Icons.Filled.Done,"Done")
            }
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(20.dp), progress = questionProgress.div(questions.size.toFloat()).plus(1.div(questions.size.toFloat())))
        }
    }
}

@Composable
internal fun nextOrDoneButton(iv: ImageVector, label:String){
    Icon(
        iv,
        contentDescription = "Localized description",
        Modifier.padding(end = 15.dp)
    )
    Text(label)
}
