package com.sokoldev.rockpaperscissor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.sokoldev.rockpaperscissor.R
import com.sokoldev.rockpaperscissor.model.Choice

@Composable
fun ChoiceImageButton(choice: Choice, onClick: () -> Unit) {
    val imageRes = when (choice) {
        Choice.ROCK -> R.drawable.rock
        Choice.PAPER -> R.drawable.paper
        Choice.SCISSORS -> R.drawable.scissors
    }

    Button(onClick = onClick, modifier = Modifier.padding(8.dp)) {
        Image(painter = painterResource(id = imageRes), contentDescription = choice.name)
    }
}

fun getChoiceImage(choice: Choice): Int {
    return when (choice) {
        Choice.ROCK -> R.drawable.rock
        Choice.PAPER -> R.drawable.paper
        Choice.SCISSORS -> R.drawable.scissors
    }
}
