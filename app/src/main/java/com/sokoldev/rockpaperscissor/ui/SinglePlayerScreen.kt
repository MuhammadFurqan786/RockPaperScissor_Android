package com.sokoldev.rockpaperscissor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sokoldev.rockpaperscissor.model.Choice
import com.sokoldev.rockpaperscissor.ui.theme.Pink40
import com.sokoldev.rockpaperscissor.ui.theme.Pink80
import com.sokoldev.rockpaperscissor.viewmodel.GameViewModel

@Composable
fun SinglePlayerScreen(navController: NavController, gameViewModel: GameViewModel) {
    val playerChoice by gameViewModel.player1Choice.collectAsState()
    val computerChoice by gameViewModel.player2Choice.collectAsState()
    val result by gameViewModel.result.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ) {
        Text("Rock Paper Scissor", style = MaterialTheme.typography.titleLarge, color = Pink80)
        Text("Select Your Choice", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(32.dp))

        // Display all three choices for player 1
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ChoiceImageSelectable(
                choice = Choice.ROCK,
                selected = playerChoice == Choice.ROCK,
                onClick = { gameViewModel.choose(Choice.ROCK) }
            )
            ChoiceImageSelectable(
                choice = Choice.PAPER,
                selected = playerChoice == Choice.PAPER,
                onClick = { gameViewModel.choose(Choice.PAPER) }
            )
            ChoiceImageSelectable(
                choice = Choice.SCISSORS,
                selected = playerChoice == Choice.SCISSORS,
                onClick = { gameViewModel.choose(Choice.SCISSORS) }
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        if (playerChoice != null && computerChoice != null) {
            // Display player and computer choices
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Your Choice")
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = getChoiceImage(playerChoice!!)),
                        contentDescription = playerChoice!!.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(playerChoice!!.name)
                }

                Spacer(modifier = Modifier.width(32.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Computer Choice")
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = getChoiceImage(computerChoice!!)),
                        contentDescription = computerChoice!!.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(computerChoice!!.name)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            if (result == "You Win!") {
                Text(result, color = Color.Blue, style = MaterialTheme.typography.titleLarge)
            } else if (result == "Computer Win!") {
                Text(result, color = Color.Red, style = MaterialTheme.typography.titleLarge)
            } else {
                Text(result, color = Color.Black, style = MaterialTheme.typography.titleLarge)
            }

        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigateUp() }) {
            Text("Back to Menu")
        }
    }
}

@Composable
fun ChoiceImageSelectable(
    choice: Choice,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = getChoiceImage(choice)),
            contentDescription = choice.name,
            modifier = Modifier
                .size(100.dp)
                .clickable { onClick() } // Make the image clickable
                .padding(8.dp) // Add padding for better touch area
        )
        Text(choice.name)
    }
}
