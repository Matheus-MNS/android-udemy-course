package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentNumbersBinding

class NumbersFragment : Fragment() {

    private lateinit var binding: FragmentNumbersBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumbersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyClick()
    }

    private fun applyClick() {
        with(binding) {
            numberOneImageView.setOnClickListener { playSound(R.raw.one) }
            numberTwoImageView.setOnClickListener { playSound(R.raw.two) }
            numberThreeImageView.setOnClickListener { playSound(R.raw.three) }
            numberFourImageView.setOnClickListener { playSound(R.raw.four) }
            numberFiveImageView.setOnClickListener { playSound(R.raw.five) }
            numberSixImageView.setOnClickListener { playSound(R.raw.six) }
        }
    }

    private fun playSound(Sound: Int) {
        mediaPlayer = MediaPlayer.create(activity, Sound)

        mediaPlayer.apply {
            start()
            setOnCompletionListener {
                release()
            }
        }
    }
}