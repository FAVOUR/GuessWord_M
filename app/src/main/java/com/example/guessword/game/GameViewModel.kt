package com.example.guessword.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class GameViewModel :ViewModel() {

    // The current word
     private var word  = MutableLiveData<String>()
     val lWord : LiveData<String>
     get() = word

    // The current score
    private  var score = MutableLiveData<Int>()
     val lScore : LiveData<Int>
     get() = score

    private  var gameFinished = MutableLiveData<Boolean>()
     val lGameFinished : LiveData<Boolean>
     get() = gameFinished


    private  var currentTime = MutableLiveData<Long>()
    val lCurrentTime : LiveData<Long>
        get() = currentTime


    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L

    }


   private val timer :  CountDownTimer





    // The list of words - the front of the list is the next word to guess
     lateinit var wordList: MutableList<String>


    init {


        Log.i("GameViewModel",  "GameViewModel Init")

         word.value= ""

        // The current score
        score.value= 0
        resetList()
        nextWord()

        timer= object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
            override fun onFinish() {
                currentTime.value = DONE
                onGameFinished()
            }

            override fun onTick(millisUntilFinished: Long) {
                currentTime.value = millisUntilFinished /   ONE_SECOND

            }
        }

        timer.start()
    }



    /** Methods for buttons presses **/

     fun onSkip() {
        if (!wordList.isEmpty()) {
            score.value= (score.value)?.minus(1)
        }
        nextWord()
    }


     fun onCorrect() {
        if (!wordList.isEmpty()) {
           score.value= (score.value)?.plus(1)
        }


         nextWord()
    }

    fun onGameFinished(){
        gameFinished.value=true
    }

    fun gameFinishedComplete(){
        gameFinished.value=false
    }



    override fun onCleared() {
        super.onCleared()
        timer.cancel()
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



   val currentTimeString= Transformations.map(currentTime) { time ->
       DateUtils.formatElapsedTime(time)
   }

    /**
     * Moves to the next word in the list
     */
     fun nextWord() {
        if (wordList.isEmpty()) {
            resetList()
        }else{
            word.value = wordList.removeAt(0)
        }
    }


}