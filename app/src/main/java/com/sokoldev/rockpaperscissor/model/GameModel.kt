package com.sokoldev.rockpaperscissor.model

enum class Choice {
    ROCK, PAPER, SCISSORS
}

fun getResult(player1: Choice?, player2: Choice?): String {
    if (player1 == null || player2 == null) return ""

    return when {
        player1 == player2 -> "Draw!"
        (player1 == Choice.ROCK && player2 == Choice.SCISSORS) ||
        (player1 == Choice.PAPER && player2 == Choice.ROCK) ||
        (player1 == Choice.SCISSORS && player2 == Choice.PAPER) -> "You Win!"
        else -> "Computer Win!"
    }
}
