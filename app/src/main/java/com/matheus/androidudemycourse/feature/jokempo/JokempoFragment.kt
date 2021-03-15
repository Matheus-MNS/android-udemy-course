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
            jokempoResult(ROCK)
        }
        binding.paperImageView.setOnClickListener {
            jokempoResult(PAPER)
        }
        binding.scissorsImageView.setOnClickListener {
            jokempoResult(SCISSOR)
        }
    }

    private fun appOpition(): JokempoEnum {

        val r = Random.nextInt(0, 3)
        val optionsList = listOf(ROCK, PAPER, SCISSOR)
        val appChoice = optionsList[r]
        when (appChoice) {

            ROCK -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.rock)
            PAPER -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.paper)
            SCISSOR -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.scissors)
        }
        return appChoice
    }

    private fun choiceComparison(playerChoice: JokempoEnum): Int {

        val winner: Int
        val appChoice = appOpition()
        if ( //App Wins
            (appChoice == SCISSOR && playerChoice == PAPER) ||
            (appChoice == PAPER && playerChoice == ROCK) ||
            (appChoice == ROCK && playerChoice == SCISSOR)
        ) {
            winner = 1
            return winner

        } else if ( //User Wins
            (playerChoice == SCISSOR && appChoice == PAPER) ||
            (playerChoice == PAPER && appChoice == ROCK) ||
            (playerChoice == ROCK && appChoice == SCISSOR)
        ) {
            winner = 2
            return winner

        } else { //Draw
            winner = 3
            return winner
        }
    }

    private fun jokempoResult(playerChoice: JokempoEnum) {
        when (choiceComparison(playerChoice)) {
            1 -> { //App Wins
                binding.instructionTextView.text = getString(R.string.user_lose_text)
            }
            2 -> { //User Wins
                binding.instructionTextView.text = getString(R.string.user_wins_text)
            }
            3 -> { //Draw
                binding.instructionTextView.text = getString(R.string.draw_text)
            }
        }
    }
}

