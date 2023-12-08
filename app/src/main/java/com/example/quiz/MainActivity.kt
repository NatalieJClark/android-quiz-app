package com.example.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.screens.FinalScreenLayout
import com.example.quiz.screens.QuestionOneScreenLayout
import com.example.quiz.screens.QuestionTwoScreenLayout
import com.example.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    // We won't use this `navController` for now,
    // but it's needed to setup the `NavHost`.
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "questionOne") {

        // Here we declare all screens,
        // giving them a "route", which is a unique name
        // for each one.

        composable(route = "questionOne") {
            QuestionOneScreenLayout(onNextScreen = {
                navController.navigate("questionTwo")
            })
        }

        composable(route = "questionTwo") {
            QuestionTwoScreenLayout(onNextScreen = {
                navController.navigate("finalScreen")
            })
        }

        composable(route = "finalScreen") {
            FinalScreenLayout(onNextScreen = {})
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    App()
}
