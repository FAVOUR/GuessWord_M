package com.example.guessword.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(val score :Int):ViewModel() {

    val  finalScore = MutableLiveData<Int>()
    val  lFinalScore : LiveData<Int>
    get() =finalScore

    init {
        finalScore.value =score
    }


    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }
    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }




}