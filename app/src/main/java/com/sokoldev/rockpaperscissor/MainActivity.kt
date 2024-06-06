package com.sokoldev.rockpaperscissor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sokoldev.rockpaperscissor.ui.MainMenuScreen
import com.sokoldev.rockpaperscissor.ui.SinglePlayerScreen
import com.sokoldev.rockpaperscissor.ui.theme.RockPaperScissorTheme
import com.sokoldev.rockpaperscissor.viewmodel.GameViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RockPaperScissorTheme {

                val navController = rememberNavController()
                val gameViewModel: GameViewModel = viewModel()

                NavHost(navController, startDestination = "main_menu") {
                    composable("main_menu") { MainMenuScreen(navController) }
                    composable("single_player") { SinglePlayerScreen(navController, gameViewModel) }
                }
            }
        }
    }
}
