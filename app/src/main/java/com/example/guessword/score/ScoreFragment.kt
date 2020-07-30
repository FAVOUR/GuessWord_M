package com.example.guessword.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.guessword.R
import com.example.guessword.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    lateinit var  scoreViewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding =  FragmentScoreBinding.inflate(inflater, container, false)

         val scoreViewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
         scoreViewModel = ViewModelProviders.of(this,scoreViewModelFactory)[ScoreViewModel::class.java]

         scoreViewModel.lFinalScore.observe(viewLifecycleOwner, Observer{
             binding.scoreText.text =it.toString()
         })

        return binding.root
    }


}