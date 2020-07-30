package com.example.guessword.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.guessword.R
import com.example.guessword.databinding.FragmentGameBinding

class GameFragment : Fragment() {


    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game, container, false)

        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this)[GameViewModel::class.java]

        viewModel.lScore.observe(viewLifecycleOwner, Observer {newScore ->

            binding.scoreText.text = newScore.toString()

        })
        /** Setting up LiveData observation relationship **/
        viewModel.lWord.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordText.text = newWord
        })

        viewModel.lGameFinished.observe(viewLifecycleOwner, Observer { isGameFinished ->
           if (isGameFinished) gameFinished()
        })
//            object :Observer<Int>{
//            override fun onChanged(t: Int?) {
//                TODO("Not yet implemented")
//            }
//        }


        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }

        binding.endGameButton.setOnClickListener { onEndGame() }

//        updateScoreText()
//        updateWordText()
        return binding.root


    }


    /** Methods for buttons presses **/

    private fun onSkip() {
        viewModel.onSkip()
//        updateWordText()
//        updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
//        updateScoreText()
//        updateWordText()


    }


    /** Methods for updating the UI **/

//    private fun updateWordText() {
//        binding.wordText.text =viewModel.word
//    }
//
//    private fun updateScoreText() {
//        binding.scoreText.text = viewModel.score.toString()
//    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
//        val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
//        action.score = viewModel.lScore.value ?: 0
//        NavHostFragment.findNavController(this).navigate(action)
//          viewModel.gameFinishedComplete()
    }


    private fun onEndGame() {
        gameFinished()
    }

}