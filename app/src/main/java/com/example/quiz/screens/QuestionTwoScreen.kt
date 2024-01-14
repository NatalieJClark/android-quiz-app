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
import com.example.quiz.composables.QuestionText
import com.example.quiz.composables.SubmitButton
import com.example.quiz.composables.TitleText
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
