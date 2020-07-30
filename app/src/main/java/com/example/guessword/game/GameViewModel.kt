package com.example.guessword.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel :ViewModel() {

    // The current word
     private var word  = MutableLiveData<String>()
     val lWord : LiveData<String>
     get() = word

    // The current score
    private  var score = MutableLiveData<Int>()
     val lScore : LiveData<Int>
     get() = score


    // The list of words - the front of the list is the next word to guess
     lateinit var wordList: MutableList<String>


    init {


        Log.i("GameViewModel",  "GameViewModel Init")

         word.value= ""

        // The current score
        score.value= 0
        resetList()
        nextWord()
    }



    /** Methods for buttons presses **/

     fun onSkip() {
        if (!wordList.isEmpty()) {
            score.value?.minus(1)
        }
        nextWord()
    }


     fun onCorrect() {
        if (!wordList.isEmpty()) {
            score.value?.plus(1)
        }
        nextWord()
    }





    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


    /**
     * Resets the list of words and randomizes the order
     */
     fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }





    /**
     * Moves to the next word in the list
     */
     fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }
    }


}