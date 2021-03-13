package com.matheus.androidudemycourse.feature.jokempo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentJokempoBinding
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
            optionSelected(JokempoEnum.ROCK)
        }

        binding.paperImageView.setOnClickListener {
            optionSelected(JokempoEnum.PAPER)
        }

        binding.scissorsImageView.setOnClickListener {
            optionSelected(JokempoEnum.SCISSOR)
        }
    }

    private fun optionSelected(playerChoice: JokempoEnum) {

        val r = Random.nextInt(0, 3)
        val optionList = listOf(JokempoEnum.ROCK, JokempoEnum.PAPER, JokempoEnum.SCISSOR)
        val appChoice = optionList[r]

        when (appChoice) {

            JokempoEnum.ROCK -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.rock)
            JokempoEnum.PAPER -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.paper)
            JokempoEnum.SCISSOR -> binding.placeHolderOpponentImageView.setImageResource(R.drawable.scissors)

        }
        if ( //App Wins
            (appChoice == JokempoEnum.SCISSOR && playerChoice == JokempoEnum.PAPER) ||
            (appChoice == JokempoEnum.PAPER && playerChoice == JokempoEnum.ROCK) ||
            (appChoice == JokempoEnum.ROCK && playerChoice == JokempoEnum.SCISSOR)
        ) {
            binding.instructionTextView.text = getString(R.string.user_lose_text)

        } else if ( //User Wins
            (playerChoice == JokempoEnum.SCISSOR && appChoice == JokempoEnum.PAPER) ||
            (playerChoice == JokempoEnum.PAPER && appChoice == JokempoEnum.ROCK) ||
            (playerChoice == JokempoEnum.ROCK && appChoice == JokempoEnum.SCISSOR)
        ) {

            binding.instructionTextView.text = getString(R.string.user_wins_text)

        } else { //Draw
            binding.instructionTextView.text = getString(R.string.draw_text)
        }
    }
}

