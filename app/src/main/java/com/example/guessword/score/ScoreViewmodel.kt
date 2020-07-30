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



}