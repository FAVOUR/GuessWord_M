package com.example.guessword.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.ClassCastException
import java.lang.IllegalArgumentException

class ScoreViewModelFactory(val score:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)){
           return ScoreViewModel(score) as T
        }else{
            throw IllegalArgumentException(" Class is not an Instance of ${ScoreViewModel::class.java.simpleName}")
        }
    }
}