package com.example.quiz.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun BrandImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.quiz_logo),
        contentDescription = "quiz logo",
        modifier = modifier
            .padding(30.dp)
            .fillMaxWidth()
    )
}

@Composable
fun TitleText(titleText: String, modifier: Modifier = Modifier) {
    Text(
        text = titleText,
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(20.dp)
    )
}

@Composable
fun QuestionText(questionText: String, modifier: Modifier = Modifier) {
    Text(
        text = questionText,
        fontSize = 25.sp,
        modifier = modifier.padding(20.dp)
    )
}

@Composable
fun AnswerValidation(resultMessage: String, modifier: Modifier = Modifier) {
    Text(
        text = resultMessage,
        color = if (resultMessage == "Correct!") Color.Green else Color.Red,
        modifier = modifier.padding(20.dp)
    )
}

@Composable
fun AnswerField(answer: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        label = { Text(text = "Type your answer here") },
        value = answer,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

@Composable
fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(10.dp)
    ) {
        Text(
            text = "Submit",
            fontSize = 20.sp,
            modifier = modifier.padding(5.dp)
        )
    }
}

@Composable
fun NextButton(onNextScreen: () -> Unit, resultMessage: String, modifier: Modifier = Modifier) {
    Button(
        // onNextScreen is declared in App() in MainActivity.kt
        onClick = onNextScreen,
        enabled = resultMessage == "Correct!",
        modifier = modifier.padding(10.dp)
    ) {
        Text(
            text = "Next",
            fontSize = 20.sp,
            modifier = modifier.padding(5.dp)
        )
    }
}

//@Composable
//fun FinalResultsText(score: String) {
//    Text(
//        text = stringResource(id = R.string.final_score, score)
//    )
//}

fun checkAnswer(userAnswer: String, correctAnswer: String): Boolean {
    return userAnswer == correctAnswer
}
