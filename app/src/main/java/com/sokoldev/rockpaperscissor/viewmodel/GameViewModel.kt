package com.sokoldev.rockpaperscissor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokoldev.rockpaperscissor.model.Choice
import com.sokoldev.rockpaperscissor.model.getResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel : ViewModel() {

    private val _player1Choice = MutableStateFlow<Choice?>(null)
    val player1Choice: StateFlow<Choice?> = _player1Choice

    private val _player2Choice = MutableStateFlow<Choice?>(null)
    val player2Choice: StateFlow<Choice?> = _player2Choice

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    private val _isSinglePlayer = MutableStateFlow(true)
    val isSinglePlayer: StateFlow<Boolean> = _isSinglePlayer

    private val _isPlayer1Turn = MutableStateFlow(true)
    val isPlayer1Turn: StateFlow<Boolean> = _isPlayer1Turn

    fun setGameMode(singlePlayer: Boolean) {
        _isSinglePlayer.value = singlePlayer
        resetGame()
    }

    fun choose(choice: Choice) {
        viewModelScope.launch {
            if (_isSinglePlayer.value) {
                _player1Choice.value = choice
                _player2Choice.value = Choice.entries.toTypedArray()[Random.nextInt(3)]
                _result.value = getResult(_player1Choice.value, _player2Choice.value)
            } else {
                if (_isPlayer1Turn.value) {
                    _player1Choice.value = choice
                } else {
                    _player2Choice.value = choice
                    _result.value = getResult(_player1Choice.value, _player2Choice.value)
                }
                _isPlayer1Turn.value = !_isPlayer1Turn.value
            }
        }
    }

    private fun resetGame() {
        _player1Choice.value = null
        _player2Choice.value = null
        _result.value = ""
        _isPlayer1Turn.value = true
    }
}
