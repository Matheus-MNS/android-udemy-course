package com.matheus.androidudemycourse.feature.jokempo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentJokempoBinding
import com.matheus.androidudemycourse.feature.jokempo.JokempoEnum.*
import kotlin.random.Random

class JokempoFragment : Fragment() {

    private lateinit var binding: FragmentJokempoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJokempoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClick()
    }

    private fun setupClick() {

        binding.rockImageView.setOnClickListener {
            choiceComparison(ROCK)
        }
        binding.paperImageView.setOnClickListener {
            choiceComparison(PAPER)
        }
        binding.scissorsImageView.setOnClickListener {
            choiceComparison(SCISSOR)
        }
    }

    private fun setAppChoice(): JokempoEnum {
        val r = Random.nextInt(0, 3)
        val optionsList = listOf(ROCK, PAPER, SCISSOR)
        val appChoice = optionsList[r]
        setOpponentImageView(appChoice)

        return appChoice
    }

    private fun setOpponentImageView(appChoice: JokempoEnum) {
        when (appChoice) {
            ROCK -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.rock)
            PAPER -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.paper)
            SCISSOR -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.scissors)
        }
    }

    private fun choiceComparison(playerChoice: JokempoEnum) {
        val appChoice = setAppChoice()
        if ( //App Wins
            (appChoice == SCISSOR && playerChoice == PAPER) ||
            (appChoice == PAPER && playerChoice == ROCK) ||
            (appChoice == ROCK && playerChoice == SCISSOR)
        ) {
            binding.instructionTextView.text = getString(R.string.user_lose_text)
        } else if ( //User Wins
            (playerChoice == SCISSOR && appChoice == PAPER) ||
            (playerChoice == PAPER && appChoice == ROCK) ||
            (playerChoice == ROCK && appChoice == SCISSOR)
        ) {
            binding.instructionTextView.text = getString(R.string.user_wins_text)
        } else { //Draw
            binding.instructionTextView.text = getString(R.string.draw_text)
        }
    }
}

