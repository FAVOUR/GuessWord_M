package com.example.guessword.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.guessword.R
import com.example.guessword.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    // The current word
    private var word = ""

    // The current score
    private var score = 0


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewmodel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game, container, false)

        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewmodel = ViewModelProviders.of(this)[GameViewModel::class.java]
        resetList()
        nextWord()

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        updateScoreText()
        updateWordText()
        return binding.root


    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
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



    /** Methods for buttons presses **/

    private fun onSkip() {
        if (!wordList.isEmpty()) {
            score--
        }
        nextWord()
    }


    private fun onCorrect() {
        if (!wordList.isEmpty()) {
            score++
        }
        nextWord()
    }



    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
        updateWordText()
        updateScoreText()
    }



    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = word
    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }



}