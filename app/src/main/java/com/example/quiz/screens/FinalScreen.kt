package com.example.quiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quiz.composables.BrandImage
import com.example.quiz.composables.TitleText

@Composable
fun FinalScreenLayout(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,

        ) {
        BrandImage()
        TitleText("Congratulation, you completed the quiz!")
        Spacer(modifier = modifier.height(50.dp))
    }
}