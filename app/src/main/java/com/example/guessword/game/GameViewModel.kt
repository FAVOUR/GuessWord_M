package com.example.guessword.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel :ViewModel() {

    init {
        "GameViewModel Init"
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


}