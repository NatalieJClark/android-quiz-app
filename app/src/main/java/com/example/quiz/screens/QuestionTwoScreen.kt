package com.example.quiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quiz.composables.AnswerField
import com.example.quiz.composables.AnswerValidation
import com.example.quiz.composables.BrandImage
import com.example.quiz.composables.NextButton
import com.example.quiz.composables.TitleText
import com.example.quiz.composables.QuestionText
import com.example.quiz.composables.SubmitButton
import com.example.quiz.composables.checkAnswer

@Composable
fun QuestionTwoScreenLayout(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    var userAnswer by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,

        ) {
        BrandImage()
        TitleText("Question 2:")
        QuestionText("Where would you be, if you were standing on the Spanish Steps?")
        AnswerValidation(resultMessage)
        AnswerField(answer = userAnswer, onValueChange = {userAnswer = it})
        Spacer(modifier = modifier.height(50.dp))
        SubmitButton(onClick = {resultMessage = if (
            checkAnswer(userAnswer = userAnswer, correctAnswer = "Rome")
            )
            "Correct!" else "Try again!"
        })
        NextButton(onNextScreen = onNextScreen, resultMessage = resultMessage)
    }
}

//@Composable
//fun BrandImage(modifier: Modifier = Modifier) {
//    Image(
//        painter = painterResource(id = R.drawable.quiz_logo),
//        contentDescription = "quiz logo",
//        modifier = modifier
//            .padding(30.dp)
//            .fillMaxWidth()
//    )
//}
//
//@Composable
//fun QuestionNumberText(modifier: Modifier = Modifier) {
//    Text(
//        text = "Question 1:",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        modifier = modifier.padding(20.dp)
//    )
//}
//
//@Composable
//fun QuestionText(modifier: Modifier = Modifier) {
//    Text(
//        text = "What's one plus one?",
//        fontSize = 25.sp,
//        modifier = modifier.padding(20.dp)
//    )
//}
//
//@Composable
//fun AnswerValidation(resultMessage: String, modifier: Modifier = Modifier) {
//    Text(
//        text = resultMessage,
//        color = if (resultMessage == "Correct!") Color.Green else Color.Red,
//        modifier = modifier.padding(20.dp)
//    )
//}
//
//@Composable
//fun AnswerField(answer: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    TextField(
//        label = {Text(text = "Type your answer here")},
//        value = answer,
//        onValueChange = onValueChange,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = 30.dp)
//    )
//}
//
//@Composable
//fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
//    Button(
//        onClick = onClick,
//        modifier = modifier.padding(10.dp)
//    ) {
//        Text(
//            text = "Submit",
//            fontSize = 20.sp,
//            modifier = modifier.padding(5.dp)
//        )
//    }
//}
//
//@Composable
//fun NextQuestionButton(onNextScreen: () -> Unit, resultMessage: String, modifier: Modifier = Modifier) {
//    Button(
//        // onNextScreen is declared in App() in MainActivity.kt
//        onClick = onNextScreen,
//        enabled = resultMessage == "Correct!",
//        modifier = modifier.padding(10.dp)
//    ) {
//        Text(
//            text = "Next question",
//            fontSize = 20.sp,
//            modifier = modifier.padding(5.dp)
//        )
//    }
//}
//
//fun checkAnswer(answer: String): Boolean {
//    return answer == "2"
//}

//@Preview(showBackground = true)
//@Composable
//fun ScreenPreview() {
//    QuestionOneScreenLayout()
//}