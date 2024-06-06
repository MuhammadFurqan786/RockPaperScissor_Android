package com.sokoldev.rockpaperscissor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sokoldev.rockpaperscissor.R
import com.sokoldev.rockpaperscissor.viewmodel.GameViewModel

@Composable
fun MainMenuScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ) {
        // Game Icon, clickable to navigate to Single Player Screen
        Image(
            painter = painterResource(id = R.drawable.rock_paper_game),
            contentDescription = "Game Icon",
            modifier = Modifier
                .size(120.dp)
                .clickable { navController.navigate("single_player") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Game Name
        Text("Rock, Paper, Scissor", style = MaterialTheme.typography.titleMedium)
    }
}
